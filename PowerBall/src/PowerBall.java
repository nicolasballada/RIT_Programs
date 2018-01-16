import java.util.*;
//-------------------------------
// Program created by Nicolas Salomon
//-------------------------------
public class PowerBall {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //Ask if the user wants to play PowerBall
        System.out.println("Do you want to play PowerBall? (Y/N)");
        String answer = in.next();
        //Check if the user wants to play (Y/N)
        if(Objects.equals(answer, "y") || Objects.equals(answer, "Y")){
            GameOn();
        } else {
            System.out.println("E X I T I N G");
            System.exit(1);
        }
    }
    public static void GameOn(){

        Random rand = new Random();

        //Asking user for its name
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your first initial?");
        String fName = scanner.next();
        System.out.println("What is your middle initial?");
        String mName = scanner.next();
        System.out.println("What is your last name?");
        String lName = scanner.next();

        //Creating random integers
        int rand_int1 = rand.nextInt(64);
        int rand_int2 = rand.nextInt(64);
        int rand_int3 = rand.nextInt(64);
        int rand_int4 = rand.nextInt(64);
        int rand_int5 = rand.nextInt(64);
        int rand_int6 = rand.nextInt(26);

        //Checking for repeats
        while(rand_int1 == rand_int2 || rand_int1 == rand_int3 || rand_int1 == rand_int4 || rand_int1 == rand_int5 || rand_int1 == rand_int6)
        {rand_int1 = rand.nextInt(64);}
        while(rand_int2 == rand_int3 || rand_int2 == rand_int4 || rand_int2 == rand_int5 || rand_int2 == rand_int6)
        {rand_int2 = rand.nextInt(64);}
        while(rand_int3 == rand_int4 || rand_int3 == rand_int5 || rand_int3 == rand_int6)
        {rand_int3 = rand.nextInt(64);}
        while(rand_int4 == rand_int5 || rand_int4 == rand_int6)
        {rand_int4 = rand.nextInt(64);}
        while(rand_int5 == rand_int6)
        {rand_int5 = rand.nextInt(64);}

        //Outputting name and winning numbers
        System.out.print(lName+", "+mName+". "+fName+".");
        System.out.print(", the Winning Powerball Numbers are: ");
        System.out.println((rand_int1+5)+" "+(rand_int2+5)+" "+(rand_int3+5)+" "+(rand_int4+5)+" "+(rand_int5+5)+" "+rand_int6);

        //Asking and checking if user wants to play again (Recalling GameOn Method if they do)
        System.out.println("Do you want to play again?");
        String answer = scanner.next();
        if(Objects.equals(answer, "y") || Objects.equals(answer, "Y")){
            GameOn();
        } else {
            System.out.println("E X I T I N G");
            System.exit(2);
        }
    }
}
