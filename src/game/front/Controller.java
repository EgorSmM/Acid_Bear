package game.front;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;

public class Controller implements KeyListener{
    JLabel label;
    Controller(JLabel label){
        this.label = label;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_W:
                label.setLocation(label.getX(), label.getY()-400);
                break;
            case KeyEvent.VK_D:
                label.setLocation(label.getX()+400, label.getY());
                break;
            case KeyEvent.VK_A:
                label.setLocation(label.getX()-400, label.getY());
                break;
            case KeyEvent.VK_S:
                label.setLocation(label.getX(), label.getY()+400);
                break;
        }
    }
}
