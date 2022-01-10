class Pyramids {
    public static void main(String args[]) {
        int i, j; // variable declaration
		
        int rows  = 6;
        System.out.print("\n");
		
        for (i = 1; i <= rows; i++) {
			for (j = i; j <= rows; j++) {
                System.out.print(" ");// print space
            }
            for (j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");// print star
            }
            for (j =  i; j <= 2 * rows - 1; j++) {
                System.out.print(" ");// print space
            }
            for (j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }

    }

}