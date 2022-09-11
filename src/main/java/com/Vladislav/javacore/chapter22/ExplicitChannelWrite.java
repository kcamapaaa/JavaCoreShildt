package main.java.com.Vladislav.javacore.chapter22;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ExplicitChannelWrite {
    public static void main(String[] args) {

        //получить канал к файлу в блоке try с ресурсами
        try (FileChannel fChan = (FileChannel) Files.newByteChannel(Paths.get("C:\\Users\\Vlad\\Desktop\\kek4.txt"),
                StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            //создать буфер
            ByteBuffer mBuf = ByteBuffer.allocate(26);

            //записать некоторое количество байтов в буфер
            for (int i = 0; i < 26; i++) {
                mBuf.put((byte) ('A' + i));
            }
            //подготовить буфер к записи
            mBuf.rewind();

            //записать данные из буфера в выходной файл
            fChan.write(mBuf);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
