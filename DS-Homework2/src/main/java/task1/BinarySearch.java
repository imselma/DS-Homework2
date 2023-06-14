package task1;

public class BinarySearch {
    // track the number of iterations needed for a search to complete
    public static int numSteps = 0;

    public static int search(Student[] students, int key) {

        int low = 0;
        int high = students.length - 1;

        while (low<=high){
            int middlePoint = low + (high-low) / 2;    //We devide the array in two halves.
            numSteps++; //for every iteration we increase the number of steps.
            if(key < students[middlePoint].getStudentID()){
                high = middlePoint - 1;  // if the searched key is less than the element on the half, we place it in the lower side and update the high pointer
            }
            else if (key > students[middlePoint].getStudentID()){
                low = middlePoint + 1;  //if the searched key is greater than the element on the half, we place it in the greater side and update the lower pointer
            }
            else {
                return middlePoint;  //If they are equal that means key is found, znaci da je key na tom middle pointu
            }


        }
        return -1; //If key is not found
    }
}
