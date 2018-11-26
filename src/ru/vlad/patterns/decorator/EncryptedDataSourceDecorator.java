package ru.vlad.patterns.decorator;

import java.util.Base64;

//Декоратор для шифрования. В качестве примера простое шифрование в  Base64
public class EncryptedDataSourceDecorator extends  DataSourceDecorator{

    public EncryptedDataSourceDecorator(DataSource wrapper) {
        super(wrapper);
    }

    @Override
    public String readData() {
        return decode(super.readData());
    }

    @Override
    public void writeData(String data) {
        super.writeData(encode(data));
    }

    private String encode(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes());
    }

    private String decode(String data) {
        return new String(Base64.getDecoder().decode(data));
    }
}
