package assingment_october;
import java.util.*;

// Employee class
class Employee1 {
    private int id;
    private String name;
    private double salary;

    // Constructor
    public Employee1(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return "Employee1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class EmployeeSortBySalary {
    public static void main(String[] args) {
        // Create a list of employees
        List<Employee1> employees = new ArrayList<>();
        employees.add(new Employee1(101, "Ramesh", 45000));
        employees.add(new Employee1(102, "Suresh", 55000));
        employees.add(new Employee1(103, "Mahesh", 35000));
        employees.add(new Employee1(104, "Rajesh", 60000));

        System.out.println("Before Sorting:");
        for (Employee1 e : employees) {
            System.out.println(e);
        }

        // Sort employees by salary using Comparator
        employees.sort(Comparator.comparingDouble(Employee1::getSalary));

        System.out.println("\nAfter Sorting by Salary (Ascending):");
        for (Employee1 e : employees) {
            System.out.println(e);
        }

        // Sort in descending order (optional)
        employees.sort(Comparator.comparingDouble(Employee1::getSalary).reversed());

        System.out.println("\nAfter Sorting by Salary (Descending):");
        for (Employee1 e : employees) {
            System.out.println(e);
        }
    }
}