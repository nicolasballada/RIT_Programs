public class SailBoat extends Boat {

    int numSails;

    public SailBoat(){
        setNumSails(1);
    }

    public SailBoat(String c){

    }

    public boolean setNumSails(int s){
        if(s >= 1 && s <= 4){
            numSails = s;
            return true;
        } else {
            System.out.println("Error: Sailboats can only have 1-4 sails.");
            return false;
        }
    }

    public int getNumSails(){return numSails;}

    public int calcPrice(){
        int price = length * 1000 + numSails * 2000;
        return price;
    }
}
