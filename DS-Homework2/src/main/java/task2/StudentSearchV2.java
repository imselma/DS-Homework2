package task2;
import task1.BinarySearch;
import task1.Student;

import java.io.IOException;
import java.util.Scanner;

public class StudentSearchV2 {

    public static void main(String[] args) throws IOException {

        System.out.println("Loading the students into the tree...");
        RedBlackTree<Integer, Student> theTree = FileUtils.readFile("C:/Users/selma/OneDrive/Desktop/Global_University_Students.csv");

        int redLinesCounter = theTree.countRedLinks();
        System.out.println("The tree was built with " + redLinesCounter + " red links.");
        System.out.println("==================================");
        System.out.println("System is ready!");

        System.out.println(" ");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the ID of the student you want to retrieve, or enter -1 to exit:");
        int userInput = scanner.nextInt();

        if (userInput != -1) {

            Student student = theTree.get(userInput);
            if (student != null) {

                System.out.println("StudentID: " + student.getStudentID());
                System.out.println("Student name: " + student.getStudentName());
                System.out.println("Date of birth: " + student.getDateOfBirth());
                System.out.println("University name: " + student.getUniversityName());
                System.out.println("Department code: " + student.getDepartmentCode());
                System.out.println("Department name: " + student.getDepartmentName());
                System.out.println("Year of enrolment: " + student.getYearOfEnrolment());

                System.out.println("");

                System.out.println("The student was retrieved in " + theTree.numSteps + " steps.");
            } else {
                System.out.println("The student with this ID doesn't exist!");
                System.out.println("The student was retrieved in " + theTree.numSteps + " steps.");
            }

        } else {
            System.out.println("Thank you for using the student search system! :)");
        }
    }
}

