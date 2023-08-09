package ai;

import java.util.Random;

public class AI {
    float [] k = new float[7];
    void print (){
        for (int i=0; i<7; i++){
            System.out.print (k[i]+"f, ");
        }
        System.out.println ();
    }
    public int whereToGo (float x, float y) {
        float x1 = x/1280 - k[0];
        float y1 = y/720 - k[1];
        if(x1*x1 + y1*y1 < k[6]) return 0;
        double phi = Math.asin(y1 / Math.sqrt(x1*x1 + y1*y1));
        if(x1<0) phi = Math.PI - phi;
        if (phi < k[2]) return -1;
        if (phi < k[3]) return 2;
        if (phi < k[4]) return 1;
        if (phi < k[5]) return -2; 
        return -1;
    }

    // конструктор 1
    public AI (float [] start_k){
        for (int i =0; i<7; i++){
            k[i]=start_k[i];
        }
    }
    AI (AI parent, float delta){
        Random rng = new Random();
        for (int i =0; i<7; i++){
            k[i]=parent.k[i]-delta+rng.nextFloat()*delta*2;
        }
    }
}
