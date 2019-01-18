package code.challenges.intersections;

import java.util.ArrayList;

public class Intersections {
    /*
        Problem: Given two different arrays that contain ranges of numbers, write a function that will find and return all intersections
        Example:
        A: [(0, 2), (3,5), (7, 8) (9,12)]
        B: [(1, 2), (3,6), (8, 9), (10,11)]
        Result: [(1, 2), (3,5), (10,11)]
        Asumptions:
            - The ranges are sorted
            - The values can be +/-
            - A and B can be of two different sizes
            - Values will be unique within each given array

        Test scenarios:
            - 
        */

    public static void findIntersectionsProblem() {
        Node[] arrA = new Node[]{new Node(0, 2), new Node(3, 5), new Node(6, 7), new Node(8, 9), new Node(12, 13)};
        Node[] arrB = new Node[]{new Node(1, 2), new Node(6, 10), new Node(11, 13)};
        
        ArrayList<Node> intersections = findIntersections(arrA, arrB);
    }

    public static ArrayList<Node> findIntersections(Node[] arrA, Node[] arrB) {
        int aSize = arrA.length - 1;
        int bSize = arrB.length - 1;
        int aIndex = 0;
        int bIndex = 0;
        ArrayList<Node> intersections = new ArrayList<>();
        
        while(aIndex <= aSize && bIndex <= bSize) {
          Node aElement = arrA[aIndex];
          Node bElement = arrB[bIndex];
          

          if((aIndex+1) <= aSize) {

          }
          
          // System.out.print("Comparing a values: "+aElement.start+"\t "+aElement.end+"\n");
          // System.out.print("Comparing end values: "+bElement.start+"\t "+bElement.end+"\n");
          
          if(aElement.start > bElement.end) {
            bIndex++;
          } else if(aElement.end < bElement.start) {
            aIndex++;
          } else {
            intersections.add(compareNodes(aElement, bElement));
            
            aIndex++;
            bIndex++;
          }
        }
        return intersections;
      }
      
      public static Node compareNodes(Node a, Node b) {
        int newStart = -1;
        int newEnd = -1;
        
        
        if(a.start == b.start) {
          newStart = a.start; 
        } else if(a.start > b.start) {
          newStart = a.start;
        } else if(a.start < b.start) {
          newStart = b.start; 
        }
        
        if(a.end == b.end) {
          newEnd = a.end;
        } else if(a.end < b.end) {
          newEnd = a.end;
        } else if(a.end > b.end) {
          newEnd = b.end;
        }
        
        Node intersection = new Node(newStart, newEnd);
        System.out.print("Start: "+intersection.start+"\tEnd: "+intersection.end+"\n");
        
        return intersection;
      }

}

class Node{
    int start, end;

    public Node(int start, int end) {
        this.start = start;
        this.end = end;
    }
}