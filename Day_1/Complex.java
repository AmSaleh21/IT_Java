package compPKg;

import java.io.*;

class ComplexOperations {
	int real, imaginary;
	
	public void setReal(int r) { real = r; }
	public void setImaginary(int i) { imaginary = i; }
	
	public int getReal() { return real; }
	public int getImaginary() { return imaginary; }
	

	public ComplexOperations addComp(ComplexOperations C1){
		ComplexOperations temp = new ComplexOperations();
		
		temp.setReal(C1.getReal() + this.getReal());
		temp.setImaginary(C1.getImaginary() + this.getImaginary());
		
		return temp;
	}

	public ComplexOperations subtractComp(ComplexOperations C1){
		ComplexOperations temp = new ComplexOperations();
		
		temp.setReal(C1.getReal() - this.getReal());
		temp.setImaginary(C1.getImaginary() - this.getImaginary());

		return temp;
	}
}


public class Complex{
	public static void main(String[] args){
		ComplexOperations co = new ComplexOperations();
		co.setReal(3);
		co.setImaginary(4);
		
		ComplexOperations co1 = new ComplexOperations();
		co1.setReal(2);
		co1.setImaginary(6);
		
		ComplexOperations coAdd = new ComplexOperations();
		coAdd = co.addComp(co1);
		
		System.out.println("Complex number: " + coAdd.getReal() + " + " + coAdd.getImaginary() + "i");
		
		ComplexOperations coSub = new ComplexOperations();
		coSub = co.subtractComp(co1);
		
		System.out.println("Complex number: " + coSub.getReal() + " + " + coSub.getImaginary() + "i");
	}
}


