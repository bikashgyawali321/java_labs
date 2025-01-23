
import java.awt.event.*;
import javax.swing.*;

public class OperationGUI {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sum and Difference Calculator");
        JTextField num1Field = new JTextField(10);
        JTextField num2Field = new JTextField(10);
        JLabel resultLabel = new JLabel("Result: ");
        JButton calculateButton = new JButton("Calculate");

        frame.setLayout(null);  // Set layout to null for absolute positioning

        // Set bounds for each component
        JLabel label1 = new JLabel("Number 1:");
        label1.setBounds(30, 20, 100, 30);
        frame.add(label1);

        num1Field.setBounds(120, 20, 150, 30);
        frame.add(num1Field);

        JLabel label2 = new JLabel("Number 2:");
        label2.setBounds(30, 60, 100, 30);
        frame.add(label2);

        num2Field.setBounds(120, 60, 150, 30);
        frame.add(num2Field);

        calculateButton.setBounds(90, 100, 120, 30);
        frame.add(calculateButton);

        resultLabel.setBounds(30, 140, 250, 30);
        frame.add(resultLabel);

        calculateButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    int num1 = Integer.parseInt(num1Field.getText());
                    int num2 = Integer.parseInt(num2Field.getText());
                    resultLabel.setText("Sum: " + (num1 + num2));
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input");
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                try {
                    int num1 = Integer.parseInt(num1Field.getText());
                    int num2 = Integer.parseInt(num2Field.getText());
                    resultLabel.setText("Difference: " + (num1 - num2));
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input");
                }
            }
        });

        frame.setSize(300, 220);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
