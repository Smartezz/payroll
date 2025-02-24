package ch.etmles.payroll.Employee;

import ch.etmles.payroll.Department.Department;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Employee {

    private @Id @GeneratedValue Long id;
    private String name;
    private String role;

    @Column(unique = true, nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee() {}

    public Employee(String name, String role, String email, Department department) {
        this.name = name;
        this.role = role;
        this.email = email;
        this.department = department;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getRole() { return role; }

    public void setRole(String role) { this.role = role; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public Department getDepartment() { return department; }

    public void setDepartment(Department department) { this.department = department; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(id, employee.id) &&
                Objects.equals(email, employee.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name='" + name + '\'' +
                ", role='" + role + '\'' + ", email='" + email + '\'' +
                ", department=" + (department != null ? department.getName() : "None") + '}';
    }
}
