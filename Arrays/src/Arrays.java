//**********************************************************
//               Program by Nicolas Salomon
//  Program that creates and loads an array of 10 values
//                      9/20/2017
//**********************************************************

import java.util.*;

public class Arrays {

    public static void main(String[] args) {
        int MyArray[] = new int[10];
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        int max = MyArray[0];
        int min;

        //Number Inputs
        for(int i=0; i<10; i++){
            System.out.println("Input Integer Number "+(i+1)+": ");
            MyArray[i] = in.nextInt();
        }

        System.out.println("---------------------");
        System.out.println(" ");

        //Looking for Max Num
        for(int i=0; i<10; i++){
            if(max < MyArray[i]){
                max = MyArray[i];
            }
        }
        System.out.println("Max Number: "+max);
        System.out.println(" ");

        //Looking for Min Num
        min = MyArray[0];
        for(int i=0; i<10; i++){
            if(min > MyArray[i]){
                min = MyArray[i];
            }
        }
        System.out.println("Min Number "+min);
        System.out.println(" ");

        //Looking for Even Numbers
        System.out.print("Even Numbers: ");
        for(int i=0; i<10; i++){
            if(MyArray[i] % 2 == 0){
                System.out.print(MyArray[i] + ". ");
            }
        }


    }
}
