
import java.awt.event.*;
import java.util.*;

public class stopwatch{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter any number of letter to start: ");
        String start = in.next();
            timer();
    }

    private static void timer() {
        Scanner in = new Scanner(System.in);
        long initTime = System.currentTimeMillis();
        System.out.print("Enter any number of letter to stop: ");
        String stop = in.next();

            long stopT = System.currentTimeMillis();
            long FinalTime = stopT - initTime;
            long seconds = FinalTime/1000;
            long minutes = seconds/60;
            long hours = minutes/60;

            System.out.println("Elapsed time in milliseconds: " + FinalTime);
            System.out.println("Elapsed time in seconds: " + seconds);
            System.out.println("Elapsed time in minutes: " + minutes);
            System.out.println("Elapsed time in hours: " + hours);

    }

}
