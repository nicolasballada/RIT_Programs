import java.util.*;

public class GPATest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        GPACalculation gpa = new GPACalculation();
        double totalPoints = 0;
        double totalCredits = 0;
        double GPA = 0;

        System.out.println("Please Enter The Amount of Classes");
        int classes = in.nextInt();

        for(int i=0; i < classes; i++){
            System.out.print("Input your Grade: ");
            String input = in.next();
            if (Objects.equals(input, "aplus")){totalPoints = totalPoints + gpa.aplus;}
            else if (Objects.equals(input, "a")){totalPoints = totalPoints + gpa.a;}
            else if (Objects.equals(input, "aminus")){totalPoints = totalPoints + gpa.aminus;}
            else if (Objects.equals(input, "bplus")){totalPoints = totalPoints + gpa.bplus;}
            else if (Objects.equals(input, "b")){totalPoints = totalPoints + gpa.b;}
            else if (Objects.equals(input, "bminus")){totalPoints = totalPoints + gpa.bminus;}
            else if (Objects.equals(input, "cplus")){totalPoints = totalPoints + gpa.cplus;}
            else if (Objects.equals(input, "c")){totalPoints = totalPoints + gpa.c;}
            else if (Objects.equals(input, "cminus")){totalPoints = totalPoints + gpa.cminus;}
            else if (Objects.equals(input, "dplus")){totalPoints = totalPoints + gpa.dplus;}
            else if (Objects.equals(input, "d")){totalPoints = totalPoints + gpa.d;}
            else if (Objects.equals(input, "dminus")){totalPoints = totalPoints + gpa.aplus;}
            else {totalPoints = totalPoints + gpa.f;}
            System.out.println();
            System.out.print("Input Amount of Credits: ");
            double inputCredits = in.nextDouble();
            totalCredits = totalCredits + inputCredits;
            System.out.println();
            System.out.println();
        }

        GPA = (totalPoints*totalCredits)/totalCredits;

        System.out.println();
        System.out.println();
        System.out.print("Total Points: ");
        System.out.print(totalPoints);
        System.out.println();
        System.out.print("Total Credits: ");
        System.out.print(totalCredits);
        System.out.println();
        System.out.print("Your GPA is: ");
        System.out.print(GPA);


    }

}
