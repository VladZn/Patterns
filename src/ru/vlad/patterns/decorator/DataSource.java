package ru.vlad.patterns.decorator;

public interface DataSource {
    String readData();

    void writeData(String data);
}
