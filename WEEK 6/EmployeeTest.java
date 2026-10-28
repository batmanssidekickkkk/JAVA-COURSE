public class EmployeeTest {
    public static void main(String[] args) {
        Employee emp = new Employee("Jane Doe", 45000.00);
        
        emp.displayEmployeeInfo();

        System.out.println("Giving a raise of KSh 5000...");
        emp.giveRaise(5000.00);

        System.out.println("\nAttempting to give a negative raise (-1000)...");
        emp.giveRaise(-1000.00);

        System.out.println("\nSetting bonus to KSh 8000...");
        emp.setBonus(8000.00);

        System.out.println("\nFinal Employee Status:");
        emp.displayEmployeeInfo();
    }
}

class Employee {
    private String name;
    private double salary;
    private double bonus;

    public Employee(String name, double salary) {
        this.name = name;
        setSalary(salary);
        this.bonus = 0.0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Error: Salary cannot be negative.");
        }
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        if (bonus >= 0) {
            this.bonus = bonus;
        } else {
            System.out.println("Error: Bonus cannot be negative.");
        }
    }

    public void giveRaise(double amount) {
        if (amount > 0) {
            salary += amount;
            System.out.println("Successfully added raise. New base salary: KSh " + salary);
        } else {
            System.out.println("Error: Raise amount must be positive.");
        }
    }

    public void displayEmployeeInfo() {
        System.out.println("Employee Name: " + name);
        System.out.printf("Base Salary: KSh %.2f%n", salary);
        System.out.printf("Bonus: KSh %.2f%n", bonus);
        System.out.printf("Total Compensation: KSh %.2f%n", (salary + bonus));
        System.out.println("--------------------");
    }
}
