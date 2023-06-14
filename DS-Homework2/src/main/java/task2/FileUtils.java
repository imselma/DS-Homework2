package task2;

import task1.Student;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils {

    public static RedBlackTree<Integer, Student> readFile(String filePath) throws IOException {

        RedBlackTree<Integer, Student> newTree = new RedBlackTree<Integer, Student>(); //Create a RedBlackTree object that will stor ethe info from the file
        FileReader fileReader = new FileReader(filePath); //Reads from the file
        BufferedReader bufferedReader = new BufferedReader(fileReader); // The bufferReader reads from the fileReader, so that in next stepst it can be read line by line, since the readLine()method is in BufferReader library

        //Next while loop reads from the fileReader line by line

        String line; // Variable for storing each line of file
        while ((line = bufferedReader.readLine()) != null) { //While there is a line

            String[] dataFromLine = line.split(";"); // Store the data contained in the line in data array by splitting them with comma
            Integer studentID = Integer.parseInt(dataFromLine[0]);
            String studentName = dataFromLine[1];
            String dateOfBirth = dataFromLine[2];
            String universityName = dataFromLine[3];
            String departmentCode = dataFromLine[4];
            String departmentName = dataFromLine[5];
            Integer yearOfEnrolment = Integer.parseInt(dataFromLine[6]);

            Student student = new Student(studentID, studentName, dateOfBirth, universityName, departmentCode, departmentName, yearOfEnrolment);

            newTree.put(student.getStudentID(), student);
        }
        fileReader.close();
        bufferedReader.close();

        return newTree;
    }
}
