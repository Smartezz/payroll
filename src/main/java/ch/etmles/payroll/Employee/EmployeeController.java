package ch.etmles.payroll.Employee;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /* curl sample :
    curl -i localhost:8080/api/v1/employees
    */
    @GetMapping
    public List<Employee> all() {
        return employeeService.getAllEmployees();
    }

    /* curl sample :
    curl -i -X POST localhost:8080/api/v1/employees ^
        -H "Content-type:application/json" ^
        -d "{\"name\": \"Russel George\", \"role\": \"gardener\", \"email\": \"russel@email.com\"}"
    */
    @PostMapping
    public Employee newEmployee(@RequestBody Employee newEmployee) {
        return employeeService.createEmployee(newEmployee);
    }

    /* curl sample :
    curl -i localhost:8080/api/v1/employees/1
    */
    @GetMapping("/{id}")
    public Employee one(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    /* curl sample :
    curl -i -X PUT localhost:8080/api/v1/employees/2 ^
        -H "Content-type:application/json" ^
        -d "{\"name\": \"Samwise Bing\", \"role\": \"peer-to-peer\", \"email\": \"samwise@email.com\"}"
     */
    @PutMapping("/{id}")
    public Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
        return employeeService.updateEmployee(id, newEmployee);
    }

    /* curl sample :
    curl -i -X DELETE localhost:8080/api/v1/employees/2
    */
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    /* curl sample :
    curl -i -X PATCH localhost:8080/api/v1/employees/1 ^
        -H "Content-type:application/json" ^
        -d "{\"department_id\": 5}"
    */
    @PatchMapping("/{id}")
    public Employee assignDepartment(@PathVariable Long id, @RequestBody Map<String, Long> request) {
        Long departmentId = request.get("department_id");
        if (departmentId == null) {
            throw new IllegalArgumentException("Missing department_id in request body");
        }
        return employeeService.assignDepartment(id, departmentId);
    }
}
