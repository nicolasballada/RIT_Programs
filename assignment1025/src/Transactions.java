//Modify the Account class so that it also permits an account to be opened with just a name and an account number, assuming an intitial balance
//        of zero. Modify the main method of the Transaction class to demonstrate this capability.

import java.util.*;

public class Transactions
{
    //-----------------------------------------------------------------
    //  Creates some bank accounts and requests various services.
    //-----------------------------------------------------------------
    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);
        String name = "Enter Name";
        String accountnum;
        long accnum = 0;
        double bal = 0;
        double balplus1 = bal+1;

        System.out.println("Enter First Name");
        String fname = in.next();
        System.out.println("Enter Last Name");
        String lname = in.next();
        name = fname + " " + lname;
        System.out.println("Enter Account Number (5)");
        accountnum = in.next();
        if(accountnum.length() == 5){
            accnum = Long.parseLong(accountnum);
            System.out.println("Enter Balance");
            while(true){
                bal = in.nextDouble();

            }
        } else {
            System.out.println("oops");
        }





        Account acct1 = new Account ("Ted Murphy", 72354, 102.56);
        Account acct2 = new Account ("Jane Smith", 69713, 40.00);
        Account acct3 = new Account ("Edward Demsey", 93757, 759.32);
        Account acct4 = new Account(name, accnum, bal);



        acct1.deposit (25.85);

        double smithBalance = acct2.deposit (500.00);
        System.out.println ("Smith balance after deposit: " + smithBalance);
        System.out.println ("Smith balance after withdrawal: " +
                acct2.withdraw (430.75, 1.50));

        acct1.addInterest();
        acct2.addInterest();
        acct3.addInterest();
        acct4.addInterest();

        System.out.println ();
        System.out.println (acct1);
        System.out.println (acct2);
        System.out.println (acct3);
        System.out.println(acct4);
    }
}
