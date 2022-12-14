package main.java.com.Vladislav.javacore.chapter22;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExplicitChannelRead2 {
    public static void main(String[] args) {
        int count;

        //Здесь канал открывается по пути, возвращаемому
        //методом Paths.get() в виде объекта типа Path
        //Переменная filepath больше не нужна

        try(SeekableByteChannel fChan = Files.newByteChannel(Paths.get("C:\\Users\\Vlad\\Desktop\\kek3.txt"))) {

            //выделяем память под буфер
            ByteBuffer mBuf = ByteBuffer.allocate(128);

            do {
                //читать данные из файла в буфер
                count = fChan.read(mBuf);

                //прекратить чтение по достижении конца файла
                if(count != -1) {

                    //подготовить буфер к чтению из него данных
                    mBuf.rewind();

                    //читать байты данных из буфера и
                    //выводить их на экран как символы
                    for (int i = 0; i < count; i++) {
                        System.out.print((char)mBuf.get());
                    }
                }
            } while (count != -1);
            System.out.println();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
