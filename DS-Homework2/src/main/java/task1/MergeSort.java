package task1;

import java.util.Comparator;

public class MergeSort {

    public static void sort(Student[] students) {
        int lengthOfArray = students.length;

        //If the array has only 1 element or zero it is already sorted.
        if(lengthOfArray<2){
            return;
        }

        int middleIndex = lengthOfArray/2; //determining the middle index or the half of the array
        Student[] leftHalf = new Student[middleIndex];
        Student[] rightHalf = new Student[lengthOfArray-middleIndex]; //Subtraction because if array has 9 Student objects, the middle element would be 4 and on the right size we have 9-4=5 elments

        /*In the next lines of code, using for loop we will divide the input array, by copying objects in left and right
        array, terminating them by the length and middleIndex. Recursively calling the sort() we will be left with 1-item arrays that are ready for sorting*/

        for (int i = 0; i<middleIndex; i++){  //fil the left side
            leftHalf[i] = students[i];
        }

        for (int i = middleIndex; i<lengthOfArray; i++){
            rightHalf[i-middleIndex] = students[i]; //i-middleIndex because to set the index to 0 at the rigtArray
        }

        //recursive call
        sort(leftHalf);
        sort(rightHalf);

        merge(students,leftHalf,rightHalf);



    }

    public static void merge (Student[] students, Student[] leftHalf, Student[] rightHalf){

        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        //Elements from left and right array are merging until there is no elment left in the arrays
        int i=0; //to treminate the leftArray
        int j=0; //to terminate the rightArray
        int k=0; //to terminate the sortedArray

        while (i<leftSize && j<rightSize){
            if(leftHalf[i].getStudentID() < rightHalf[j].getStudentID()){
                students[k] = leftHalf[i];
                i++;
            }
            else if (leftHalf[i].getStudentID() > rightHalf[j].getStudentID()){
                students[k] = rightHalf[j];
                j++;
            }

            k++;
        }
        /*If maybe one of the arrays is not empty, but the other is, it will exit the above loop.
          That's why I observe the arrays separately as well, in case that in one of them are elemnets left after comparing.*/

        while (i<leftSize){
            students[k]=leftHalf[i];
            i++;
            k++;
        }

        while(j<rightSize){
            students[k] = rightHalf[j];
            j++;
            k++;
        }

    }

}
