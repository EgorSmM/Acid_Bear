package ai;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Simulator{
    AI ai;
    private int health = 50;
    private int dDist = 151;
    private int score = 0;
    private int w = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int h = Toolkit.getDefaultToolkit().getScreenSize().height;

    public JLabel label = new JLabel(new ImageIcon("11.png"));
    public Boolean changeLabel(int dx, int dy){
        label.setLocation(label.getX() + dx,label.getY() + dy);
        return label.getX()<0 || label.getY()<0 || label.getX()+367>w || label.getY()+500>h;
    }

    Simulator(AI ai){
        this.ai = ai;
        label.setBounds((w-367)/2, (h-500)/2, 367, 500);
    }

    public int run(){
        while(score < 1e5){
            if(health > 0){
                Random rng = new Random();
                int dx = rng.nextInt(dDist) - dDist/2;
                int dy = rng.nextInt(dDist) - dDist/2;
                switch (ai.whereToGo(label.getX(), label.getY())){
                    case -2:
                        label.setLocation(label.getX(), label.getY()-400);
                        break;
                    case -1:
                        label.setLocation(label.getX()+400, label.getY());
                        break;
                    case 0:
                        break;
                    case 1:
                        label.setLocation(label.getX()-400, label.getY());
                        break;
                    case 2:
                        label.setLocation(label.getX(), label.getY()+400);
                        break;
                }
                if(changeLabel(dx,dy))
                    health--;
                else
                    score++;
            }
            else {
                return score;
            }
        }
        return score;
    }
    public static void main(String[] args) {
        AI start = new AI ( new float []{0, 0, -3, -1, 1, 3, .2f});
        float time_score = 0;
        while (time_score<1000000){
            time_score = 0;
            AI best = start;
            for (int i =0; i<1000; i++){
                AI child=new AI(start, .1f);
                float time_child = simTime(child);
                if (time_child>time_score){
                    time_score=time_child;
                    best=child;
                }
            }
            start=best;
            System.out.print (time_score + "sec.      Koef: ");
            best.print();

        }

    }
    static float simTime (AI ai){
        float time=0;
        for (int i=0; i<20; i++){
            time+=new Simulator(ai).run();
        }
        return time/100;
    }
};