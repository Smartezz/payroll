package ch.etmles.payroll.Department;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class DepartmentNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(DepartmentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String departmentNotFoundHandler(DepartmentNotFoundException ex) {
        return ex.getMessage();
    }
}
