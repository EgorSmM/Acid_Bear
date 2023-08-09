package game.back;

import java.util.Random;
import game.front.Game;

public class Bear implements Runnable{

    private int health;
    private int dDist;
    private int score = 0;
    private Game game;

    public Bear(int health, int dDist, Game game){
        this.health = health;
        this.dDist = dDist;
        this.game = game;
    }

    @Override
    public void run(){
        Thread rotateThread[] = new Thread[4];
		
        for(int i=0; i<4; i++){
            rotateThread[i] = new Thread(new Fon(i, game));
            rotateThread[i].start();
        }

        while(true){
            if(health > 0){
                Random rng = new Random();
                int dx = rng.nextInt(dDist) - dDist/2;
                int dy = rng.nextInt(dDist) - dDist/2;

                if(game.frontBear.changeLabel(dx,dy)) 
                    health--;
                else 
                    score++;

                game.frontBear.changeMes(health, score);
            }
            else {
                for(int i=0; i<4; i++)
                    rotateThread[i].interrupt();
                game.frontBear.endGame(score);
                break;
            }
            try{
                Thread.sleep(10);
            }
            catch(Exception e){
                return;
            }
        }
    }
};