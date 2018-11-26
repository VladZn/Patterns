package ru.vlad.patterns;

import ru.vlad.patterns.decorator.*;

public class Main {
    public static void main(String[] args) {
        String str = "This is a secret message!";
        String fileName = "out/123.txt";
        DataSourceDecorator sourceDecorator = new CompressedDataSourceDecorator(new EncryptedDataSourceDecorator(new DaoDataSource(fileName)));
        sourceDecorator.writeData(str);

        DataSource dataSource = new DaoDataSource(fileName);

        System.out.println("----------------------------------------------");
        System.out.println("Input data:");
        System.out.println(str);
        System.out.println("----------------------------------------------");
        System.out.println("Encoded data:");
        System.out.println(dataSource.readData());
        System.out.println("----------------------------------------------");
        System.out.println("Decoded data:");
        System.out.println(sourceDecorator.readData());
    }
}
