package game.front;

import ai.AI;

public class AIGame extends Game implements Runnable{

    private AI ai;

    public AIGame(int dHealth, int dDist){
        super(dHealth, dDist);
        ai= new AI (new float [] {0.41465464f, 0.41714785f, -2.040421f, -0.8581686f, 0.9194733f, 2.013683f, 0.087231025f});
    }

    @Override
    public void run(){
        while(true){
            switch (ai.whereToGo(frontBear.label.getX(), frontBear.label.getY())){
                case -2:
                    frontBear.label.setLocation(frontBear.label.getX(), frontBear.label.getY()-400);
                    break;
                case -1:
                    frontBear.label.setLocation(frontBear.label.getX()+400, frontBear.label.getY());
                    break;
                case 0:
                    break;
                case 1:
                    frontBear.label.setLocation(frontBear.label.getX()-400, frontBear.label.getY());
                    break;
                case 2:
                    frontBear.label.setLocation(frontBear.label.getX(), frontBear.label.getY()+400);
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
}