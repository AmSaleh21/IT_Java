import java.io.*;

public class FileWrite {
    public static void main(String[] args) {
        FileWriter fwr = null;
        PrintWriter pwr = null;
        
        try {
            fwr = new FileWriter("sample.txt", true);
            pwr = new PrintWriter(fwr);
            pwr.println();
            for(String data : args){
                pwr.println(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                pwr.close();
                fwr.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
