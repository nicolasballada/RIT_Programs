//                                      Program by: Nicolas Salomon
// This program represents an airline flight, where the user inputs an origin, destination, days flight will be
// running, departure time, and arrival time. The FlightTest class will interface with the Flight class to process
// the Airline Name, Flight Number, Origin, and Destination using getters and setters. Finally it is presented via a
// one line output.
//                                            Date: 11/08/17


import java.util.Random;
import java.util.Scanner;

public class FlightTest {


    public static void main(String[] args) {
        //Random number generator for the flight number
        Random rand = new Random();
        Scanner in = new Scanner(System.in);

        //String containing the days of the week for output
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        //String to select which days of the week the flight will run
        int daysRunning[] = new int[7];

        //Inputs
        System.out.println("Please input Origin");
        String o = in.nextLine();

        System.out.println("Please input Destination");
        String d = in.nextLine();

        System.out.println("How many days a week will the flight be running?");
        int t = in.nextInt();

        System.out.println("Which days?");
            for(int i=0; i<t; i++){ //for loop to select which days the flight will run
                daysRunning[i] = in.nextInt();
            }

        System.out.println("Input Departure Time");
        String DepTime = in.next();

        System.out.println("Input Arrival Time");
        String ArrTime = in.next();

        //Random number generator to decide flight number
        int n = rand.nextInt(888);
        String f = Integer.toString(n);

        //Interface back to Flight class to process and store information
        Flight flight= new Flight();
        flight.setAirlineName("American Airlines");
        flight.setFlightNumber(f);
        flight.setOrigin(o);
        flight.setDestination(d);

        //Printing
        System.out.println();
        //  AIRLINE NAME flight ### originates in ORIGIN with a destination of DESTINATION on DAYS RUNNING departing at DEPTIME and arriving at ARRTIME
        System.out.print(
                flight.getAirlineName() + " flight " + flight.getFlightNumber() + " originates in " + flight.getOrigin() + " with a destination of "
                        + flight.getDestination() + " on ");
        for(int i=0; i<t; i++){System.out.print(days[daysRunning[i]] + ", ");}
        System.out.print("departing at " + DepTime + " and arriving at " + ArrTime);



    }


}
