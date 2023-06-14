package task1;

public class Student implements Comparable<Student> {

    private Integer studentID;
    private String studentName;
    private String dateOfBirth;
    private String universityName;
    private String departmentCode;
    private String departmentName;
    private Integer yearOfEnrolment;

    public Student (Integer studentId, String studentName, String dateOfBirth, String universityName, String departmentCode, String departmentName, Integer yearOfEnrolment){

        this.studentID = studentId;
        this.studentName = studentName;
        this.dateOfBirth = dateOfBirth;
        this.universityName = universityName;
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.yearOfEnrolment = yearOfEnrolment;
    }

    @Override
    public int compareTo(Student o) {

        if (this.studentID < o.studentID){
            return -1;  //If the current student'S ID is smaller than other student's ID
        }
        else if (this.studentID > o.studentID){
            return 1;  //If the current student'S ID is greater than other student's ID
        }
        else {
            return 0;  //If the current student'S ID is equal to the other student's ID
        }
    }

    //getters methods -> needted for writing in the file
    public int getStudentID(){
        return this.studentID;
    }

    public String getStudentName(){
        return this.studentName;
    }

    public String getDateOfBirth(){
        return this.dateOfBirth;
    }

    public String getUniversityName(){
        return this.universityName;
    }

    public String getDepartmentCode(){
        return this.departmentCode;
    }
    public String getDepartmentName(){
        return this.departmentName;
    }

    public int getYearOfEnrolment(){
        return this.yearOfEnrolment;
    }
}

