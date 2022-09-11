package main.java.com.Vladislav.javacore.chapter21;

import java.io.*;

public class ForFun {
    public static void main(String[] args) {
        SecretData myData = new SecretData("zenitchik2010", "arptybn1996");

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Vlad\\Desktop\\serial.txt"))) {
            objectOutputStream.writeObject(myData);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e);
        }

        File file = new File("C:\\Users\\Vlad\\Desktop\\serial.txt");

        System.out.println("After deserializing:\n");

        System.out.println(deserialization(file).toString());
    }

    public static SecretData deserialization (File file) {
        try (ObjectInputStream objInStr = new ObjectInputStream(new FileInputStream(file))) {
            return (SecretData) objInStr.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File was not found: " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("Class was not found: " + e);
        } catch (IOException e) {
            System.out.println("IOexception " + e);
        }
        return null;
    }

}

class SecretData implements Serializable {
    String login;
    transient String password;

    public SecretData(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return "SecretData{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
