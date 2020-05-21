package Lead;

import java.util.Stack;

/**
 * ************************************************************
 * Purpose/Description: <The program looks to see where the leader index is
 * repeated half way>
 * Author’s Panther ID: 
 * Certification: I hereby certify that this work is my own and none of it is
 * the work of any other person.
 * ************************************************************
 */



/**
 * This is an inner class that has three variables needed for the main class
 *
 */
class Three { // inner class

    int part;

    int num;

    int index;

    Three(int part, int num, int index) {

        this.part = part; // assigns to this variable

        this.num = num; // assigns to this variable

        this.index = index;// assigns to this variable

    }

}

/**
 * This is the main class in which is going to look and return the 
 * index in where the leader is at half way in the list.
 * 
 */
public class LeaderArray {

    public static int leader(int A[]) {

        int index = A.length - 1;// the length - 1 of the array is assigned to index

        Stack<Integer> s = new Stack<Integer>(); // new stack

        for (int i : A) { 
            s.push(i); // adds to the stack
        }

        Three t = new Three(s.peek(), 1, index); // new object t

        while (s.size() > 0) { // size of stack larger than 0

            if (t.part == s.peek()) { // if they are equal

                t.num++; // then increment

            } else {

                t.num--; // if not take away

                if (t.num == 0) { //if equal to 0

                    t.part = s.peek(); // see the stack on top

                    t.num = 1; // make count assigned to 1

                    t.index = s.size() - 1; // size -1 assigned to index

                }

            }

            s.pop(); // shows and deletes

        }

        int counter = 0; // counter to 0

        for (int i = 0; i < A.length; i++) { // for loop

            if (t.part == A[i]) { // if element is equal to whats in the array of index

                t.index = i; // i is set to index

                counter++; // increment

            }

        }

        System.out.println("Element : " + t.part); // prints

        if (counter > A.length / 2) { // if counter is great than array length divided by 2
            return t.index; // return the index
        } else {
            return -1; // if not -1
        }
    }

    /**
     * This is the main and will allow the program to run and test
     *
     *
     */
    public static void main(String[] args) {

        System.out.println(leader(new int[]{23, 23, 67, 23, 67, 23, 45})); // print

        System.out.println(leader(new int[]{23, 24, 67, 23, 67, 23, 45})); // print

    }

}
