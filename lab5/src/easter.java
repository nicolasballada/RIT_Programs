import java.util.*;

public class easter {

    public static int y;

    public static void run(){
        Scanner in = new Scanner(System.in);



        System.out.println("Please Input Year");
        y = in.nextInt();

    }

    public static void easterCalculation(){
      int a, b, c, d, e, g, h, j, k, m, r, n, p;

        a = y%19;

        b = y/100;

        c = y%100;

        d = b/4;

        e = b%4;

        g = (8*b+13)/25;

        h = (19*a+b-d-g+15)/30;

        j = c/4;

        k = c%4;

        m = (a+11*h)/319;

        r = (2*e+2*j-k-h+m+32)%7;

        n = (h-m+r+90)/25;

        p = (h-m+r+n+19)%32;

        getEasterSundayMonth(n);
        getEasterSundayDay(p);

     System.out.println(a);
     System.out.println(b);
     System.out.println(c);
     System.out.println(d);
     System.out.println(e);
     System.out.println(g);
     System.out.println(h);
     System.out.println(j);
     System.out.println(k);
     System.out.println(m);
     System.out.println(r);
     System.out.println(n);
     System.out.println(p);
    }

    public static int getEasterSundayMonth(int month){
        return month;
    }

    public static int getEasterSundayDay(int day){
        return day;
    }


}
