import java.util.ArrayList;
import java.util.List;

/**
 * A class to encapsulate the basic information of a student.
 * The basic information includes the student ID, name and GPA.
 */
class Student {
    /**
     * Student ID.
     */
    String stuID;

    /**
     * The name of the student.
     */
    String name;

    /**
     * GPA of the student.
     */
    float GPA;

    /**
     * Constructor of a Student object. You can use this method to construct a Student.
     * @param stuID a {@link String} to represent student ID.
     * @param name a {@link String} to name.
     * @param GPA a double to represent GPA score of the student.
     */
    public Student(String stuID, String name, float GPA) {
        this.stuID = stuID;
        this.name = name;
        this.GPA = GPA;
    }

    /**
     * Returns the student ID of the Student.
     * @return student ID of the Student.
     */
    public String getStuID() {
        return stuID;
    }

    /**
     * Returns the name of the Student.
     * @return name of the Student.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the GPA score of the Student.
     * @return GPA score of the Student.
     */
    public float getGPA() {
        return GPA;
    }

    /**
     * Sets the GPA score of the Student to the new GPA score specified by the parameter GPA.
     * @param GPA the new GPA score of the student.
     */
    public void setGPA(float GPA) {
        this.GPA = GPA;
    }

    /**
     * Override the toString method.
     * @return a {@link String} of dumped class
     * @see Student
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Student ID: " ).append(stuID).append("\n");
        builder.append("Student name: ").append(name).append("\n");
        builder.append("Student GPA: ").append(GPA).append("\n\n");
        return builder.toString();
    }
}

/**
 * This class is the major class for the JavaDoc Lab in COMP3111
 * @author mcding
 * @since 2017-11-20
 */
public class JavaDocLab {

    /**
     * This method sort the students in a student list (parameter) by their student ID in alphabetical order.
     * @param studentList the student list.
     * @return sorted studentList.
     */
    public static List<Student> sortByStuId(List<Student> studentList) {
        return studentList.sort(Comparator.comparing(Student::getName));
    }


    /**
     * Get the student with the highest GPA amond all students in the student list.
     * @param studentList the student list.
     * @return the {@link Student} with the highest GPA.
     */
    public static Student getHighestGPA(List<Student> studentList) {
        float max = -1f;
        Student highestGPAStudent = null;
        for (Student student : studentList) {
            float GPA = student.getGPA();
            if (GPA > max) {
                max = GPA;
                highestGPAStudent = student;
            }
        }
        return highestGPAStudent;
    }

    /**
     * Main method.
     * @param args args.
     */
    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("20170000", "Tom", 3.0f));
        studentList.add(new Student("20170003", "Jerry", 3.8f));
        studentList.add(new Student("20170006", "Spark", 3.5f));

        System.out.println("The student list contains " + studentList.size() + " students:\n");

        for (Student student : studentList) {
            System.out.println(student);
        }

        Student highestGPAStu = getHighestGPA(studentList);

        if (highestGPAStu != null) {
            System.out.println(highestGPAStu.getName() + " has the highest GPA: " + highestGPAStu.getGPA());
        }
    }
}
