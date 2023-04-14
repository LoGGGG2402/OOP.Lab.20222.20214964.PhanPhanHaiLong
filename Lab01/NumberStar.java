package Lab01;

import java.util.Scanner;
public class NumberStar {
    public static void main(String args[]){
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = keyboard.nextInt();
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number-i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2*i-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
