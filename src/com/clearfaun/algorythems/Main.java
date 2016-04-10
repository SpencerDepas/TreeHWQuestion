package com.clearfaun.algorythems;

import java.util.Random;

public class Main {

    static private int number;

    static int[] randomArray;

    public static void main(String[] args) {
	// write your code here
        //


        //Question
        //"Given a sorted (increasing order) array, write an algorithm to create a binary tree with minimal height."



        //make a random int array
        randomArray = randomArray ();


        //quicksort
        //Big worst case 0(n^2)
        //big sort averidge O(log n )
//        System.out.println("my quickSort");
//        quickSort(randomArray);



        System.out.println("some google example of quickSort");
        sort(randomArray);

        System.out.println("print array");
       // printArray(randomArray);


        sortedArrayToBST(randomArray);

        printLevelOrder(1000);
    }

    public static TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0)
            return null;

        return sortedArrayToBST(num, 0, num.length - 1);
    }

    static TreeNode root;

    public static TreeNode sortedArrayToBST(int[] num, int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end) / 2;
        root = new TreeNode(num[mid]);
        root.left = sortedArrayToBST(num, start, mid - 1);
        root.right = sortedArrayToBST(num, mid + 1, end);

        return root;
    }

    public static void printLevelOrder(int depth) {
        for (int i = 1; i <= depth; i++) {
            System.out.print("Level " + (i-1) + ": ");
            String levelNodes = printLevel(root, i);
            System.out.print(levelNodes + "\n");
        }
    }

    public static String printLevel(TreeNode t, int level) {
        if (t == null) {
            return "";
        }
        if (level == 1) {
            return t.val + " ";
        } else if (level > 1) {
            String leftStr = printLevel(t.left, level - 1);
            String rightStr = printLevel(t.right, level - 1);
            return leftStr + rightStr;
        }
        else // you need this to get it to compile
            return "";
    }


    public static void printArray(int[] randomArray){
        for(int i = 0 ; i < randomArray.length; i ++){



            System.out.println(randomArray[i]);
        }

    }

    public static void quickSort(int[] randomArray){

        int pivot = randomArray[randomArray.length -1];
        int wall = 0;




        for(int i = 0 ; i < randomArray.length; i ++){
            for(int z = 0 ; z < randomArray.length; z ++){

                if(randomArray[z] < pivot){

                    int temp =   randomArray[wall];
                    randomArray[wall] = randomArray[z];
                    randomArray[z] = temp;

                    wall++;


                }
                if(z == randomArray.length ){
                    System.out.println("z =" + z);
                    System.out.println("z =" + (randomArray.length -1));

                    int temp = randomArray[wall +1];
                    randomArray[wall +1] = pivot;
                    pivot = temp;


                }


            }
            wall = 0;
        }

        System.out.println("print array");
        printArray(randomArray);

    }


    public static int[] randomArray (){
        //Construct the array we're using here
        int[] newArray = new int[100];

        for(int i = 0 ; i < newArray.length; i ++){


            newArray[i] = (int)(Math.random() * ( 1000   ));
            //System.out.println(newArray[i]);
        }

        return newArray;
    }

    public static void sort(int[] values) {
        // check for empty or null array
        if (values ==null || values.length==0){
            return;
        }
         randomArray = values;
        number = values.length;
        quicksortNotMine(0, number - 1);
    }

    private static void quicksortNotMine(int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = randomArray[low + (high-low)/2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list
            while (randomArray[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while (randomArray[j] > pivot) {
                j--;
            }

            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksortNotMine(low, j);
        if (i < high)
            quicksortNotMine(i, high);
    }

    private static void exchange(int i, int j) {
        int temp = randomArray[i];
        randomArray[i] = randomArray[j];
        randomArray[j] = temp;
    }
}
