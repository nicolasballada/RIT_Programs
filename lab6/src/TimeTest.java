public class TimeTest {

    public static void main(String[] args) {
        Time t1 = new Time();                  // 00:00:00
        System.out.println(t1);
        Time t2 = new Time(2);                // 02:00:00
        System.out.println(t2);
        Time t3 = new Time(21, 34);        // 21:34:00
        System.out.println(t3);
        Time t4 = new Time(12, 25, 42);  // 12:25:42
        System.out.println(t4);
    }
}

