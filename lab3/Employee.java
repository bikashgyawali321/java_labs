
import java.io.*;

@SuppressWarnings("unused")
public class Employee {

    public static void main(String[] args) {
        EmployeeWriter emp1 = new EmployeeWriter(101, "John Doe", "HR", 50000.00);
        EmployeeWriter emp2 = new EmployeeWriter(102, "Jane Smith", "Finance", 60000.00);
        EmployeeWriter emp3 = new EmployeeWriter(103, "Alice Johnson", "IT", 75000.00);

        String filename = "emp.doc";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(emp1);
            oos.writeObject(emp2);
            oos.writeObject(emp3);

            System.out.println("Employee objects written to " + filename);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}

class EmployeeWriter implements Serializable {

    private static final long serialVersionUID = 1L;
    private final String name;
    private final int id;
    private final String department;
    private final double salary;

    public EmployeeWriter(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [ID: " + id + ", Name: " + name
                + ", Department: " + department + ", Salary: " + salary + "]";
    }
}
