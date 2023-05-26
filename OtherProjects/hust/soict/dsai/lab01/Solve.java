package OtherProjects.hust.soict.dsai.lab01;

import  javax.swing.JOptionPane;
public class Solve {
    public static void main(String[] args) {
        int option = Integer.parseInt(JOptionPane.showInputDialog(null, "First-degree equation: ax + b = 0 : 1 \nSecond-degree equation: ax^2 + bx + c = 0 : 2 \nSystem of first-degree equation with 2 variables: a11*x + a12*y = b1, a21*x + a22*y = b2 : 3 \nExit: 0"));
        switch (option) {
            case 0 -> System.exit(0);
            case 1 -> {
                int a = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter a: "));
                int b = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter b: "));
                if (a == 0) {
                    if (b == 0) {
                        JOptionPane.showMessageDialog(null, "The equation has infinite solutions");
                    } else {
                        JOptionPane.showMessageDialog(null, "The equation has no solution");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "The equation has one solution: x = " + (-b / a));
                }
            }
            case 2 -> {
                int a1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter a: "));
                int b1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter b: "));
                int c1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter c: "));
                if (a1 == 0) {
                    if (b1 == 0) {
                        if (c1 == 0) {
                            JOptionPane.showMessageDialog(null, "The equation has infinite solutions");
                        } else {
                            JOptionPane.showMessageDialog(null, "The equation has no solution");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "The equation has one solution: x = " + (-c1 / b1));
                    }
                } else {
                    double delta = Math.pow(b1, 2) - 4 * a1 * c1;
                    if (delta < 0) {
                        JOptionPane.showMessageDialog(null, "The equation has no solution");
                    } else if (delta == 0) {
                        JOptionPane.showMessageDialog(null, "The equation has one solution: x = " + (-b1 / (2 * a1)));
                    } else {
                        JOptionPane.showMessageDialog(null, "The equation has two solutions: x1 = " + ((-b1 + Math.sqrt(delta)) / (2 * a1)) + ", x2 = " + ((-b1 - Math.sqrt(delta)) / (2 * a1)));
                    }
                }
            }
            case 3 -> {
                int a11 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter a11: "));
                int a12 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter a12: "));
                int a21 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter a21: "));
                int a22 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter a22: "));
                int b11 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter b1: "));
                int b21 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter b2: "));
                if (a11 * a22 - a12 * a21 == 0) {
                    if (b11 * a22 - b21 * a12 == 0) {
                        JOptionPane.showMessageDialog(null, "The system has infinite solutions");
                    } else {
                        JOptionPane.showMessageDialog(null, "The system has no solution");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "The system has one solution: x = " + ((b11 * a22 - b21 * a12) / (a11 * a22 - a12 * a21)) + ", y = " + ((a11 * b21 - a21 * b11) / (a11 * a22 - a12 * a21)));
                }
            }
        }

    }
}
