package ru.vlad.patterns.decorator;

public class DataSourceDecorator implements DataSource {
    private DataSource wrapper;

    public DataSourceDecorator(DataSource wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public String readData() {
        return wrapper.readData();
    }

    @Override
    public void writeData(String data) {
        wrapper.writeData(data);
    }
}
