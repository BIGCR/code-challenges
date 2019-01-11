package code.challenges.hourglass;

public class HourGlass {
    /** 
     * 
     * Instructions can be found https://www.hackerrank.com/challenges/2d-array/problem
     * 
     * 
     */

    /**   0  1  2 3 4  5
    0    -9 -9 -9 1 1  1 
    1     0 -9  0 4 3  2
    2    -9 -9 -9 1 2  3
    3     0  0  8 6 6  0
    4     0  0  0 -2 0 0
    5     0  0  1  2 4 0
    **/

    /**

        Thoughts:
            - 3 -> 1 -> 3 makes an hour glass
            - Never care about j, j+1 when in smallest part of hour glass

        Potential Solution:
            - Send a 3 X 3 matrix into a function which does calculation
            - Store 

        Assumptions:
            - Can be negative numbers
            - Array will ONLY have 16 hour glasses
    **/

    public static void sumHourGlassesFromMatrix() {
        int[][] values = new int[][] {
            { -9, -9, -9, 1, 1, 1 }, 
            { 0, -9,  0, 4, 3, 2 },
            { -9, -9, -9, 1, 1, 2, 3 },
            { 0, 0, 8, 6, 6, 0 },
            { 0, 0, 0, -2, 0, 0 },
            { 0, 0, 1, 2, 4, 0 }, 
        };

        //Every Row
        for(int i = 0; i < 6; i++) {
            if(i >= 4) {
                System.out.println("Should have jumped out!"); 
                break;
            }

            //Every column aside from outer columns
            for(int j = 1; j < 5; j++) {
                int[][] tempValues = new int[][] {
                    { values[i][j-1], values[i][j], values[i][j+1] },
                    { values[i+1][j-1], values[i+1][j], values[i+1][j+1] },
                    { values[i+2][j-1], values[i+2][j], values[i+2][j+1] },
                };

                sumValues(tempValues);
            }
        }
    }

    public static int sumValues(int[][] values) {
        int sum = 0;

        //Uncomment to display index values during runtime
        // for(int i = 0; i < 3; i++){
        //     for(int j = 0; j < 3; j++){
        //         System.out.print("\t"+"index: "+i+","+j+"\t"+values[i][j]);
        //     }
        //     System.out.print("\n\n\n");
        // }

        //Sum top
        sum += values[0][0] + values[0][1] + values[0][2];
        //Sum only middle element
        sum += values[1][1];
        //sum only bottom
        sum += values[2][0] + values[2][1] + values[2][2];
        
        System.out.println("\nSum is: "+sum+"\n");
        return sum;
    }
}