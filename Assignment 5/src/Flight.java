//                                      Program by: Nicolas Salomon
// This program represents an airline flight, where the user inputs an origin, destination, days flight will be
// running, departure time, and arrival time. The FlightTest class will interface with the Flight class to process
// the Airline Name, Flight Number, Origin, and Destination using getters and setters. Finally it is presented via a
// one line output.
//                                            Date: 11/08/17

public class Flight {

    //declaring Strings
    public String airlineName;
    public String flightNumber;
    public String origin;
    public String destination;

    //setters
    public void setAirlineName(String name){this.airlineName = name;}
    public void setFlightNumber(String n){this.flightNumber = n;}
    public void setOrigin(String o){this.origin = o;}
    public void setDestination(String d){this.destination = d;}

    //getters
    public String getAirlineName(){return this.airlineName;}
    public String getFlightNumber(){return this.flightNumber;}
    public String getOrigin(){return this.origin;}
    public String getDestination(){return this.destination;}

}
