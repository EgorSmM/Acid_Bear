package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu{

    private JComboBox<String> difficultyComboBox;

    Menu(Main main) {
        
        //панель с меню
        JPanel menuPanel = new JPanel();
        menuPanel.setBounds(0, 0, main.getWidth(), main.getHeight());
        menuPanel.setLayout(null);
        menuPanel.setBackground(new Color(0, 0, 0, 0));
        main.add(menuPanel);

        //гифка на фоне
        ImageIcon backgroundImage = new ImageIcon("../giphy.gif");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, main.getWidth(), main.getHeight());
        main.add(backgroundLabel);

        //кнопка с выходом
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(main.getWidth() / 2 - 150, main.getHeight() / 2 + 120, 300, 50);
        exitButton.setBackground(new Color(0, 0, 0, 0));
        exitButton.setForeground(new Color(255, 255, 255));
        exitButton.setFont(new Font("Arial", 1, 20));
        menuPanel.add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Завершение программы
            }
        });

        //кнопка начала игры
        JButton gameButton = new JButton("START GAME");
        gameButton.setBounds(main.getWidth() / 2 - 200, main.getHeight() / 2 - 35, 400, 70);
        gameButton.setBackground(new Color(255, 255, 255, 0));
        gameButton.setFont(new Font("Arial", 2, 30));
        gameButton.setForeground(new Color(255, 255, 255));
        menuPanel.add(gameButton);
        gameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.startGame((String) difficultyComboBox.getSelectedItem());
            }
        });

        //кнопка режима ИИ
        JButton aIButton = new JButton("AI MOD");
        aIButton.setBounds(main.getWidth() / 2 - 150, main.getHeight() / 2 + 50, 300, 50);
        aIButton.setBackground(new Color(255, 255, 255, 0));
        aIButton.setFont(new Font("Arial", 2, 20));
        aIButton.setForeground(new Color(255, 255, 255));
        menuPanel.add(aIButton);
        aIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.startAI();
            }
        });

        //бокс с выбор сложности
        String[] difficultyOptions = {"Newbee", "Normal Person", "Acid man"};
        difficultyComboBox = new JComboBox<>(difficultyOptions);
        difficultyComboBox.setBounds(main.getWidth() / 2 - 100, main.getHeight() / 2 - 170, 200, 50);
        difficultyComboBox.setBackground(new Color(0, 0, 0, 0));
        difficultyComboBox.setForeground(new Color(255, 255, 255));
        difficultyComboBox.setFont(new Font("Arial", 1, 20));
        difficultyComboBox.setVisible(false);
        menuPanel.add(difficultyComboBox);

        //кнопка с открытием бокса выбора сложности
        JButton selectDifficultyButton = new JButton("Select Difficulty Level");
        selectDifficultyButton.setBounds(main.getWidth() / 2 - 150, main.getHeight() / 2 - 230, 300, 50);
        selectDifficultyButton.setBackground(new Color(0, 0, 0, 0));
        selectDifficultyButton.setForeground(new Color(255, 255, 255));
        selectDifficultyButton.setFont(new Font("Arial", 1, 20));
        menuPanel.add(selectDifficultyButton);
        selectDifficultyButton.addActionListener(new ActionListener() {
            boolean visible = false;
            @Override
            public void actionPerformed(ActionEvent e) {
                difficultyComboBox.setVisible(!visible);
                visible = !visible;
            }
        });
    }
}