package student_result;

import java.util.*;

public class StudentService {

    public Optional<Student> findFirstStudentStartingWithS(List<Student> students) {
        return students.stream()
                .filter(s -> s.getName().startsWith("S"))
                .findFirst();
    }

    public boolean allStudentsScoredAbove35(List<Student> students) {
        return students.stream()
                .allMatch(s -> s.getScore() > 35);
    }

    public OptionalDouble calculateAverageScore(List<Student> students) {
        return students.stream()
                .mapToInt(Student::getScore)
                .average();
    }
}
