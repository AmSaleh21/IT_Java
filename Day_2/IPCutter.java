import java.util.regex.*;
import java.io.*;

public class IPCutter {
    public static boolean isValidIPAddress(String ip){
            // If the IP address is empty return false
            if(ip == null){
                return false;
            }
    
            // Regex for digit from 0 to 255.
            String zeroTo255 = "(\\d{1,2}|(0|1)\\" + "d{2}|2[0-4]\\d|25[0-5])";
     
            // Regex for a digit from 0 to 255 and
            // followed by a dot, repeat 4 times.
            // this is the regex to validate an IP address.
            String regex = zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;
     
            // Compile the ReGex
            Pattern p = Pattern.compile(regex);
     
            // find matching between given IP address and regular expression.
            Matcher m = p.matcher(ip);
     
            // Return if the IP address matched the ReGex
            return m.matches();
        }
    
    public static void main(String[] args) {
        String ip = args[0];
        boolean isIP = isValidIPAddress(ip);
        
        //check if the argument is an ip
        if(!isIP){
            System.out.println("not an ip");
            return;
        }

        int i; //mover index
        do{
            //cut the string
            i = ip.indexOf(".");
            if(i < 0){
				break;
			}
            String s1 = ip.substring(0,i);
            System.out.println(s1);
            ip = ip.substring(i+1);
            
        }while(i < ip.length());
        System.out.println(ip);
	}
}