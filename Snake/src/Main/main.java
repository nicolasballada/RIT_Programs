package Main;

import javax.swing.JFrame;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class main {

    public static void main(String[] args){

        JFrame window = new JFrame("Fuck Snake");
        window.setContentPane(new gamePanel());
        try {
            window.setIconImage(ImageIO.read(new File("Resources/Images/icon.gif")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
