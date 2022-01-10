class PyramidsTwo {
    public static void main(String args[]) {
        int i, j; // variable declaration
		
        int rows  = 6;
        System.out.print("\n");
		
        for (i = 1; i <= rows; i++) {
			
            for (j = 1; j <= 2*i-1; j++) {
                System.out.print("*");
            }
			System.out.print("  ");
            for (j = i; j <= rows; j++) {
                System.out.print("    ");
            }
            for (j = 1; j <= 2 * i - 1; j++) {
                System.out.print(" *");
            }
            System.out.print("\n");
        }
    }
}