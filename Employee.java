// Employee.java
public class Employee extends Person {
    private String employeeId;
    private String role;

    public Employee() {
        super();
        this.employeeId = "emp-0";
        this.role = "Operator";
    }

    public Employee(String id, String name, int age, String employeeId, String role) {
        super(id, name, age);
        this.employeeId = employeeId;
        this.role = role;
    }

    // getters & setters
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    @Override
    public String toString() {
        return String.format("%s, EmployeeID:%s, Role:%s", super.toString(), employeeId, role);
    }
}
