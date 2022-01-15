import java.io.FileInputStream;
import java.io.IOException;

public class FileOpener {
    public static void main(String[] args) {
        FileInputStream fis = null;
        byte[] b = new byte[10];  //dummy initialization (can be dropped if b is in a block)
        try { //block a
            fis = new FileInputStream("sample.txt"); //read the said file
            int size = fis.available();
            b = new byte[size]; //create an array of bytes (low level reading) of the file size
            fis.read(b); //read in the byte array
        } catch (IOException fne) {
            fne.printStackTrace();
        }finally {
            try {
                System.out.println(new String(b));  //b -should be in block a-
                fis.close(); //close the file
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
