package task1;

import java.io.IOException;
import java.util.Scanner;

public class StudentSearchV1 {
    public static void main(String[] args) throws IOException {

        System.out.println("Loading the students...");

        Student[] students = FileUtils.readFile("C:/Users/selma/OneDrive/Desktop/Global_University_Students.csv");
      /*  for (Student student : students) {
            System.out.println(student.getStudentID());
        }*/ //Znaci reading from file ti je dobar!

        System.out.println("Sorting the student array...");
        MergeSort.sort(students);

        System.out.println("Saving the sorted array...");
        FileUtils.writeToFile(students, "C:/Users/selma/OneDrive/Desktop/Global_University_Students_Sorted.csv");

        System.out.println("=================================");
        System.out.println("System is ready!");
        System.out.println("");


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the ID of the student you want to retrieve, or enter -1 to exit:");
        int userInput = scanner.nextInt();
        if (userInput != -1) {

            int result = BinarySearch.search(students, userInput);
            if (result != -1) {

                System.out.println("StudentID: " + students[result].getStudentID());
                System.out.println("Student name: " + students[result].getStudentName());
                System.out.println("Date of birth: " + students[result].getDateOfBirth());
                System.out.println("University name: " + students[result].getUniversityName());
                System.out.println("Department code: " + students[result].getDepartmentCode());
                System.out.println("Department name: " + students[result].getDepartmentName());
                System.out.println("Year of enrolment: " + students[result].getYearOfEnrolment());

                System.out.println("");

                System.out.println("The student was retrieved in " + BinarySearch.numSteps + " steps.");
            } else {
                System.out.println("The student with this ID doesn't exist!");
                System.out.println("The student was retrieved in " + BinarySearch.numSteps + " steps.");
            }

        }
        else {
            System.out.println("Thank you for using the student search system! :)");
        }
    }
}
