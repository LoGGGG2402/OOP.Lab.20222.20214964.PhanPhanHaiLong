package OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingAccumulator {
    private final TextField tfInput;
    private final TextField tfOutput;
    private int sum = 0;

    public SwingAccumulator(){
        Container cp = new Container();
        cp.setLayout(new GridLayout(2, 2));

        cp.add(new Label("Enter an Integer: "));

        tfInput = new TextField(10);
        cp.add(tfInput);

        tfInput.addActionListener(new TFInputListener());

        cp.add(new Label("The Accumulated Sum is: "));

        tfOutput = new TextField(10);
        tfOutput.setEditable(false);
        cp.add(tfOutput);
    }

    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int numberIn = Integer.parseInt(tfInput.getText());
            sum += numberIn;
            tfInput.setText("");
            tfOutput.setText(String.valueOf(sum));
        }
    }

    public static void main(String[] args) {
        new SwingAccumulator();
    }
}
