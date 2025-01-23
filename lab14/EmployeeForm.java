
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class EmployeeForm {

    @SuppressWarnings({"ConvertToTryWithResources", "CallToPrintStackTrace"})
    public static void main(String[] args) {
        JFrame frame = new JFrame("Employee Details");
        JLabel nameLabel = new JLabel("Name:");
        JLabel ageLabel = new JLabel("Age:");
        JLabel genderLabel = new JLabel("Gender:");
        JLabel salaryLabel = new JLabel("Salary:");

        JTextField nameField = new JTextField(20);
        JTextField ageField = new JTextField(20);
        JTextField salaryField = new JTextField(20);
        JRadioButton maleRadioButton = new JRadioButton("Male");
        JRadioButton femaleRadioButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        JButton saveButton = new JButton("Save");

        frame.setLayout(null);

        nameLabel.setBounds(30, 20, 100, 30);
        frame.add(nameLabel);
        nameField.setBounds(150, 20, 150, 30);
        frame.add(nameField);

        ageLabel.setBounds(30, 60, 100, 30);
        frame.add(ageLabel);
        ageField.setBounds(150, 60, 150, 30);
        frame.add(ageField);

        genderLabel.setBounds(30, 100, 100, 30);
        frame.add(genderLabel);
        maleRadioButton.setBounds(150, 100, 60, 30);
        femaleRadioButton.setBounds(220, 100, 80, 30);
        frame.add(maleRadioButton);
        frame.add(femaleRadioButton);

        salaryLabel.setBounds(30, 140, 100, 30);
        frame.add(salaryLabel);
        salaryField.setBounds(150, 140, 150, 30);
        frame.add(salaryField);

        saveButton.setBounds(90, 180, 120, 30);
        frame.add(saveButton);

        saveButton.addActionListener((ActionEvent e) -> {
            try {
                String name = nameField.getText();
                String age = ageField.getText();
                String gender = maleRadioButton.isSelected() ? "Male" : "Female";
                String salary = salaryField.getText();
                
                FileWriter fileWriter = new FileWriter("employee.txt", true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                
                bufferedWriter.write("Name: " + name);
                bufferedWriter.newLine();
                bufferedWriter.write("Age: " + age);
                bufferedWriter.newLine();
                bufferedWriter.write("Gender: " + gender);
                bufferedWriter.newLine();
                bufferedWriter.write("Salary: " + salary);
                bufferedWriter.newLine();
                bufferedWriter.write("---------------");
                bufferedWriter.newLine();
                
                bufferedWriter.close();
                JOptionPane.showMessageDialog(frame, "Employee details saved!");
                
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Error saving details.");
            }
        });

        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
