package ch.etmles.payroll;

import ch.etmles.payroll.Employee.Employee;
import ch.etmles.payroll.Employee.EmployeeRepository;
import ch.etmles.payroll.Department.Department;
import ch.etmles.payroll.Department.DepartmentRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepo, DepartmentRepository departmentRepo) {
        return args -> {
            Department it = departmentRepo.save(new Department("IT"));
            Department hr = departmentRepo.save(new Department("HR"));

            log.info("Preloading " + employeeRepo.save(new Employee("Bilbo Baggins", "Burglar", "bilbo@shire.com", it)));
            log.info("Preloading " + employeeRepo.save(new Employee("Frodo Baggins", "Ring Bearer", "frodo@shire.com", hr)));
        };
    }
}
