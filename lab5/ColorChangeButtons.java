
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ColorChangeButtons {

    @SuppressWarnings("Convert2Lambda")
    public static void main(String[] args) {
        // Create the JFrame
        JFrame frame = new JFrame("Color Change Buttons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new FlowLayout());

        // Create buttons
        JButton redButton = new JButton("RED");
        JButton blueButton = new JButton("BLUE");
        JButton greenButton = new JButton("GREEN");

        // Add action listeners to handle button clicks
        redButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                redButton.setBackground(Color.RED);
            }
        });

        blueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                blueButton.setBackground(Color.BLUE);
            }
        });

        greenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                greenButton.setBackground(Color.GREEN);
            }
        });

        // Add buttons to the frame
        frame.add(redButton);
        frame.add(blueButton);
        frame.add(greenButton);

        // Make the frame visible
        frame.setVisible(true);
    }
}
