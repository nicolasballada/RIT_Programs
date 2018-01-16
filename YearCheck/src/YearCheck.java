//**************************************************
//         Program by Nicolas Salomon
// A Year Checking app between the years of 1950 and
//         2022, accounting for Leap Years
//                  09/15/2017
// **************************************************

import java.util.*;

public class YearCheck {

    //Creating public day, month and year integers
    public static int day;
    public static int month;
    public static int year;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Asking user if they would like to start the application
        System.out.println("Would you like to run YearCheck Application? (Y/N)");
        String answer = scanner.next();
        if (Objects.equals(answer, "y") || Objects.equals(answer, "Y")) {
            yearCheck();
        } else {
            System.out.println("Exiting . . .");
            System.exit(1);
        }
    }

    public static void yearCheck() {
        Scanner in = new Scanner(System.in);

        //Month, Day and Year Inputs
        System.out.println("Please input the Month");
        month = in.nextInt();
        System.out.println("Please input the Day");
        day = in.nextInt();
        System.out.println("Please input the Year");
        year = in.nextInt();

        //main boolean which links to boolean method
        boolean dayC = dayCheck(day, month, year);

        System.out.println(" ");
        System.out.println("--------------------------------");

        //Gets answer from method and selects whether it is valid or not (With options to re-run application)
        if (dayC) {
            System.out.println(" ");
            System.out.println("The Date is VALID!");

            System.out.println("Would you like to run YearCheck Application again? (Y/N)");
            String answer = in.next();
            if (Objects.equals(answer, "y") || Objects.equals(answer, "Y")) {
                yearCheck();
            } else {
                System.out.println("Exiting . . .");
                System.exit(1);
            }
        } else {
            System.out.println(" ");
            System.out.println("The Date is INVALID!");

            System.out.println("Would you like to run YearCheck Application again? (Y/N)");
            String answer = in.next();
            if (Objects.equals(answer, "y") || Objects.equals(answer, "Y")) {
                yearCheck();
            } else {
                System.out.println("Exiting . . .");
                System.exit(1);
            }
        }
    }

    public static Boolean dayCheck(int x, int y, int z) {

        if (year <= 2022 && year >= 1950) { //Checking if year is within the correct ranges
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) { //Checking whether month is a "31" month
                if (day < 32) { //Checking whether day is 31 or less
                    return true;
                } else {return false;}
            } else if (month == 4 || month == 6 || month == 9 || month == 11) { //Checking whether month is a "30" month
                if (day < 31) { //Checking whether day is 30 or less
                    return true;
                } else {return false;}
            } else if (year % 4 == 0 && month == 2) { //Checking for February & Leap year
                if (day < 30) { //Checking if day is 29 or less
                    return true;
                } else {return false;}
            } else if(year % 4 != 0 && month == 2){ //Checking for February and NOT Leap year
                if(day < 29) { //Checking if day is 28 or less
                    return true;
                } else {return false;}
        }
            else {return false;}

        } else {return false;}

    }

}
