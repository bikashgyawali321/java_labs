
import java.awt.event.*;
import javax.swing.*;

public class SI {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Interest Calculator");
        JTextField principleField = new JTextField(10);
        JTextField rateField = new JTextField(10);
        JTextField yearsField = new JTextField(10);
        JTextField resultField = new JTextField(10);
        JButton findButton = new JButton("FIND SI");

        frame.setLayout(null);

        JLabel label1 = new JLabel("Principle:");
        label1.setBounds(30, 20, 100, 30);
        frame.add(label1);

        principleField.setBounds(140, 20, 150, 30);
        frame.add(principleField);

        JLabel label2 = new JLabel("Rate:");
        label2.setBounds(30, 60, 100, 30);
        frame.add(label2);

        rateField.setBounds(140, 60, 150, 30);
        frame.add(rateField);

        JLabel label3 = new JLabel("Years:");
        label3.setBounds(30, 100, 100, 30);
        frame.add(label3);

        yearsField.setBounds(140, 100, 150, 30);
        frame.add(yearsField);

        findButton.setBounds(90, 140, 120, 30);
        frame.add(findButton);

        resultField.setBounds(140, 180, 150, 30);
        resultField.setEditable(false);
        frame.add(resultField);

        findButton.addActionListener((ActionEvent e) -> {
            try {
                double principle = Double.parseDouble(principleField.getText());
                double rate = Double.parseDouble(rateField.getText());
                double years = Double.parseDouble(yearsField.getText());
                double interest = (principle * rate * years) / 100;
                resultField.setText(String.valueOf(interest));
            } catch (NumberFormatException ex) {
                resultField.setText("Invalid input");
            }
        });

        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
