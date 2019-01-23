package code.challenges.arraysandstrings;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

/*
    Find intersection of 3 sorted arrays

    A: [2, 6, 9, 11, 13, 17]
    B: [3, 6, 7, 10, 13, 18]
    C: [4, 5, 6, 9, 11, 13]
    U: [6, 13]

    Assumptions:
        - Arrays are same size
        - Arrays are sorted
*/
public class IntersectionProblems {
    
    public static void intersectionOf3Arrays(){
        int[] arrA = new int[]{2, 6, 9, 11, 13, 17, 19};
        int[] arrB = new int[]{3, 6, 7, 10, 13, 18, 19};
        int[] arrC = new int[]{4, 5, 6, 9, 11, 13, 19};
        List<Integer> results = new ArrayList<Integer>();
        boolean isComplete = false;


        int size = arrA.length - 1;

        int aIndex = 0, bIndex = 0, cIndex = 0;

        // A: 5
        // B: 5
        while((aIndex <= size && bIndex <= size && cIndex <= size) && !isComplete) {
            Optional<Integer> smallest = findSmallest(arrA[aIndex], arrB[bIndex], arrC[cIndex]);

            if(smallest.isPresent()){
                if(arrA[aIndex] == smallest.get() && aIndex < size) {
                    aIndex++;
                }
    
                if(arrB[bIndex] == smallest.get() && bIndex < size){
                    bIndex++;
                }

                if(arrC[cIndex] == smallest.get() && cIndex < size) {
                    cIndex++;
                }
                System.out.println("Smallest: "+smallest.get());
            } else {
                // All Values Equal
                results.add(Integer.valueOf(arrA[aIndex]));

                if(aIndex < size) {
                    aIndex++;
                }

                if(bIndex < size) {
                    bIndex++;
                }

                if(cIndex < size) {
                    cIndex++;
                }
            }

            if(aIndex == size && bIndex == size && cIndex == size){
                if(arrA[aIndex] == arrB[bIndex] && arrC[cIndex] == arrB[bIndex]){
                    results.add(Integer.valueOf(arrA[aIndex]));
                }
                isComplete = true;
            }
        }

        results.forEach(System.out::println);
    }

    public static Optional<Integer> findSmallest(int a, int b, int c){
        /* 
            a is smallest
                - a < b && a < c
            b is smallest
                - b < a && b < c
            c is smallest
                - c < a && c < b
            
            a & b smallest
                a & b  < c
            b & c smallest
                b & c  < a
            a & c smallest
                a & c  < b
        */
        Optional<Integer> smallest = Optional.empty();

        if(a == b && b == c) {
            return Optional.empty();
        }

        if (a == b) {
            smallest = Optional.of(a);
        } else if(a < b) {
            smallest = Optional.of(a);
        } else {
            smallest = Optional.of(b);
        }

        if(c < smallest.get()) {
            smallest = Optional.of(c);
        }

        return smallest;
    }
}