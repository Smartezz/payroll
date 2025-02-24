package ch.etmles.payroll.Employee;

import ch.etmles.payroll.Employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
