package util;

import java.io.*;
import java.util.List;

public class FileUtil<E> {
    public List<E> readDataFromFile(String filePath){
        if(filePath== null || filePath.trim().equals("")){
            return null;
        }
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))){
            return (List) objectInputStream.readObject();
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
    public void  writeDataToFile(String filePath, List<E> data){
        if(filePath== null || filePath.trim().equals("")){
            return;
        }
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))){
            objectOutputStream.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
