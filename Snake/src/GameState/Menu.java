package GameState;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;


public class Menu extends gameState {

    private BufferedImage image;

    private int currentChoice = 0;

    private String[] options ={
            "Start",
            "Hi Score",
            "Quit"
    };

    private Font font;

    Menu(gameStateManager gsm){
        gameState.gsm = gsm;

        try {
            image = ImageIO.read(new File("Resources/Backgrounds/menu.gif"));
            font = new Font("Comic Sans MS", Font.PLAIN, 12);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void init(){}

    public void update(){}

    public void draw(Graphics2D g) {
        g.drawImage(image, 0, 0, null); // see javadoc for more info on the parameters
        g.setFont(font);

        for (int i = 0; i < options.length; i++) {
            if (i == currentChoice) {
                g.setColor(Color.RED);
            }  else {
                g.setColor(Color.DARK_GRAY);
            }
            g.drawString(options[i], 260, 200 + i * 15);
        }

    }

    private void select(){
        if(currentChoice == 0){
            gsm.setState(gameStateManager.LEVELSTATE);
        }
        if(currentChoice == 1){
            gsm.setState(gameStateManager.HISCORESTATE);
        }
        if(currentChoice == 2){
            System.exit(5);
        }
    }

    public void keyPressed(int k){
        if(k == KeyEvent.VK_ENTER){
            select();
        }
        if(k == KeyEvent.VK_UP){
            currentChoice--;
            if(currentChoice == -1){
                currentChoice = options.length -1;
            }
        }
        if(k == KeyEvent.VK_DOWN){
            currentChoice++;
            if(currentChoice == options.length){
                currentChoice = 0;
            }
        }
    }
    public void keyReleased(int k){  }
}
