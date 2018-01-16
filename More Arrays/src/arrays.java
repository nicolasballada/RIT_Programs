//************************************************
//           Program by Nicolas Salomon
//  Program that accepts numbers, lists them in
// ascending order and outputs them, also listing
//       the min, max, even, and odd numbers
//************************************************

import java.util.*;

public class arrays {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("How many numbers will you input?");
        int n = in.nextInt();

        int uArray[] = new int[n];
        int max = uArray[0];

        //Inputs
        for(int i = 0; i < n; i++){
            System.out.println("Input your Numbers");
            uArray[i] = in.nextInt();
        }


        int oArray[] = new int[n];

        for(int i = 0; i < n; i++){
            oArray[i] = uArray[i];
        }

        for(int i = 0; i < n; i++){
           if(i < (n-1)) {
               if (uArray[i] < uArray[i+1]) {
                   oArray[i] = uArray[i];
               }
           } else {

           }
        }

        System.out.println(Arrays.toString(oArray));


    }


}
