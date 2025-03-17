package ch.etmles.payroll.Department;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    private final DepartmentRepository repository;

    DepartmentController(DepartmentRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<Department> all() {
        return repository.findAll();
    }

    @PostMapping
    Department newDepartment(@RequestBody Department newDepartment) {
        return repository.save(newDepartment);
    }

    @GetMapping("/{id}")
    Department one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found: " + id));
    }

    @PutMapping("/{id}")
    Department replaceDepartment(@RequestBody Department newDepartment, @PathVariable Long id) {
        return repository.findById(id)
                .map(department -> {
                    department.setName(newDepartment.getName());
                    return repository.save(department);
                })
                .orElseGet(() -> {
                    newDepartment.setId(id);
                    return repository.save(newDepartment);
                });
    }

    @DeleteMapping("/{id}")
    void deleteDepartment(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
