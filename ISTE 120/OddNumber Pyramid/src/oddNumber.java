//**********************************************
//         Program by Nicolas Salomon
//    Program that asks a user for an odd number
//    from 1-49. A pyramid will be automatically
//                  generated
//                   9/22/17
//**********************************************

import java.util.*;

public class oddNumber {

    public static void main(String[] args) {
       run();
    }

    public static void run(){
        int integer = 0; //declaring input number
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter an odd number from 1 to 49 (Enter 99 to end): "); //asking user for their input

        integer = in.nextInt();

        if(integer == 99){ //if int = 99 then the program quits
            System.out.println("Exiting");
            System.exit(1);
        }

        if(integer % 2 == 0 || integer > 49){ //if the integer is even, will ask for it again.
            checkInt(integer);
        } else {
            drawPattern(integer);
        }
    }

    public static void checkInt(int x){ //takes care of asking the user to input another number again and again until its odd from 0->49
        Scanner in = new Scanner(System.in);
        System.out.println("Please re-enter an odd number from 1 to 49 (Enter 99 to end): ");
        x = in.nextInt();

        if(x == 99){
            System.out.println("Exiting");
            System.exit(2);
        }

        if(x %2 == 0 || x > 49){
            checkInt(x);
        } else {
            drawPattern(x);
        }
    }

    public static void drawPattern(int n) {
        Scanner in = new Scanner(System.in);
            //Draw Top Part
            for (int i = 0; i < n; i++) {
                if (i != 1 && i % 2 == 0) {
                    for (int j = 0; j < n - i; j++) {
                        System.out.print(" ");
                    }
                    for (int k = 0; k <= i; k++) {
                        System.out.print("* ");
                    }
                    System.out.println();
                }
            }
            //Draw Bottom Part
            for (int i = 0; i < n; i++) {
                if (i != 1 && i % 2 == 0) {
                    System.out.print("  ");
                    for (int j = (n - 2); j >= (n - 2) - i; j--) {
                        System.out.print(" ");
                    }
                    for (int k = (n - 2); k > i; k--) {
                        System.out.print("* ");
                    }
                    System.out.println();
                }
            }
            //runs the program again after the program runs once
            run();

        }

    }

