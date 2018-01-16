package GameState;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;


public class HiScore extends gameState {

    private BufferedImage image;


    private Font font;

    HiScore(gameStateManager gsm){
        gameState.gsm = gsm;

        try {
            image = ImageIO.read(new File("Resources/Backgrounds/mainbackground.gif"));
            font = new Font("Comic Sans MS", Font.PLAIN, 12);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void init(){
        System.out.println("In");
    }

    public void update(){}

    public void draw(Graphics2D g) {
        g.drawImage(image, 0, 0, null); // see javadoc for more info on the parameters
        g.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        g.drawString("Hi Score", 125, 30);
    }

    public void keyPressed(int k){
        if(k == KeyEvent.VK_ESCAPE){
            gsm.setState(gameStateManager.MENUSTATE);
        }
    }
    public void keyReleased(int k){
        if(k == KeyEvent.VK_ESCAPE){

        }
    }
}
