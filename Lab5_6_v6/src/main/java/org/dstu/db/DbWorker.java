package org.dstu.db;

import java.sql.*;

public class DbWorker {


    public static boolean getFromDbByLastName(String last_name){
        Connection conn = DbConnection.getConnection();
        boolean flag = false;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM student_result WHERE last_name = '"+last_name+"' ");
            while (rs.next()) {
                flag = true;
            }
            rs.close();
            st.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return flag;
    }

    public static void saveFromForm(String name, String second_name, String last_name, String subject, String result){
        Connection conn = DbConnection.getConnection();
        try {
            Statement st = conn.createStatement();
            st.execute("INSERT INTO student_result (name,second_name,last_name,subject,result) " +
                    "VALUES ('"+name+"','"+second_name+"','"+last_name+"','"+subject+"','"+result+"') ");
            st.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
