package Lab01;

import javax.swing.JOptionPane;
public class TwoDouble {
    public static void main(String[] args){
        String input = JOptionPane.showInputDialog("Enter the first number: ");
        double firstNumber = Double.parseDouble(input);
        input = JOptionPane.showInputDialog("Enter the second number: ");
        double secondNumber = Double.parseDouble(input);
        double sum = firstNumber + secondNumber;
        JOptionPane.showMessageDialog(null, "The sum of " + firstNumber + " and " + secondNumber + " is " + sum);
        System.exit(0);
    }
}
