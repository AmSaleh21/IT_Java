import reg.Regex;
import java.util.StringTokenizer;

public class cutter {
    public static void main(String[] args) {
        String ip = args[0];
        boolean valid = Regex.isValidIPAddress(ip);
        if(!valid){
            System.out.println("invalid ip");
        }else {
            indexMethod(ip);
            System.out.println("------------");
            tokenizerMethod(ip);
            System.out.println("------------");
            splitMethod(ip);
        }
    }
    static void indexMethod(String src){
        int i;
        String srcRemain;
        do{
             i = src.indexOf(".");
             if(i<0) break;
             srcRemain = src.substring(0,i);
             System.out.println(srcRemain);
             src = src.substring(i+1);
        }while (i < src.length());
        System.out.println(src);
    }
    static void tokenizerMethod(String src){
        StringTokenizer stringTokenizer = new StringTokenizer(src, ".");
        while (stringTokenizer.hasMoreTokens()){
            System.out.println(stringTokenizer.nextToken());
        }
    }
    static void splitMethod(String src){
        String[] srcArr = src.split("\\.");
        for(String sp : srcArr){
            System.out.println(sp);
        }
    }
}
