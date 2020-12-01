package Banks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Serializable {
    final String fileName = "bank.txt";
    public void serMethodWrite(){
        try {
            FileOutputStream outputStream = new FileOutputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void serMethodRead() {
        try {
            FileInputStream inputStream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
