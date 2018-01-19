//************************************
// Program by Nicolas Salomon
// Program that ____
// 9/25/17
//************************************

import java.util.*;

public class ThreeDArray {

    public static void main(String[] args) {
        Random rand = new Random();
                                  // x  y  z
        int[][][]hospArray = new int[3][7][24];

        //load x
        for(int i = 0; i < 4; i++){
            hospArray[i][0][0] = rand.nextInt(3);
            System.out.println("x" + i);
        }

        //load y
        for(int i = 0; i < 7; i++){
            hospArray[0][i][0] = rand.nextInt(7);
            System.out.println("y" + i);
        }

        //load z
        for(int i = 0; i < 24; i++){
            hospArray[0][0][i] = rand.nextInt(24);
            System.out.println("z   " + i);
        }

        for(int i=0; i<4; i++){
            for(int j=0; j<5; j++){
                for(int k=0; k<24; k++){
                    System.out.print(hospArray[i][j][k]);
                    System.out.println();
                }
            }
        }

        //0-8
        //8-16
        //16-24

    }


}
