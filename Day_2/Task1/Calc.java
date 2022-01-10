import java.io.*;

public class Calc {
    public static void main(String[] args) {
        double num1 = Double.parseDouble(args[0]);
        double num2 = Double.parseDouble(args[2]);
        String operation = args[1];

        switch(operation){
            case "+":
                System.out.println("Sum is " + (num1+num2));
                break;
            case "-":
                System.out.println("Substraction is " + (num1-num2));
                break;
            case "x":
                System.out.println("Multiplication is " + (num1*num2));
                break;
            case "/":
                System.out.println("Division is " + (num1/num2));
                break;
            case "%":
                System.out.println("Modulo is " + (num1%num2));
                break;
            default:
                System.out.println("invalid operation");
                break;
        }
    }
}
