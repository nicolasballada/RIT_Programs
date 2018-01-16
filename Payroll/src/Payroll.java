//*************************************************************************************
//                               Program by Nicolas Salomon
// Payroll application. Truncates SSN, takes into account state, federal and SS tax.
//                                     9/15/2017
// ************************************************************************************

import java.util.*;

public class Payroll {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Asking user if they would like to initiate the program
        System.out.println("------------------------------------------");
        System.out.println("Would you like to run Payroll Application? (Y/N)");
        String answer = scanner.next();
        if (Objects.equals(answer, "y") || Objects.equals(answer, "Y")) {
            PayRoll();
        } else {
            System.out.println("Exiting . . .");
            System.exit(1);
        }
    }

    public static void PayRoll(){
        Scanner in = new Scanner(System.in);
        //Input Section - Asking User for: Name, SSN, Hourly Pay Rate, and Hours Worked
        System.out.println("What is your First Name?");
        String fName = in.next();
        if(fName.matches("[a-zA-Z]+")) { //Checking if first name is Alpha
            System.out.println("What is your Middle Name?");
            String mInitial = in.next();
            if (mInitial.matches("[a-zA-Z]+")) { //Checking if middle name Alpha
                System.out.println("What is your Last Name?");
                String lName = in.next();
                if (lName.matches("[a-zA-Z]+")) { //Checking if last name is Alpha
                    System.out.println("What is your Social Security Number?");
                    String SSN = in.next(); //Checking if SSN is 10 characters long
                    if (SSN.length() == 9) {
                        System.out.println("What is your hourly pay rate?");
                        double hPay = in.nextDouble();
                        System.out.println("How many hours have you worked?");
                        double hWorked = in.nextDouble();
                        if (hWorked < 85) { //Setting a limit to 84 hours as max amount of hours

                            //Math for Calculating Net Pay & Annual Income
                            double gPay = hPay * hWorked;
                            //Calculation for Fed. Tax done on external method
                            double fTaxCalc = tax(gPay);
                            double fTax = gPay * fTaxCalc;
                            double sTax = gPay * .06;
                            double SSNTax = gPay * .04;
                            double nPay = (((gPay - fTax) - sTax) - SSNTax);
                            double aIncome = nPay * 52;

                            //Outputting Name, "Encrypted" SSN, Hourly Pay Rate, Hours Worked,
                            //Gross Pay, Fed. Tax Rate & Amount, State Tax, SSTax, Net Pay & Projected Annual Income
                            System.out.println(" ");
                            System.out.println("--------------------------");
                            System.out.println(fName + " " + mInitial.substring(0,1) + " " + lName);
                            System.out.println("Social Security Number: *****" + SSN.substring(5, 9));
                            System.out.println("Hourly Pay Rate: " + hPay);
                            System.out.println("Hours Worked: " + hWorked);
                            System.out.println("Gross Pay: $" + gPay);
                            System.out.println("Federal Tax Rate: " + fTaxCalc*100 + "%");
                            System.out.println("Federal Tax: $" + fTax);
                            System.out.println("State Tax: $" + sTax);
                            System.out.println("Social Security: $" + SSNTax);
                            System.out.println("................");
                            System.out.println("Net Pay: $" + nPay);
                            System.out.println("Projected Annual Income: $" + aIncome);
                            System.out.println("--------------------------");
                            System.out.println(" ");

                            //Ask if user wants to run again
                            System.out.println("Would you like to run it again? (Y/N)");
                            String answer = in.next();
                            if (Objects.equals(answer, "y") || Objects.equals(answer, "Y")) {
                                PayRoll();
                            } else {
                                System.out.println("Exiting . . . ");
                                System.exit(4);
                            }
                        } else {
                            System.out.println("ERROR: Worked Hours");
                            System.exit(2);
                        }
                    } else {
                        System.out.println("ERROR: SSN");
                        System.exit(3);
                    }
                } else {
                    System.out.println("ERROR: Last Name");
                    System.exit(3);
                }
            } else {
                System.out.println("ERROR: Middle Name");
                System.exit(3);
            }
        } else{
            System.out.println("ERROR: First Name");
            System.exit(6);
        }
    }

    public static double tax(double x){
            //Math to Determine Fed. Tax Rate
            if(x < 10000){
                x = 0;
            } else if(x > 10000 && x < 14999.99){
                x = .10;
            } else if(x > 15000 && x < 19999.99){
                x = .12;
            } else {
                x = .15;
            }

            return x;
    }



}
