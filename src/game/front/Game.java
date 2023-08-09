package game.front;

import javax.swing.*;
import java.awt.*;
import common.Music;
import menu.Main;
import game.back.Bear;

public class Game extends JFrame{
    
    private Music music;

    public void closeGame(){
        music.stopMusic();
        setVisible(false);
        new Main();
    }

    public FrontBear frontBear;

    public Game(int dHealth, int dDist){

        super("Acid bear");
        this.music = new Music("../GameMusic.wav");

        setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        setDefaultCloseOperation(3);
        setLayout(null);

        frontBear = new FrontBear(this);
        Bear bear = new Bear(dHealth, dDist, this);

        Thread bearThread = new Thread(bear);
		bearThread.start();

        getContentPane().setBackground(new Color(250, 0, 0));

        setVisible(true);
    }
}