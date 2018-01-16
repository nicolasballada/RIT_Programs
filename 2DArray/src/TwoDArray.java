//*********************************************
//         Program by Nicolas Salomon
//   Program that allows users to enter integer
//   data into a two-dimensional array and then
//    print those values into a table format
//                  9/22/17
//*********************************************

import java.util.*;

import static java.lang.Integer.MAX_VALUE;

public class TwoDArray {

    public static int[][] myTable = new int[5][6];

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner in = new Scanner(System.in);
        int n = 0;
        int max = myTable[0][0];
        int min = myTable[0][0];
        int x = 5;
        int y = 6;

        //Inputs
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                int rand_int = rand.nextInt(999);
               // System.out.println("Please Input Value (" + (j+1) + "," + (i+1) + ")");
                myTable[i][j] = rand_int;

                if(i == x){
                    n++;
                }
            }
        }

        //Print Table
        for(int i=0; i<x; i++){
            System.out.println(" ");
            for(int j=0; j<y; j++){
                System.out.print(myTable[i][j] + "\t");
            }
        }

        System.out.println(" ");
        System.out.println("---");

        //Printing Average
        System.out.println("Average of Integers: " + getAverage());
        System.out.println(" ");

        //Looking for Max Num
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++) {
                if (max < myTable[i][j]) {
                    max = myTable[i][j];
                }
            }
        }
        System.out.println("Max Number: "+max);
        System.out.println(" ");

        //Looking for Min Num
        min = myTable[0][0];
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++) {
                if (min > myTable[i][j]) {
                    min = myTable[i][j];
                }
            }
        }
        System.out.println("Min Number "+min);

    }

    //Calculating Average
    private static double getAverage(){
        int number=0;
        double add = 0;
        for(int i=0;i<myTable.length;i++){
            for(int j=0;j<myTable[i].length;j++){
                add = add+myTable[i][j];
                number++;
            }
        }

        return add / number;
    }





}
