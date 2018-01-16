import javax.swing.*;

public class parseInt {

    public static void main(String[] args) {

        String num1 = JOptionPane.showInputDialog("What is the first number?");

        String num2 = JOptionPane.showInputDialog("What is the second number?");

        int int1 = Integer.parseInt(num1);
        int int2 = Integer.parseInt(num2);

        int sum = int1 + int2;

        JOptionPane.showMessageDialog(null, "Your sum is: " + sum);



    }

}
