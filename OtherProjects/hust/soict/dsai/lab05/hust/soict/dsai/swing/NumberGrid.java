package OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGrid extends JFrame {
    private final JButton[] buttons = new JButton[10];
    private JButton btnDelete, btnReset;
    private final JTextField tfDisplay;


    public NumberGrid(){
        tfDisplay = new JTextField();
        tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        // Set tfDisplay more height
        Dimension dimension = tfDisplay.getPreferredSize();
        dimension.height = 20;
        tfDisplay.setPreferredSize(dimension);


        JPanel panelButtons = new JPanel(new GridLayout(4, 3));
        addButtons(panelButtons);
        add(panelButtons);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(tfDisplay, BorderLayout.NORTH);
        cp.add(panelButtons, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Number Grid");
        setSize(200, 200);
        setVisible(true);
    }

    void addButtons(JPanel panelButtons){
        ButtonListener buttonListener = new ButtonListener();
        for(int i = 1; i < 10; i++){
            buttons[i] = new JButton(String.valueOf(i));
            buttons[i].addActionListener(buttonListener);
            panelButtons.add(buttons[i]);
        }

        btnDelete = new JButton("DEL");
        btnDelete.addActionListener(buttonListener);
        panelButtons.add(btnDelete);

        buttons[0] = new JButton("0");
        buttons[0].addActionListener(buttonListener);
        panelButtons.add(buttons[0]);

        btnReset = new JButton("C");
        btnReset.addActionListener(buttonListener);
        panelButtons.add(btnReset);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            if(button.charAt(0) >= '0' && button.charAt(0) <= '9'){
                tfDisplay.setText(tfDisplay.getText() + button);
            } else if(button.equals("DEL")){
                String text = tfDisplay.getText();
                tfDisplay.setText(text.substring(0, text.length() - 1));
            } else {
                tfDisplay.setText("");
            }
        }
    }

    public static void main(String[] args) {
         new NumberGrid();
    }

}
