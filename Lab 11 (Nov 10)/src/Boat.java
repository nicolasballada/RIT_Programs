public class Boat {

    int length;
    String color;

    public int getLength(){return length;}
    public String getColor(){return color;}

    public boolean setLength(int l){
        if(l>= 20 && l<=50){
            this.length = l;
            return true;
        } else {
            System.out.println("Error: Boats can only be between 20 and 50 feet, inclusively.");
            return false;
        }
    }

    public boolean setColor(String c){
        if(c.equalsIgnoreCase("white") || c.equalsIgnoreCase("red") ||
                c.equalsIgnoreCase("blue") || c.equalsIgnoreCase("yellow")){
            this.color = c;
            return true;
        } else {
            System.out.println("Error: Boats can only be white, red, blue, and yellow.");
            return false;
        }
    }

    public Boat(){}

    public Boat(String c, int l){
        setColor(c);
        setLength(l);
    }




}
