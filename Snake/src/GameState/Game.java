package GameState;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.ThreadLocalRandom;


import javax.imageio.ImageIO;


public class Game extends gameState {

    private boolean up = false;
    private boolean down = false;
    private boolean right = false;
    private boolean left = false;
    private boolean rewardActive = false;
    private boolean collectedItem = false;
    private boolean rewardDisp = false;
    private boolean appleDisp = false;

    private boolean gameover = false;
    private boolean countdown_b = false;

    private BufferedImage image;

    private int countdown_i = 7000;
    private int score = 0;
    private int playerx = 10;
    private int playery = 12;
    private int reward = 0;
    private int rewardx = -5;
    private int rewardy = -5;
    private int applex;
    private int appley;


    Game(gameStateManager gsm){
        gameState.gsm = gsm;
        init();
        try {image = ImageIO.read(new File("Resources/Backgrounds/mainbackground.gif"));}
        catch(Exception e){e.printStackTrace();}
    }

    public void init(){
        appleGeneration();
        rewardGeneration();
        gameover = false;
        playerx = 10;
        playery = 12;
    }

    private void up(){
        playery -= 1;
    }
    private void down(){
        playery += 1;
    }
    private void left(){
        playerx -= 1;
    }
    private void right(){
        playerx += 1;
    }

    private void GameOver(){
        if(playerx > 298 || playerx < 5 || playery > 219 || playery < 8){
            gameover = true;
        }
    }

    public void update(){
        GameOver();
        rewardCollisionDetect();
        appleCollisionDetect();
        collectionTimer();

        if(score >= 100){
            rewardGeneration();
        }

        if(up){
            up();
        } else if(down){
            down();
        } else if(left){
            left();
        } else if(right){
            right();
        }

    }

    private void collectionTimer(){

        if(collectedItem){
            countdown_b = true;
        }

        if(countdown_b) {
            while (countdown_i > 0) {
                countdown_i -= 1;
                appleDisp = true;
            }
        }
        if(countdown_i == 0){
            countdown_b = false;
            appleDisp = false;
            countdown_i = 7000;
        }

    }

    private void appleGeneration(){
        applex = ThreadLocalRandom.current().nextInt(10, 290 + 1);
        appley = ThreadLocalRandom.current().nextInt(15, 200 + 1);
    }

    private void appleCollisionDetect(){

        boolean collision = false;
        boolean xcollision = false;
        boolean ycollision = false;

        int xmin = playerx;
        int xmax = playerx+10;
        int ymin = playery;
        int ymax = playery+10;

        int ax = applex + 5;
        int ay = appley + 5;

        if(xmin <= applex && xmax >= ax){xcollision = true;}

        if(ymin <= appley && ymax >= ay){ycollision = true;}

        if(xcollision && ycollision){collision = true;}

        if(collision){
            appleGeneration();
            score += 50;
            collectedItem = true;
            reward = ThreadLocalRandom.current().nextInt(1, 4);
            if(rewardActive = true){
                rewardx = -15;
                rewardy = -15;
            }
        }
    }

    private void rewardGeneration(){
        if(score >= 100) {
            if (reward >= 3 && reward!=0) {
                rewardx = ThreadLocalRandom.current().nextInt(10, 290 + 1);
                rewardy = ThreadLocalRandom.current().nextInt(15, 200 + 1);
                reward = 0;
                rewardActive = true;
            }
        }
        if(rewardx == applex){rewardGeneration(); System.out.println("Same Rx and Ax");}
        if(rewardy == appley){rewardGeneration(); System.out.println("Same Ry and Ay");}
    }

    private void rewardCollisionDetect(){
        boolean collision = false;
        boolean xcollision = false;
        boolean ycollision = false;

        int xmin = playerx;
        int xmax = playerx+10;
        int ymin = playery;
        int ymax = playery+10;

        int ax = rewardx + 5;
        int ay = rewardy + 5;

        if(xmin <= rewardx && xmax >= ax){xcollision = true;}

        if(ymin <= rewardy && ymax >= ay){ycollision = true;}

        if(xcollision && ycollision){collision = true;}

        if(collision){
            score += 60;
            rewardx = -15;
            rewardy = -15;

        }
    }

    public void draw(Graphics2D g){

        //background
        g.drawImage(image, 0, 0, null); // see javadoc for more info on the parameters

        //snake head
        g.setColor(Color.BLACK);
        g.drawOval(playerx, playery, 10, 10);
        g.fillOval(playerx, playery, 10, 10);

        //debug center square
        g.setColor(Color.ORANGE);
        g.fillRect(playerx + 5, playery + 5, 1, 1);

        //rewards
        g.setColor(Color.ORANGE);
        g.drawOval(rewardx, rewardy, 5, 5);
        g.fillOval(rewardx, rewardy, 5, 5);

        //reward point number
        g.setColor(Color.ORANGE);
        g.drawString("+60", rewardx+ 10, rewardy+2);

        //apples
        g.setColor(Color.RED);
        g.drawOval(applex, appley, 5, 5);
        g.fillOval(applex, appley, 5, 5);


        while(appleDisp) {
            //apple point number
            g.setColor(Color.RED);
            g.drawString("+50", applex + 10, appley + 2);
        }

        g.drawString(countdown_i + "", 100, 100);

        //score
        g.setColor(Color.RED);
        g.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
        g.drawString("Score: " + score, 5, 9);

        if(gameover){
            g.setColor(Color.RED);
            g.setFont(new Font("Comic Sans MS", Font.BOLD, 42));
            g.drawString("Game Over", 45,100);
            g.setColor(Color.ORANGE);
            g.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
            g.drawString("Score: "+score,105,140);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
            g.drawString("Press Esc. to Exit",105,190);

            try{Thread.sleep(1000);}catch(InterruptedException e){System.out.println("ErrorSleep");}
        }

    }


    public void keyPressed(int k){
        if(k == KeyEvent.VK_LEFT){
            up = false;
            down = false;
            left = true;
            right = false;
        }
        if(k == KeyEvent.VK_RIGHT){
            up = false;
            down = false;
            left = false;
            right = true;
        }
        if(k == KeyEvent.VK_DOWN){
            up = false;
            down = true;
            left = false;
            right = false;
        }
        if(k == KeyEvent.VK_UP){
            up = true;
            down = false;
            left = false;
            right = false;
        }
        if(k == KeyEvent.VK_ESCAPE) {  gsm.setState(gameStateManager.MENUSTATE); }

        if(k == KeyEvent.VK_C) {
            up = false;
            down = false;
            left = false;
            right = false;
            System.out.println(playerx + " " + playery);
        }
    }
    public void keyReleased(int k){}
}