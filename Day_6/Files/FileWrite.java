import java.io.*;

public class FileWrite {
    public static void main(String[] args) {
        FileWriter fwr = null;
        PrintWriter pwr = null;
        
        try {
            fwr = new FileWriter("sample.txt", true);  //filewriter constructor to open the file - true flag is to append don't re-write
            pwr = new PrintWriter(fwr); 
            pwr.println();
            for(String data : args){ //append the args data in the file
                pwr.println(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try { //try to close the file
                pwr.close();
                fwr.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
