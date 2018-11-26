package ru.vlad.patterns.decorator;

import java.io.*;

//Здесь нужно вместо работы с файлом читать/писать данные в БД
public class DaoDataSource implements DataSource {
    private String name;

    public DaoDataSource(String name) {
        this.name = name;
    }

    @Override
    public String readData() {
        File file = new File(name);
        try (InputStream fis = new FileInputStream(file)) {
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer, 0, fis.available());
            char[] charBuffer = new char[buffer.length];
            for (int i = 0; i < buffer.length; i++) {
                charBuffer[i] = (char) buffer[i];
            }
            return String.valueOf(charBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writeData(String data) {
        File file = new File(name);
        try (OutputStream fos = new FileOutputStream(file)) {
            fos.write(data.getBytes(), 0, data.length());
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
