import java.util.Scanner;

public class TestCoinToss {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        CoinToss cT = new CoinToss();

        System.out.println("How many runs?");
        int r = in.nextInt();

        cT.setRuns(r);

        cT.calc();

//---------------------------

        System.out.println();

        String run;
        if(cT.getRuns() > 1){run = " runs";} else { run = " run";}

        System.out.println("In " + cT.getRuns() + run + ", there were " + cT.getHeads() + " heads and " + cT.getTails() + " tails.");

                System.out.println();
        System.out.print("In order: ");
        for(int i=0; i<cT.getRuns(); i++){
            System.out.print(cT.Coin[i]);
            System.out.print(" ");
        }
                System.out.println();
        System.out.print(cT.getHeads() + " heads: ");
        for(int i=0; i<cT.getRuns(); i++){
            if(cT.Coin[i].contains("H"))
            System.out.print(cT.Coin[i] + " ");
        }
                System.out.println();
        System.out.print(cT.getTails() + " tails: ");
        for(int i=0; i<cT.getRuns(); i++){
            if(cT.Coin[i].contains("T"))
                System.out.print(cT.Coin[i] + " ");
        }

                System.out.println();


        //System.out.println("Number of Consecutive Heads: " + consHeads);
        //System.out.println("Number of Consecutive Tails: " + consTails);

    }


}
