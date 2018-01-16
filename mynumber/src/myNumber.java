//***************************
// Program by Nicolas Salomon
//***************************
import java.util.*;

public class myNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input a Number");
        int oNumber = scanner.nextInt();

        int squared = squared(oNumber);
        int cubed = cubed(oNumber);

        System.out.println("Your Original Number was: "+oNumber);
        System.out.println("Squared Number is: "+squared);
        System.out.println("Cubed Number is: "+cubed);
        System.out.println("The Original Number is still: "+oNumber);
    }

    public static int squared(int x){
        x = x * x;
        return x;
    }
    public static int cubed(int x){
        x = (x*x)*x;
        return x;
    }


}
