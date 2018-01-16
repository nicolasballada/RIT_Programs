public class TestSailBoat {

    public static void main(String[] args) {
        SailBoat sailBoat = new SailBoat();
        Boat boat = new Boat("red", 25);
        System.out.println("Sailboat:");
        System.out.print("Color = " + boat.getColor() + "      " + "Length = " + boat.getLength());
        System.out.print("      ");
        System.out.print("Number of Sails = " + sailBoat.getNumSails() + "           "+ " Price = " + sailBoat.calcPrice());
        System.out.println();
        System.out.println("Changing Sailboat's color to purple.");
        boat.setColor("purple");
        System.out.println("");
        System.out.println("Changing Sailboat's length to 55.");
        boat.setLength(55);

    }
}
