public class TestBoat {

    public static void main(String[] args) {
        Boat boat = new Boat("white", 20);
        boat.setColor("blue");
        boat.setLength(25);
        System.out.println("Color = " + boat.getColor() + "      " + "Length = " + boat.getLength());
        System.out.println("Setting Boat's length to 100");
        boat.setLength(100);
        System.out.println("Setting Boat's color to \"purple\"");
        boat.setColor("purple");
    }

}
