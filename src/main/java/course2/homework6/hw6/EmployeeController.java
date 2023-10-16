package course2.homework6.hw6;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private EmployeeService employeeService;
    @GetMapping
    public String test() {
        return "test";
    }
}
