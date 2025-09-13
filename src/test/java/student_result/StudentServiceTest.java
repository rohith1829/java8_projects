package student_result;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

class StudentServiceTest {

    private final StudentService service = new StudentService();

    private final List<Student> students = Arrays.asList(
            new Student(1, "Sam", 80),
            new Student(2, "Alice", 60),
            new Student(3, "Steve", 70),
            new Student(4, "Bob", 40),
            new Student(5, "Charlie", 50)
    );

    @Test
    void testFindFirstStudentStartingWithS() {
        Optional<Student> student = service.findFirstStudentStartingWithS(students);
        assertTrue(student.isPresent());
        assertEquals("Sam", student.get().getName());
    }

    @Test
    void testAllStudentsScoredAbove35() {
        assertTrue(service.allStudentsScoredAbove35(students));
    }

    @Test
    void testCalculateAverageScore() {
        OptionalDouble avg = service.calculateAverageScore(students);
        assertTrue(avg.isPresent());
        assertEquals(60.0, avg.getAsDouble(), 0.01);
    }

    @Test
    void testEmptyStudentList() {
        List<Student> emptyList = new ArrayList<>();
        OptionalDouble avg = service.calculateAverageScore(emptyList);
        assertFalse(avg.isPresent());
    }
}
