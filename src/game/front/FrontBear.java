package game.front;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class FrontBear{

    private Game game;
    private JPanel ripPanel;
    private JTextArea rip;
    private JButton toMenu;
 
    public JLabel label = new JLabel(new ImageIcon("../11.png"));
    private JTextArea mes = new JTextArea();

    public void endGame(int score){
        
        rip.setFont(new Font("Arial", 2, 60));
        rip.setBounds((game.getWidth()-600)/2, (game.getHeight()-700)/2, 600, 300);
        rip.setText("YOU DIED, BRO. \nYOUR SCORE: " + Integer.toString(score));
        rip.setBackground(new Color(0, 0, 0, 0));
        rip.setForeground(new Color(255, 255, 255));

        toMenu.setBounds((game.getWidth()-600)/2, (game.getHeight()-100)/2, 600, 100);
        toMenu.setBackground(new Color(0, 0, 0, 0));
        toMenu.setForeground(new Color(255, 255, 255));
        toMenu.setFont(new Font("Arial", 2, 60));
        toMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.closeGame();
            }
        });

        ripPanel.setVisible(true);
    }

    public Boolean changeLabel(int dx, int dy){

        label.setLocation(label.getX() + dx,label.getY() + dy);
        label.repaint();

        return label.getX()<0 || label.getY()<0 || label.getX()+367>game.getWidth() || label.getY()+500>game.getHeight();
    }

    public void changeMes(int health, int score){
        mes.setText("Health: " + Integer.toString(health) + "\nScore: " + Integer.toString(score));
    }
        
    FrontBear(Game game){
        this.game = game;

        ripPanel = new JPanel();
        ripPanel.setBackground(new Color(255,0,0));
        
        rip = new JTextArea();
        ripPanel.add(rip);
        game.add(rip);

        toMenu = new JButton("BACK TO MENU");
        ripPanel.add(toMenu);
        game.add(toMenu);

        game.add(ripPanel);
        ripPanel.setVisible(false);
        
        label.setBounds((game.getWidth()-367)/2, (game.getHeight()-500)/2, 367, 500);
        game.add(label);

        mes.setFont(new Font("Arial", 2, 30));
        mes.setForeground(new Color(255,255,255));
        mes.setBounds(10, 10, 300, 140);
        mes.setBackground(new Color(0, 0, 0, 0));
        game.add(mes);
    }
};