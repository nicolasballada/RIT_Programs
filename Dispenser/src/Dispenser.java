//Ha Joon Park, 2, September 10th, 2017
import java.util.Scanner;

public class Dispenser {

    public static void main(String[] args) {
        Scanner console = new Scanner (System.in);
        int itemPrice, quarters, dimes, nickels;
        System.out.println("Enter price of item");
        System.out.print("(from 25 cents to a dollar, in 5-cent increment): ");
        itemPrice = console.nextInt();
        quarters = (100 - itemPrice) / 25;
        dimes = (100 - itemPrice - quarters * 25) / 10;
        nickels = (100 - itemPrice - quarters * 25 - dimes * 10) / 5;
        System.out.println("You bought an item for " + itemPrice + " cents and gave me a dollar,");
        System.out.println("so your change is:\n");
        System.out.println(quarters + " quarter(s),"); // 25
        System.out.println(dimes + " dime(s), and"); // 10
        System.out.println(nickels + " nickel(s)."); // 5
    } // main

} // Dispenser