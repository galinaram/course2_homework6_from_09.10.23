package course2.homework6.hw6;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<Employee>();
    private int maxEmployees;

    public void addEmployee (String firstName, String secondName) {
        if (employees.size() > maxEmployees) {
            throw new EmployeeAlreadyAddedException("лист переполнен");
        }
        int size;
        if (employees.isEmpty()) {
            size = 0;
        } else {
            size = employees.size() + 1;
        }
        employees.add(size, new Employee(firstName, secondName));
        System.out.println("сотрудник добавлен");
    }
    public void deleteEmployee (String firstName, String secondName) {
        if (employees.isEmpty()) {
            throw new EmployeeAlreadyAddedException("лист пустой");
        }
        for (int i = 0; i < employees.size(); i++) {
            Employee tmp = new Employee(employees.get(i));
            if (Objects.equals(tmp.getFirstName(), firstName) & Objects.equals(tmp.getSecondName(), secondName)) {
//                for (int j = i; j < employees.size(); j++) {
//                    employees.add(j, employees.get(j++));
//                }
                employees.remove(i);
                System.out.println("сотрудник удалён");
            }
        }
    }
    public String printEmployee(int index) {
        return employees.get(index).getFirstName() + employees.get(index).getSecondName();
    }
    public int getSize () {
        return employees.size();
    }
//    public void add1 (String firstName, String secondName) {
//        System.out.println("получили: " + firstName + " " + secondName);
//        employees.add(0, new Employee(firstName, secondName));
//        System.out.println(employees.get(0).toString());
//    }

    public void findEmployee(String firstName, String secondName) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.contains(new Employee(firstName, secondName))) {
                System.out.println("сотрудник найден");
            }
        }
    }
}
