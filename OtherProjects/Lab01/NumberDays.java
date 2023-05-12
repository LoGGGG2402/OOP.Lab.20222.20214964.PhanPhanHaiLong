package OtherProjects.Lab01;

import java.util.Scanner;
public class NumberDays {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter month: ");
        int month = keyboard.nextInt();
        System.out.print("Enter year: ");
        int year = keyboard.nextInt();
        int days = 0;
        switch (month) {
            case 1, 3, 5, 7, 10, 8, 12 -> days = 31;
            case 2 -> {
                if (year % 400 == 0) {
                    days = 29;
                }else if (year % 100 == 0) {
                    days = 28;
                }else if (year % 4 == 0) {
                    days = 29;
                }else {
                    days = 28;
                }
            }
            case 4, 9, 11, 6 -> days = 30;
            default -> System.out.println("Invalid month");
        }
        System.out.println("There are " + days + " days in " + month + "/" + year);

    }
}
