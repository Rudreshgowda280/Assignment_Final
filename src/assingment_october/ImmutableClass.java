package assingment_october;

public class ImmutableClass {
    public static void main(String[] args) {

        Employee emp1 = new Employee(101, "Alice", 55000.50);
        Employee emp2=new Employee(102,"rudresh",30000);
        emp1.display();
        emp2.display();


    }
}

// Immutable Employee class
final class Employee {

    private final int id;
    private final String name;
    private final double salary;

    // Constructor to initialize all fields
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Getters only (no setters)
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void display()
    {
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Salary: " + getSalary());
    }

}

