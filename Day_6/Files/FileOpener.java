import java.io.FileInputStream;
import java.io.IOException;

public class FileOpener {
    public static void main(String[] args) {
        FileInputStream fis = null;
        byte[] b = new byte[10];
        try {
            fis = new FileInputStream("sample.txt");
            int size = fis.available();
            b = new byte[size];
            fis.read(b);
        } catch (IOException fne) {
            fne.printStackTrace();
        }finally {
            try {
                System.out.println(new String(b));
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}