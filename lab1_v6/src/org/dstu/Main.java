package org.dstu;

import org.dstu.domain.ITransport;
import org.dstu.domain.Ship;
import org.dstu.domain.Plain;
import org.dstu.util.CsvReader;
import org.dstu.util.SerializeUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("You must specify data file name and serialize file name!");
            return;
        }

        String sourceFile = args[0];
        String binFile = args[1];

        List<String[]> strings = CsvReader.readCsvFile(sourceFile, ";");
        List<ITransport> transport = new ArrayList<>();
        for (String[] line: strings) {
            if (line[0].equals("0")) {
                transport.add(new Ship(line));
            } else {
                transport.add(new Plain(line));
            }
        }

        transport.forEach(System.out::println);

        SerializeUtils.serialize(transport, binFile);
        List<ITransport> newTransport = (List<ITransport>) SerializeUtils.deserialize(binFile);
        System.out.println("Новый транспорт:");
        newTransport.forEach(System.out::println);
    }
}
