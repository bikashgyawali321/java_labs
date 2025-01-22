
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class LoginForm {

    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton cancelButton;

    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                LoginForm window = new LoginForm();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public LoginForm() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(200, 200, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel userIdLabel = new JLabel("User ID:");
        userIdLabel.setBounds(50, 60, 100, 25);
        frame.getContentPane().add(userIdLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 60, 200, 25);
        frame.getContentPane().add(usernameField);
        usernameField.setColumns(10);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 100, 100, 25);
        frame.getContentPane().add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 200, 25);
        frame.getContentPane().add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(150, 150, 100, 30);
        frame.getContentPane().add(loginButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(260, 150, 100, 30);
        frame.getContentPane().add(cancelButton);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (authenticate(username, password)) {
                JOptionPane.showMessageDialog(frame, "Login Successful!");
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid User ID or Password!");
            }
        });

        cancelButton.addActionListener(e -> {
            usernameField.setText("");
            passwordField.setText("");
            usernameField.requestFocus();
        });

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'l' || e.getKeyChar() == 'L') {
                    String username = usernameField.getText();
                    String password = new String(passwordField.getPassword());
                    if (authenticate(username, password)) {
                        JOptionPane.showMessageDialog(frame, "Login Successful!");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Invalid User ID or Password!");
                    }
                } else if (e.getKeyChar() == 'c' || e.getKeyChar() == 'C') {
                    usernameField.setText("");
                    passwordField.setText("");
                    usernameField.requestFocus();
                }
            }
        });

        frame.setFocusable(true);
    }

    @SuppressWarnings("CallToPrintStackTrace")
    private boolean authenticate(String username, String password) {

        String url = "jdbc:mysql://localhost:3306/mydb";
        String dbUser = "root";
        String dbPassword = "bikash@123";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, dbUser, dbPassword);

            String query = "SELECT * FROM user WHERE username = ? AND password = ?";
            try (PreparedStatement pst = connection.prepareStatement(query)) {
                pst.setString(1, username);
                pst.setString(2, password);

                ResultSet rs = pst.executeQuery();
                return rs.next();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
