//******************************
//   Program by Nicolas Salomon
// Program that recieves a string,
// "encrypts" it, and can later fetch
//          and output it
//******************************

import java.util.*;

public class password {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Asking user if they would like to initiate the program
        System.out.println("------------------------------------------");
        System.out.println("Would you like to run Password Application? (Y/N)");
        String answer = scanner.next();
        if (Objects.equals(answer, "y") || Objects.equals(answer, "Y")) {
            password();
        } else {
            System.out.println("Exiting . . .");
            System.exit(1);
        }
    }

    public static void password(){
        Scanner in = new Scanner(System.in);
        System.out.println("Input Password");
        String password = in.next();
        int passLength = password.length();
        String pass1 = password.substring(0,(passLength/2));
        String pass2 = password.substring((passLength/2),passLength);



        System.out.println(password);
        System.out.println(passLength);
        System.out.println(pass1+pass2);
        System.out.println(pass1.substring(1));
        System.out.println(pass2.substring(passLength/2));



    }


}
