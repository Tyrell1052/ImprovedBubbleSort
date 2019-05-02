/*
* Author: Tyrell Robbins
* Program: ImprovedBubbleSort
*
* This program implements the iterative bubbleSort Algorithm with some extra lines of code to improve the efficiency
* of the software, the primary idea of this improved algorithm is to decrease the size of the array after every pass
* through the array, the reason this works is because the last element in the array will be sorted after every pass
* this allows the algorithm to be more efficient by not checking elements in the array that were already sorted.
* */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main{

    public static void bubbleSort(int[] array){
        boolean isSorted = false;
        int lastUnsorted = array.length - 1; /* Here i am creating a variable that will allow me to decrement items in
          the array after it has been sorted */
        while(!isSorted){
            isSorted = true;
            for (int i = 0; i < lastUnsorted; i++){
                if (array[i] > array[i + 1]){
                    swap(array, i, i + 1);
                    isSorted = false;
                }//end if
            }//end for
            lastUnsorted--;  /*  this will enable the bubbleSort algorithm to be more efficient by not attempting to
            sort the very last element int the array because after each pass through the array the very last element
            will be sorted in its correct place in the dataset */
        }//end while
    }//end bubbleSort



    public static void swap(int[] array, int i, int j){ // this method will handle the swapping of the integers out of order

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }//end swap






    public static void main(String[] args) throws Exception {


        for (int k = 1; k<= 100; k++)
        {
            int size = 10000;     // change this number to change the size of the random array
            int[] a = new int[size];
            int[] temp = new int[a.length];  // empty temporary array, the same size and type as a[]

            // fill the array with random integers
            for (int i = 0; i< a.length; i++)
                a[i] = (int)(Math.random()*100000 +1);


            // get the start time in nanoseconds
            long startTime = System.nanoTime();

            //call the improved bubbleSort method to sort the entire array
            bubbleSort(a);

            // get the end time in nanoseconds
            long endTime = System.nanoTime();

            // calculate elapsed time in nanoseconds
            long duration = endTime - startTime;

            // print the elapsed time in seconds   (nanaoseconds/ 1 billion)
            System.out.printf("%12.8f %n", (double)duration/100000000) ;


        }//end for

    }//end main method


}// end Main class