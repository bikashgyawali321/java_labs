
import javax.swing.*;

public class HelloWorld {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello World Program");
        JTextField textField = new JTextField(20);
        JButton button = new JButton("Click Me");

        button.addActionListener(e -> textField.setText("Hello World"));

        JPanel panel = new JPanel();
        panel.add(textField);
        panel.add(button);

        frame.add(panel);
        panel.setSize(200, 200);
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
