package ru.vlad.patterns.decorator;

import java.io.*;
import java.util.Base64;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class CompressedDataSourceDecorator extends DataSourceDecorator {

    public CompressedDataSourceDecorator(DataSource source) {
        super(source);
    }

    @Override
    public String readData() {
        return decompress(super.readData());
    }

    private String decompress(String readData) {
        byte[] buffer = Base64.getDecoder().decode(readData);
        ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
        try {
            GZIPInputStream gzipInputStream = new GZIPInputStream(bais);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int i;
            while ((i=gzipInputStream.read()) != -1){
                baos.write(i);
            }
            bais.close();
            baos.close();
            gzipInputStream.close();
            return new String(baos.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void writeData(String data) {
        super.writeData(compress(data));
    }

    private String compress(String data) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            GZIPOutputStream outputStream = new GZIPOutputStream(baos);
            outputStream.write(data.getBytes());
            outputStream.flush();
            outputStream.close();
            return Base64.getEncoder().encodeToString(baos.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
