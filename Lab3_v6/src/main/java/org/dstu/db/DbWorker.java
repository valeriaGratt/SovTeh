package org.dstu.db;

import org.dstu.util.CsvReader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DbWorker {
    public static void populateFromFile(String fileName) {
        List<String[]> strings = CsvReader.readCsvFile(fileName, ";");
        Connection conn = DbConnection.getConnection();
        try {
            Statement cleaner = conn.createStatement();
            System.out.println(cleaner.executeUpdate("DELETE FROM plain"));
            System.out.println(cleaner.executeUpdate("DELETE FROM ship"));
            PreparedStatement plainSt = conn.prepareStatement(
                    "INSERT INTO plain (name, maxPassengers, maxBags, stewardessNumber, maxHeight, company) " +
                            "VALUES (?, ?, ?, ?, ?, ?)");
            PreparedStatement shipSt = conn.prepareStatement(
                    "INSERT INTO ship (name, maxPassengers, maxBags, length, captainName, maxSpeed) " +
                            "VALUES (?, ?, ?, ?, ?, ?)");

            for (String[] line: strings) {
                if (line[0].equals("1")) {
                    plainSt.setString(1, line[1]);
                    plainSt.setInt(2, Integer.parseInt(line[2]));
                    plainSt.setInt(3, Integer.parseInt(line[3]));
                    plainSt.setInt(4, Integer.parseInt(line[4]));
                    plainSt.setInt(5, Integer.parseInt(line[5]));
                    plainSt.setString(6, line[6]);
                    plainSt.addBatch();
                } else {
                    shipSt.setString(1, line[1]);
                    shipSt.setInt(2, Integer.parseInt(line[2]));
                    shipSt.setInt(3, Integer.parseInt(line[3]));
                    shipSt.setInt(4, Integer.parseInt(line[4]));
                    shipSt.setString(5, line[5]);
                    shipSt.setInt(6, Integer.parseInt(line[6]));
                    shipSt.addBatch();
                }
            }
            int[] stRes = plainSt.executeBatch();
            int[] teacherRes = shipSt.executeBatch();
            for (int num: stRes) {
                System.out.println(num);
            }

            for (int num: teacherRes) {
                System.out.println(num);
            }
            cleaner.close();
            plainSt.close();
            shipSt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void demoQuery() {
        Connection conn = DbConnection.getConnection();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ship WHERE length > 100");
            while (rs.next()) {
                System.out.print(rs.getString("name"));
                System.out.print(" ");
                System.out.print(rs.getString("maxPassengers"));
                System.out.print(" ");
                System.out.println(rs.getString("captainName"));
                System.out.print(" ");
            }
            rs.close();
            st.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void dirtyReadDemo() {
        Runnable first = () -> {
            Connection conn1 = DbConnection.getNewConnection();
            if (conn1 != null) {
                try {
                    conn1.setAutoCommit(false);
                    conn1.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
                    Statement upd = conn1.createStatement();
                    upd.executeUpdate("UPDATE plain SET maxHeight = maxHeight + 1000");
                    Thread.sleep(2000);
                    conn1.rollback();
                    upd.close();
                    Statement st = conn1.createStatement();
                    System.out.println("In the first thread:");
                    ResultSet rs = st.executeQuery("SELECT * FROM plain");
                    while (rs.next()) {
                        System.out.println(rs.getString("maxHeight"));
                    }
                    st.close();
                    rs.close();
                    conn1.close();
                } catch (SQLException | InterruptedException throwables) {
                    throwables.printStackTrace();
                }
            }
        };

        Runnable second = () -> {
            Connection conn2 = DbConnection.getNewConnection();
            if (conn2 != null) {
                try {
                    Thread.sleep(500);
                    conn2.setAutoCommit(false);
                    conn2.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
                    Statement st = conn2.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM plain");
                    while (rs.next()) {
                        System.out.println(rs.getString("maxHeight"));
                    }
                    rs.close();
                    st.close();
                    conn2.close();
                } catch (SQLException | InterruptedException throwables) {
                    throwables.printStackTrace();
                }
            }
        };
        Thread th1 = new Thread(first);
        Thread th2 = new Thread(second);
        th1.start();
        th2.start();
    }
}
