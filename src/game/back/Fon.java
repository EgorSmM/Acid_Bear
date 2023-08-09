package game.back;

import java.util.Random;
import javax.swing.*;
import java.util.ArrayList;


public class Fon implements Runnable{
    
    private int i;
    private JFrame frame;

    public Fon(int i, JFrame frame){
        this.i = i;
        this.frame = frame;
    }

    @Override
    public void run(){
        
        ArrayList<Pic> meteors = new ArrayList<Pic>(25);
        for (int k=0; k<frame.getWidth()/160 + 1; k++)
            for(int j=0; j < frame.getHeight()/160 + 1; j++){
                if((k+j)%4==i)meteors.add(createMeteor(k,j));
            }
        while(true){
            for(Pic pic : meteors){
                pic.angle+=80;
                pic.repaint();
            }
            try{
                Thread.sleep(70);
            }
            catch(Exception e){
                return;
            }
        }
    }
    
    Pic createMeteor(int i, int j){
		Random rng = new Random();
		Pic pic = new Pic("../2.png");
		pic.setBounds(-200 + 160 * i, -200 + 160 * j,400+rng.nextInt(80), 400+rng.nextInt(80));
		frame.add(pic);
		return pic;
    };
};