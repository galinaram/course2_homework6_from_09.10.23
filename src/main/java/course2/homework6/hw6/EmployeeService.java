package course2.homework6.hw6;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {
    private List<Employee> employees ;
    private int maxEmployees;

    public void addEmployee (String firstName, String secondName) {
        if (employees.size() > maxEmployees) {
            throw new EmployeeAlreadyAddedException("лист переполнен");
        }
        int size = employees.size() + 1;
        Employee tmp = new Employee(firstName, secondName);
        employees.add(size, tmp);
        System.out.println("сотрудник добавлен");
    }
    public void deleteEmployee (String firstName, String secondName) {
        if (employees.isEmpty()) {
            throw new EmployeeAlreadyAddedException("лист пустой");
        }
        for (int i = 0; i < employees.size(); i++) {
            Employee tmp = new Employee(employees.get(i));
            if (Objects.equals(tmp.getFirstName(), firstName) & Objects.equals(tmp.getSecondName(), secondName)) {
                for (int j = i; j < employees.size(); j++) {
                    employees.add(j, employees.get(j++));
                }
            }
        }
    }
    public String printEmployee(int index) {
        return employees.get(index).toString();
    }
    public int size () {
        return employees.size();
    }
}
