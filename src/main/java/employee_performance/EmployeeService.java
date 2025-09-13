package employee_performance;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeService {

    public List<Employee> getITEmployeesWithHighSalary(List<Employee> employees) {
        return employees.stream()
                .filter(e -> "IT".equalsIgnoreCase(e.getDepartment()) && e.getSalary() > 50000)
                .collect(Collectors.toList());
    }

    public long countHREmployees(List<Employee> employees) {
        return employees.stream()
                .filter(e -> "HR".equalsIgnoreCase(e.getDepartment()))
                .count();
    }

    public Optional<Employee> findHighestPaidEmployee(List<Employee> employees) {
        return employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
    }
}
