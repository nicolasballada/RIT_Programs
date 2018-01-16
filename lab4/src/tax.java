//*************************************************
//          Program by: Nicolas Salomon
// Program that determines tax rates based on age
//              weight and gender
//                  10/06/17
//*************************************************

import java.util.*;

public class tax {

    public static boolean male;
    public static boolean female;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Asking user if they would like to initiate the program
        System.out.println("------------------------------------------");
        System.out.println("Would you like to run Tax Calculation Application? (Y/N)");
        String answer = scanner.next();
        if (Objects.equals(answer, "y") || Objects.equals(answer, "Y")) {
            run();
        } else {
            System.out.println("Exiting");
            System.exit(1);
        }
    }

    public static void run() {
        Scanner in = new Scanner(System.in);

        System.out.println();

        //Input Name
        System.out.print("Please input your First Name ");
        String fName = in.next();
        System.out.println();
        //Input Middle Name
        System.out.print("Please input your Middle Name ");
        String mName = in.next();
        System.out.println();
        //Input Last Name
        System.out.print("Please input your Last Name ");
        String lName = in.next();
        System.out.println();
        //Input SSN
        System.out.print("Please input your SSN ");
        String SSN = in.next();
        System.out.println();

        if (SSN.length() == 9){} else {errors(1);} //Check for SSN Length
        //Input Age
        System.out.print("Please input your Age ");
        int age = in.nextInt();
        System.out.println();
        //Input Gender
        System.out.print("Please input your Gender (F/M) ");
        String gender = in.next();
        System.out.println();
        //Check for Gender
        if (Objects.equals(gender, "F") || Objects.equals(gender, "f")) {
            gender = "Female";
            female = true;
        } else if(Objects.equals(gender, "m") || Objects.equals(gender, "M")) {
            gender = "Male";
            male = true;
        } else {errors(2);}
        //Input Weight
        System.out.print("Please input your Weight (lb) ");
        int weight = in.nextInt();
        System.out.println();

        if (weight >= 100){} else{errors(3);} //Check for Weight
        //Input Run Date
        System.out.print("Please input Run Date (MM/DD/YYYY) ");
        String date = in.next();
        System.out.println();
        //Input Gross Annual Income
        System.out.print("Please input your Gross Annual Income ");
        int GAI = in.nextInt();

        //Receive tax rate from external method
        double taxRate = calculations(GAI, age, weight);
        //Calculate Income Tax Amount
        double incTax = taxRate*GAI;
        //Calculate Total Annual Net Pay
        double TANP = GAI - incTax;

        //Outputs
        System.out.println("____________________________________");
        System.out.println();
        System.out.println("Name: "+ lName + ", " + fName.substring(0,1) + ", " + mName.substring(0,1));
        System.out.println("Social Security Number: " + SSN);
        System.out.println("Gender: "+gender);
        System.out.println("Weight: "+weight+" Pounds");
        System.out.println("Age: "+age);
        System.out.println("Gross Annual Income: "+GAI);
        System.out.println("Income Tax Rate: "+(taxRate*100)+ "%");
        System.out.println("Total Annual Income Tax: "+incTax);
        System.out.println("Total Annual Net Pay: "+TANP);
        System.out.println("Run Date: "+date);

        errors(4);

    }



    public static double calculations(int i, int a, int w) {
        double z;

        //Tax Rate Calculations
        if(i <= 11500){
            z = 0;
        } else if(a >= 65 && i < 18000){
            z = 0;
        } else if(i < 45000 && male && a < 25 && w < 200){
            z = .21;
        } else if(i < 45000 && female && a < 27 && w < 125){
            z = .21;
        } else if(i < 45000 && male && a < 45 && w < 220){
            z = .23;
        } else if(i < 45000 && female && a < 47 && w < 135){
            z = .23;
        } else if(a < 55){
            z = .19;
        } else {z = .17;}


        return z;
    }

    //Errors Method
    public static void errors(int i){
        if(i == 1){ //SSN Fail
            System.out.println("SSN Length Invalid");
        } else if(i==2) { //Gender Fail
            System.out.println("Incorrect Gender");
            System.out.println("If Gender is correct, contact 555-555-5555 for Assistance");
            System.out.println("Thank you for using our program!");
        } else if(i==3){ //Weight Fail
            System.out.println("Weight too low");
            System.out.println("If Weight is correct, contact 555-555-5555 for Assistance");
            System.out.println("Thank you for using our program!");
        }

        Scanner scanner = new Scanner(System.in);
        //Asking user if they would like to re-run the program
        System.out.println();
        System.out.println();
        System.out.println("Would you like to run Tax Calculation Application Again? (Y/N)");
        String answer = scanner.next();
        if (Objects.equals(answer, "y") || Objects.equals(answer, "Y")) {
            run();
        } else {
            System.out.println("Exiting");
            System.exit(5);
        }
}



}

