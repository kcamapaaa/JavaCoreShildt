package main.java.com.Vladislav.javacore.chapter22;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MappedChannelRead {
    public static void main(String[] args) {

        //получить канал к файлу в блоке
        //оператора try с русурсами

        try(FileChannel fChan = (FileChannel) Files.newByteChannel(Paths.get("C:\\Users\\Vlad\\Desktop\\kek3.txt"))) {

            //получить размер файла
            long fSize = fChan.size();

            // а теперь отобразить файл в буфер
            MappedByteBuffer mBuf = fChan.map(FileChannel.MapMode.READ_ONLY, 0, fSize);

            //читать байты из буфера и выводить их на экран
            for (int i = 0; i < fSize; i++) {
                System.out.print((char) mBuf.get());

                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
