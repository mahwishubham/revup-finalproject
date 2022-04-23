import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class Main {

    private static AtomicLong studentidCounter = new AtomicLong();
    private static AtomicLong teacheridCounter = new AtomicLong();
    public static Map<String, Student> studentList = new HashMap<>();
    public static Map<String, Teacher> teacherList = new HashMap<>();

    public static String createID(AtomicLong idCounter) { return String.valueOf(idCounter.getAndIncrement()); }

    public static void main(String[] args) {
        String run = "yes";
        School gpls = new School(teacherList, studentList);
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(
                    "Please select one of the below options: \n" +
                            "1. Add new Students. \n" +
                            "2. Add new Teachers. \n" +
                            "3. Pay Fees of a Student. \n" +
                            "4. Pay Salary to a Teacher. \n" +
                            "5. Get School Information"
            );

            int count;

            try {
                int n = Integer.parseInt(sc.nextLine());
                switch (n) {
                    case 1:
                        System.out.println("Enter number of student's information you want to feed to the system.");
                        count = Integer.parseInt(sc.nextLine());
                        while (count > 0) {
                            System.out.println("Enter Student Name: ");
                            String name = sc.nextLine();
                            System.out.println("Enter Student Grade: ");
                            int grade = Integer.parseInt(sc.nextLine());
                            studentList.put(name, new Student(
                                    createID(studentidCounter),
                                    name,
                                    grade));
                            count--;
                        }
                        break;
                    case 2:
                        System.out.println("Enter number of teachers's information you want to feed to the system.");
                        count = Integer.parseInt(sc.nextLine());
                        while (count > 0) {
                            System.out.println("Enter Tecaher Name: ");
                            String name = sc.nextLine();
                            System.out.println("Enter Teacher Salary: ");
                            int salary = Integer.parseInt(sc.nextLine());
                            teacherList.put(name, new Teacher(
                                    createID(teacheridCounter),
                                    name,
                                    salary));
                            count--;
                        }
                        break;
                    case 3:
                        System.out.println("Enter Student name to pay fees.");
                        String sname = sc.nextLine();
                        System.out.println("Enter Amount To Be Paid");
                        int amount = Integer.parseInt(sc.nextLine());
                        studentList.get(sname).payFees(amount);
                        System.out.println("Remaining Fees of a student is " + studentList.get(sname).getRemainingFees());
                        break;
                    case 4:
                        System.out.println("Enter Teachers Name to pay their salary");
                        String tname = sc.nextLine();
                        teacherList.get(tname).receiveSalary(teacherList.get(tname).getSalary());
                        System.out.println(teacherList.get(tname).toString());
                        break;

                    case 5:
                        System.out.println( "School Total Earning" + gpls.getTotalMoneyEarned() +
                                "\n School Total Spent" + gpls.getTotalMoneySpent()
                        );
                        System.out.println("List of students in School");
                        for (Map.Entry<String, Student> entry : studentList.entrySet()) {
                            System.out.println(entry.getValue().getName());
                        }
                        System.out.println("List of teachers in School");
                        for (Map.Entry<String, Teacher> entry : teacherList.entrySet()) {
                            System.out.println(entry.getValue().getName());
                        }

                    default:
                        System.out.println("This software is under development. More options coming soon...");
                }

                System.out.println("Do you want to continue ? ");
                run = sc.nextLine();
            } catch (Exception e) {
                System.out.println("Exception Occured In Code " + e.getMessage());
            }
        } while(run.equalsIgnoreCase("yes"));
        sc.close();
    }
}