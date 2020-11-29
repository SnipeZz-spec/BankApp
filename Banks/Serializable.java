package Banks;

import java.io.*;

public class Serializable {

    public void serialization(Object obj, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(obj);
        } catch (FileNotFoundException ex) {
            System.err.println("Файл не найден:");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.err.println("Ошибка входа/выхода:");
            ex.printStackTrace();
        }
    }

    public Object deSerialization(String fileName) {
        Object obj = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            obj = ois.readObject();
        } catch (FileNotFoundException ex) {
            System.err.println("Файл не найден:");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.err.println("Ошибка входа/выхода:");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.err.println("Класс не найден:");
            ex.printStackTrace();
        }
        return obj;
    }

}
