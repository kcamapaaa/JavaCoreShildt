package main.java.com.Vladislav.javacore.chapter22;

import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExplicitChannelRead {
    public static void main(String[] args) {
        int count;
        Path filepath = null;

        //сначала получить путь к файлу
        try {
            filepath = Paths.get("C:\\Users\\Vlad\\Desktop\\kek3.txt");
        } catch (InvalidPathException e) {
            System.out.println("Path Error " + e);
            return;
        }

        //затем получить канал к этому файлу в
        //блоке оператора try с ресурсами
        try (SeekableByteChannel fChan = Files.newByteChannel(filepath)) {

            //выделить память под буфер
            ByteBuffer bBuf = ByteBuffer.allocate(128);

            do {
                //читать данные из файла в буфер
                count = fChan.read(bBuf);

                //прекратить чтение по достижению конца файла
                if(count != -1) {

                    //подготовить буфер к чтению по достижении конца файла
                    bBuf.rewind();

                    //читать байты данных из буфера и
                    //выводить их на экран как символы
                    for (int i = 0; i < count; i++) {
                        System.out.print((char) bBuf.get());
                    }
                }
                System.out.println();
            } while (count != -1);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e);
        }
    }
}
