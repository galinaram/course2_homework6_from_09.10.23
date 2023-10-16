package course2.homework6.hw6;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService = new EmployeeService();
    @GetMapping
    public String test() {
        return "test";
    }
    @GetMapping("/add")
    public String add(@RequestParam("firstName") String firstName, @RequestParam("secondName") String secondName) {

        System.out.println(firstName + " " + secondName);
        System.out.println("запускаем сервис ");
        employeeService.addEmployee(firstName, secondName);
        return employeeService.printEmployee(employeeService.getSize()-1);
    }
    @GetMapping("/delete")
    public String delete (@RequestParam("firstName") String firstName, @RequestParam("secondName") String secondName) {
        employeeService.deleteEmployee(firstName, secondName);
        return "done";
    }
    @GetMapping("/find")
    public String find (@RequestParam("firstName") String firstName, @RequestParam("secondName") String secondName) {
        employeeService.findEmployee(firstName, secondName);
        return "done";
    }
}
