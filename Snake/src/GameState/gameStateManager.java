package GameState;

import Main.gamePanel;

public class gameStateManager {

    private gameState[] gameStates;
    public static int currentState;



    private static final int NUMGAMESTATES = 16;
    public static final int MENUSTATE = 0;
    public static final int HISCORESTATE = 2;
    public static final int LEVELSTATE = 1;

    public gameStateManager() {

        gameStates = new gameState[NUMGAMESTATES];


        currentState = MENUSTATE;
        loadState(currentState);

    }

    private void loadState(int state) {
        if(state == MENUSTATE)
            gameStates[state] = new Menu(this);
             else if(state == LEVELSTATE)
            gameStates[state] = new Game(this);
             else if(state == HISCORESTATE)
            gameStates[state] = new HiScore(this);
    }

    private void unloadState(int state) {
        gameStates[state] = null;
    }

    public void setState(int state) {
        unloadState(currentState);
        currentState = state;
        loadState(currentState);
    }


    public void update() {
        if(gameStates[currentState] != null) gameStates[currentState].update();
    }

    public void draw(java.awt.Graphics2D g) {

        if(gameStates[currentState] != null){ gameStates[currentState].draw(g);}
        else {
            g.setColor(java.awt.Color.BLACK);
            g.fillRect(0, 0, gamePanel.WIDTH, gamePanel.HEIGHT);
        }
    }


    public void keyPressed(int k){
        gameStates[currentState].keyPressed(k);

    }


    public void keyReleased(int k){
        gameStates[currentState].keyReleased(k);

    }
}

	