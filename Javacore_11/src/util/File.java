package util;

import java.io.*;

public class File {
    public static Object[] readDataFromFile(String fileName){
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))){
            return (Object[]) objectInputStream.readObject();
        }catch (IOException | ClassNotFoundException e){
        }
        return null;
    }
    public static void writeDataToFile(Object[] data, String fileName){
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))){
            objectOutputStream.writeObject(data);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
