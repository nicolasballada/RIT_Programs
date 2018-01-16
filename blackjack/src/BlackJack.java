import java.util.Random;
import java.util.Scanner;

public class BlackJack{

    static Random rand = new Random();
    static int dealer[] = new int[30];
    static int player[] = new int[30];

    static int run = 0;

    public static void main(String[] args) {
        run();
    }

    public static void run(){
        newCardPlayer();
        newCardDealer();
        displayPlayer();
        displayDealer();

        addHold();
    }

    public static void addHold(){
        Random rand = new Random();
        Scanner in = new Scanner(System.in);
        run++;
        System.out.println();
        System.out.println("Would you like to add or hold? (A/H)");
        if(in.next().contains("a")){
            run();
        } else if(in.next().contains("h")) {
            displayPlayer();
            displayDealer();
        } else{
            run();
        }
    }

    public static void displayPlayer(){
        System.out.println();
        System.out.print("YOU: ");
        for(int i=0; i<run; i++){
            System.out.print(player[i]);
            System.out.print(" ");
        }
    }

    public static void displayDealer(){
        System.out.println();
        System.out.print("CPU: ");
        for(int i=0; i<run; i++){
            System.out.print(dealer[i]);
            System.out.print(" ");
        }
    }

    public static void newCardPlayer(){
        player[run] = rand.nextInt(12);
    }

    public static void newCardDealer(){
        dealer[run] = rand.nextInt(12);
    }



}
