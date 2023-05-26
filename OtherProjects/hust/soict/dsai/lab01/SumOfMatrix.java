package OtherProjects.hust.soict.dsai.lab01;

import java.util.Scanner;
public class SumOfMatrix {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = keyboard.nextInt();
        System.out.print("Enter the number of columns: ");
        // Sum of two matrices
        int columns = keyboard.nextInt();
        int[][] matrix1 = new int[rows][columns];
        int[][] matrix2 = new int[rows][columns];
        int[][] sum = new int[rows][columns];
        System.out.println("Enter the elements of matrix 1: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter element [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrix1[i][j] = keyboard.nextInt();
            }
        }
        System.out.println("Enter the elements of matrix 2: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter element [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrix2[i][j] = keyboard.nextInt();
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sum[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        System.out.println("The sum of two matrices is: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }
    }
}
