import java.util.*;

/**
 * Many teachers, many students.
 * Implements teachers and student
 * using an ArrayList.
 */
public class School {

    private Map<String, Teacher> teachers;
    private Map<String, Student> students;
    private static int  totalMoneyEarned;
    private static int totalMoneySpent;

    /**
     * new school object is created.
     * @param teachers list of teachers in the school.
     * @param students list of students int the school.
     */
    public School(Map<String, Teacher> teachers, Map<String, Student> students) {
        this.teachers = teachers;
        this.students = students;
        totalMoneyEarned=0;
        totalMoneySpent=0;
    }

    /**
     *
     * @return the list of teachers int the school.
     */
    public Map<String, Teacher> getTeachers() {
        return teachers;
    }

    /**
     * Adds a teacher to the school.
     * @param teacher the teacher to be added.
     */
    public void addTeacher(String name, Teacher teacher) {
        teachers.put(name, teacher);
    }

    /**
     *
     * @return the list of students in the school.
     */
    public Map<String, Student> getStudents() {
        return students;
    }

    /**
     * Adds a student to the school
     * @param student the student to be added.
     */
    public void addStudent(String name, Student student) { students.put(name, student); }

    /**
     *
     * @return the total money earned by the school.
     */
    public int getTotalMoneyEarned() {
        return totalMoneyEarned;
    }

    /**
     * Adds the total money earned by the school.
     * @param MoneyEarned money that is supposed to be  added.
     */
    public static void updateTotalMoneyEarned(int MoneyEarned) {
        totalMoneyEarned += MoneyEarned;
    }

    /**
     *
     * @return the total money spent by the school.
     */
    public int getTotalMoneySpent() {
        return totalMoneySpent;
    }

    /**
     * update the money that is spent by the school which
     * is the salary given by the school to its teachers.
     * @param moneySpent the money spent by school.
     */
    public static void updateTotalMoneySpent(int moneySpent) {
        totalMoneyEarned-=moneySpent;
    }
}