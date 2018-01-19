//**********************************************************************
//                      Program by: Nicolas Salomon
//          This program uses a three dimensional array to
//     hold temperature information in 3 different times during the day
//          for 5 days. Data will be displayed accordingly
//                          Started on 10/02/17
//**********************************************************************

import java.util.*;
import java.util.stream.DoubleStream;

public class Temperature {
    //initializing ints doubles and arrays
    public static int[][][]temperature = new int[3][6][5];
    public static double[][]average = new double[2][5];
    public static double[]daily = new double[5];
    public static double maxmorntemp = temperature[0][0][0];
    public static double maxafttemp = temperature[0][0][0];
    public static double minmorntemp = temperature[0][0][0];
    public static double minafttemp = temperature[0][0][0];
    public static double maxavg = average[0][0];
    public static double minavg = average[0][0];

    public static void main(String[] args) {
        run();
    }

    private static void run(){
        Scanner in = new Scanner(System.in);
        System.out.println("Please Input Start Day (1-7)"); //asking users to input start day
        int s = in.nextInt();

        int startDay = s; //saving the start day

        if(s > 7){run();} //If start day is greater than 7, it asks again until it is correct

        String day = chooseDay(s); //connects the number to a day (in method chooseDay)

        int measurementNum = 1; //an int that keeps track of the measurement number (resets to 1 every day)

        for(int k = 0; k < 5; k++) {
            if(s > 7){s = 1;}//if day goes beyond 7, it resets back to 1
            for (int i = 0; i < 3; i++) {
                System.out.print("Please Input " + day + "'s " + "(" + s + ")" + " Morning Temperature " + measurementNum+": ");
                temperature[i][0][k] = in.nextInt();
                measurementNum++;
            }
            System.out.println();
            measurementNum = 1;
            for (int j = 3; j < 6; j++) {
                System.out.print("Please Input " + day + "'s " + "(" + s + ")"  + " Afternoon Temperature " + measurementNum+ ": ");
                temperature[0][j][k] = in.nextInt();
                measurementNum++;
            }
            System.out.println();
            measurementNum = 1;
            s++;
            day = chooseDay(s);
        }

        s = startDay; //resets int s to the start day

        System.out.println("_________________________________________________________");

        for(int k=0; k<5; k++){
            if(s > 7){s = 1;}
            day = chooseDay(s);
            average[0][k] = (temperature[0][0][k] + temperature[1][0][k] + temperature[2][0][k])/3; //setting up array for averages (to another method)
            average[1][k] = (temperature[0][3][k] + temperature[0][4][k] + temperature[0][5][k])/3;

            //Prints Main Output
            System.out.println();
            System.out.println("Day " + s + "(" + day + ")");
            double conMorn = conversion(average[0][k]);//connects to conversion method
            System.out.println("Morning Average-C:  "+conMorn);
            System.out.println("Morning Average-F:  " + average[0][k]);
            double conAft = conversion(average[1][k]);//connects to conversion method
            System.out.println("Afternoon Average-C:  " + conAft);
            System.out.println("Afternoon Average-F:  " + average[1][k]);

            daily[k]=(average[0][k] + average[1][k])/2;
            s++;
        }

        //calls average methods
        highLowPeriod();
        lowestHighestAverages();

    }
    //Method that connects the number to a day
    private static String chooseDay(int x){
             String day = "Sunday";
             if(x == 1){day = "Sunday";}
        else if(x == 2){day = "Monday";}
        else if(x == 3){day = "Tuesday";}
        else if(x == 4){day = "Wednesday";}
        else if(x == 5){day = "Thursday";}
        else if(x == 6){day = "Friday";}
        else if(x == 7){day = "Saturday";}
        return day;
    }

    //conversion method
    private static double conversion(double i){
        i = (i-32)/1.8;
        return i;
    }

    //Method that finds the Highest and Lowest temps of a period
   private static void highLowPeriod(){
         //Highest and Lowest Temp of Period
         for(int k=0; k<5; k++){
             for(int i=0; i<3; i++) {
                 if (maxmorntemp < temperature[i][0][k]) {
                     maxmorntemp = temperature[i][0][k];
                 }
             }
                 for(int j=3; j<6; j++){
                     if(maxafttemp < temperature[0][j][k]){
                         maxafttemp = temperature[0][j][k];
                     }
                 }
             }

             double maxtemp = 0;

             if(maxmorntemp > maxafttemp){
             maxtemp = maxmorntemp;
             } else if(maxmorntemp < maxafttemp){
                 maxtemp = maxafttemp;
             }


         minmorntemp = temperature[0][0][0];
         minafttemp = temperature[0][0][0];
       for(int k=0; k<5; k++){
           for(int i=0; i<3; i++) {
               if (minmorntemp < temperature[i][0][k]) {
                   minmorntemp = temperature[i][0][k];
               }
           }
           for(int j=3; j<6; j++){
               if(minafttemp < temperature[0][j][k]){
                   maxafttemp = temperature[0][j][k];
               }
           }
       }
       double mintemp = 1;
       if(minmorntemp < minafttemp){
           mintemp = minmorntemp;
       } else if(minmorntemp > minafttemp){
           mintemp = minafttemp;
       }


             System.out.println();
         System.out.println("Highest Temperature of the Period: " + maxtemp);
         System.out.println("Lowest Temperature of the Period: "+ mintemp);
     }

     //method that calculates the lowest, highest, and mean averages.
         private static void lowestHighestAverages(){
             //Highest and Lowest Daily Temps
         for(int k=0; k<5; k++){
             if(maxavg < daily[k]){
                 maxavg = daily[k];
             }
         }
         minavg = daily[0];
         for(int k=0; k<5; k++){
             if(minavg > daily[k]){
                 minavg = daily[k];
             }
         }
             double sum = DoubleStream.of(daily).sum();
             double avg = sum/5;

             System.out.println();
         System.out.println("Highest Daily Average: " + maxavg);
         System.out.println("Lowest Daily Average: "+ minavg);
         System.out.println("Average: "+ avg);
     }



}


