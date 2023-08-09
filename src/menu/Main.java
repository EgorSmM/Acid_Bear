package menu;

import javax.swing.*;
import common.Music;
import game.front.PlayerGame;
import game.front.AIGame;

public class Main extends JFrame {

    private Music music;

    public static void main(String[] args) {
        new Main();
    }

    public void startGame(String difficulty) {
        music.stopMusic();
        int dHealth;
        int dDist;
        if (difficulty.equals("Newbee")) {
            dHealth = 1000;
            dDist = 51;
        } else if (difficulty.equals("Normal Person")) {
            dHealth = 500;
            dDist = 101;
        } else {
            dHealth = 250;
            dDist = 151;
        }
        new PlayerGame(dHealth, dDist);
        setVisible(false);
    }

    public void startAI(){
        music.stopMusic(); 
        Thread gameThread = new Thread(new AIGame(250, 151));
        gameThread.start();  
        setVisible(false);     
    }
    
    public Main() {
        super("Acid bear");
        setSize(512, 512);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        music = new Music("../MenuMusic.wav");
        new Menu(this);

        setVisible(true);
    }
}