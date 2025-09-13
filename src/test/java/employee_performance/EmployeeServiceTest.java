package employee_performance;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

class EmployeeServiceTest {

    private final EmployeeService service = new EmployeeService();

    private final List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", "IT", 60000),
            new Employee(2, "Bob", "HR", 40000),
            new Employee(3, "Charlie", "Finance", 70000),
            new Employee(4, "David", "IT", 55000),
            new Employee(5, "Eve", "HR", 45000),
            new Employee(6, "Frank", "IT", 30000),
            new Employee(7, "Grace", "Finance", 80000)
    );

    @Test
    void testGetITEmployeesWithHighSalary() {
        List<Employee> result = service.getITEmployeesWithHighSalary(employees);
        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(e -> e.getDepartment().equals("IT")));
        assertTrue(result.stream().allMatch(e -> e.getSalary() > 50000));
    }

    @Test
    void testCountHREmployees() {
        long count = service.countHREmployees(employees);
        assertEquals(2, count);
    }

    @Test
    void testFindHighestPaidEmployee() {
        Optional<Employee> highest = service.findHighestPaidEmployee(employees);
        assertTrue(highest.isPresent());
        assertEquals("Grace", highest.get().getName());
    }

    @Test
    void testMultipleHighestPaidEmployees() {
        List<Employee> tieEmployees = Arrays.asList(
                new Employee(1, "A", "IT", 90000),
                new Employee(2, "B", "Finance", 90000)
        );
        Optional<Employee> highest = service.findHighestPaidEmployee(tieEmployees);
        assertTrue(highest.isPresent());
        assertEquals(90000, highest.get().getSalary());
    }

    @Test
    void testEmptyEmployeeList() {
        List<Employee> emptyList = new ArrayList<>();
        Optional<Employee> highest = service.findHighestPaidEmployee(emptyList);
        assertTrue(highest.isEmpty());
    }
}
