package OtherProjects.hust.soict.dsai.lab01;

import java.util.Scanner;
public class InputFromKeyboard {
    public static void main(String args[]){
        Scanner keyboard = new Scanner(System.in);
        System.out.print("What's your name: ");
        String name = keyboard.nextLine();
        System.out.println("How old are you: ");
        int age = keyboard.nextInt();
        System.out.println("How tall are you (m): ");
        double height = keyboard.nextDouble();
        System.out.println("Mr/Ms. " + name + ", " + age + " years old. Your height is " + height + " m.");
    }
}
