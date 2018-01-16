
public class CoinToss {

    int runs;
    int heads;
    int tails;
    double toss;
    int consHeads = 0;
    int consTails = 0;

    public void setRuns(int n){this.runs = n;}
    public int getRuns(){return runs;}

    public int getHeads(){return heads;}
    public int getTails(){return tails;}

    //Random rand = new Random();

    String[] Coin = new String[900];

   public void calc(){
       for(int i=0; i<runs; i++){

           setToss();

           if(toss >= .5){
               Coin[i] = "H";
               heads++;
               if(heads >= 1){consHeads++;}
               //System.out.println(Coin[i]+ " " + heads);
           } else if(toss <= .5){
               Coin[i] = "T";
               tails++;
               if(tails >= 1){consTails++;}
               //System.out.println(Coin[i]+ " " + tails);
           }
       }
      }


    public double getToss(){return toss;}

    public void setToss(){
        toss = Math.random()*1;
        //DB System.out.println(toss);
    }


}
