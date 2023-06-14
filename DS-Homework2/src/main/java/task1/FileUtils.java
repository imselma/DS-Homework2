package task1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader; // in order to use the readLine() method, that reads a file line by line
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class FileUtils {

    public static Student[] readFile(String filePath) throws IOException {

        List<Student> listOfStudents = new ArrayList<>(); //In this ArrayList the objects of class Student will be stored
        FileReader fileReader = new FileReader(filePath); //Reads from the file
        BufferedReader bufferedReader = new BufferedReader(fileReader); // The bufferReader reads from the fileReader, so that in next stepst it can be read line by line, since the readLine()method is in BufferReader library

        //Next while loop reads from the fileReader line by line

        String line; // Variable for storing each line of file
        while ((line = bufferedReader.readLine()) != null){ //While there is a line

            String[] dataFromLine = line.split(";"); // Store the data contained in the line in data array by splitting them with comma
            Integer studentID = Integer.parseInt(dataFromLine[0]);
            String studentName = dataFromLine[1];
            String dateOfBirth = dataFromLine[2];
            String universityName = dataFromLine[3];
            String departmentCode = dataFromLine[4];
            String departmentName = dataFromLine[5];
            Integer yearOfEnrolment = Integer.parseInt(dataFromLine[6]);

            Student student = new Student(studentID, studentName, dateOfBirth, universityName, departmentCode, departmentName, yearOfEnrolment);
            listOfStudents.add(student); //made a student object and add to the arrayList listOfStudents

        }
        fileReader.close();
        bufferedReader.close();

        //Because the returning type is an array and not an arrayList, we need to covert the arrayList to array

        Student[] students = new Student[listOfStudents.size()]; //Array with size of number of the students
        listOfStudents.toArray(students);

        return students;
    }

    public static void writeToFile(Student[] students, String filePath) throws IOException {

        FileWriter fileWriter = new FileWriter(filePath); //To write in new file
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        //Write student objects from student array line by line in new file
        for (Student student:students){
            String line = student.getStudentName() + "," +
                    student.getStudentID() + "," +
                    student.getDateOfBirth() + "," +
                    student.getUniversityName() + "," +
                    student.getDepartmentCode() + "," +
                    student.getDepartmentName() + "," +
                    student.getYearOfEnrolment();

            bufferedWriter.write(line);
            bufferedWriter.newLine(); //we inserted bufferedWriter because of newLine, jus fileWriter didn't supported that method
        }
    }
}
