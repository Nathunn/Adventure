package UI;

import Game.Game;
import Monster.SuperMonster;

import javax.swing.*;
import java.awt.*;

public class UI {

    JFrame window;
    public JPanel titleNamePanel, infoNamePanel;
    public JPanel startButtonPanel,infoButtonPanel;
    public JPanel mainTextPanel;
    public JPanel choiceButtonPanel;
    public JPanel playerPanel;
    public JLabel titleNameLabel, infoNameLabel;
    public JLabel hpLabel, itemLabel, weaponLabel ,monsterWeaponLabel,monsterWeaponNameLabel, monsterHpNumberLabel, monsterHpLabel;
    public JLabel hpNumberLabel, itemNameLabel, weaponNameLabel;
    public JTextArea mainTextArea, infoTextArea;
    public JButton startButton,infoButton, choice1, choice2, choice3, choice4;
    Font titleFont = new Font("BIZ UDMincho", Font.PLAIN, 115);
    Font normalFont = new Font("BIZ UDMincho", Font.PLAIN, 26);
    Font buttonFont = new Font("BIZ UDMincho", Font.PLAIN, 30);

    //SuperMonster monster = new SuperMonster();


    public void createUI(Game.ChoiceHandler choiceHandler) {
        //WINDOW
        window = new JFrame("ADVENTURE");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);


        //TITLE SCREEN
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 500);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("ADVENTURE.");
        titleNameLabel.setForeground(Color.yellow);
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);

        //START BUTTON
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);
        startButton = new JButton("BEGIN");
        startButton.setBackground(Color.white);
        startButton.setForeground(Color.black);
        startButton.setFont(buttonFont);
        startButton.setFocusPainted(false);
        startButton.addActionListener(choiceHandler);
        startButton.setActionCommand("begin");
        startButtonPanel.add(startButton);
        //INSTANTIATE EVERYTHING TO GAME WINDOW HERE:
        window.add(titleNamePanel);
        window.add(startButtonPanel);


        //TODO -------
        //INFO/HOW TO PLAY SCREEN
        infoNamePanel = new JPanel();
        infoNamePanel.setBounds(100, 100, 600, 250); //THESE BOUNDS ARE TOO SMALL. NEED TO SHOW ENTIRE SPACE.
        infoNamePanel.setBackground(Color.black);
        infoNameLabel = new JLabel("HOW TO PLAY:");
        infoNameLabel.setForeground(Color.white);
        infoNameLabel.setFont(normalFont);
        infoNamePanel.add(infoNameLabel);

        infoButtonPanel = new JPanel();
        infoButtonPanel.setBounds(300, 400, 200, 100);
        infoButtonPanel.setBackground(Color.black);

        infoTextArea = new JTextArea();
        infoTextArea.setBounds(100, 100, 600, 300);
        infoTextArea.setBackground(Color.black);
        infoTextArea.setForeground(Color.white);
        infoTextArea.setFont(normalFont);
        infoTextArea.setLineWrap(true);
        infoTextArea.setWrapStyleWord(true);
        infoTextArea.setEditable(false);
        infoNamePanel.add(infoTextArea);

        infoButton = new JButton("START");
        infoButton.setBackground(Color.white);
        infoButton.setForeground(Color.black);
        infoButton.setFont(buttonFont);
        infoButton.setFocusPainted(false);
        infoButton.addActionListener(choiceHandler);
        infoButton.setActionCommand("start");
        infoButtonPanel.add(infoButton);

        window.add(infoNamePanel);
        window.add(infoButtonPanel);

        //GAME SCREEN
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        window.add(mainTextPanel);

        mainTextArea = new JTextArea();
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        window.add(choiceButtonPanel);

        choice1 = new JButton("#1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);
        choice2 = new JButton("#2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);
        choice3 = new JButton("#3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);
        choice4 = new JButton("#4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);

        playerPanel = new JPanel();
        playerPanel.setBounds(10, 15, 760, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1, 4));
        window.add(playerPanel);

        //HP/WEAPON/ITEM LABELS

        //TODO HP LABELS\\
        hpLabel = new JLabel();
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);
        hpNumberLabel = new JLabel();
        hpNumberLabel.setForeground(Color.white);
        hpNumberLabel.setFont(normalFont);
        playerPanel.add(hpNumberLabel);
        //TODO HP LABELS\\


        //TODO ITEM LABELS\\
        itemLabel = new JLabel("Item:");
        itemLabel.setFont(normalFont);
        itemLabel.setForeground(Color.white);
        itemLabel.setVisible(false); //WE WANT TO SET THIS TO TRUE ONCE WE FIND THE ITEM.
        playerPanel.add(itemLabel);
        itemNameLabel = new JLabel();
        itemNameLabel.setForeground(Color.white);
        itemNameLabel.setFont(normalFont);
        playerPanel.add(itemNameLabel);
        //TODO ITEM LABELS\\


        //TODO WEAPON LABELS\\
        weaponLabel = new JLabel("Weapon:");
        weaponLabel.setForeground(Color.white);
        weaponLabel.setFont(normalFont);
        playerPanel.add(weaponLabel);
        weaponNameLabel = new JLabel();
        weaponNameLabel.setForeground(Color.decode("#ab500b"));
        weaponNameLabel.setFont(normalFont);
        playerPanel.add(weaponNameLabel);
        //TODO WEAPON LABELS\\

        monsterHpLabel = new JLabel("HP: ");
        monsterHpLabel.setForeground(Color.white);
        monsterHpLabel.setFont(normalFont);
        window.add(monsterHpLabel);
        monsterHpNumberLabel = new JLabel();
        monsterHpNumberLabel.setForeground(Color.green);
        monsterHpNumberLabel.setFont(normalFont);
        window.add(monsterHpNumberLabel);

        monsterWeaponLabel = new JLabel("Weapon: ");
        monsterWeaponLabel.setForeground(Color.white);
        monsterWeaponLabel.setFont(normalFont);
        window.add(monsterWeaponLabel);
        monsterWeaponNameLabel = new JLabel();
        monsterWeaponNameLabel.setForeground(Color.decode("#ff002e"));
        monsterWeaponNameLabel.setFont(normalFont);
        window.add(monsterWeaponNameLabel);


        window.setVisible(true);

    }

}
