package Story;

import Game.Game;
import Player.Player;
import UI.UI;
import VisibilityManager.VisibilityManager;
import Weapon.Weapon_Knife;

//TODO TEMPLATE FOR TEXT/OPTIONS SCREEN
// ui.mainTextArea.setText("");
//        ui.choice1.setText("");
//        ui.choice2.setText("");
//        ui.choice3.setText("");
//        ui.choice4.setText("");
//TODO
//        game.nextPos1 = "";
//        game.nextPos2 = "";
//        game.nextPos3 = "";
//        game.nextPos4 = "";


public class Story {

    Game game;
    UI ui;
    VisibilityManager vm;
    Player player = new Player();

    public Story(Game g, UI userInterface, VisibilityManager vManager)
    {
        game = g;
        ui = userInterface;
        vm = vManager;
    }

    public void defaultSetup()
    {
        player.hp = 10;
        ui.hpNumberLabel.setText("" + player.hp);

        player.currentWeapon = new Weapon_Knife();
        ui.weaponNameLabel.setText("" + player.currentWeapon.name);

    }
    public void selectPos(String nextPos)
    {
        switch(nextPos)
        {
            case "townGate": townGate();
            break;
            case "speakGuard": speakGuard();
            break;
            case "attackGuard": attackGuard();
            break;
            case "crossRoad": crossRoad();
            break;
            case "titleScreen": titleScreen();
            break;
        }
    }
    //WHERE THE STORY BEGINS
    public void townGate()
    {
        ui.mainTextArea.setText("You arrive at the Town Gate. \nA guard is standing in front of you.  \n\nWhat do you do?");
        ui.choice1.setText("Speak to Guard");
        ui.choice2.setText("Attack the Guard");
        ui.choice3.setText("Leave");
        ui.choice4.setText("<-");

        game.nextPos1 = "speakGuard";
        game.nextPos2 = "attackGuard";
        game.nextPos3 = "crossRoad";
        game.nextPos4 = "titleScreen";
    }

    public void speakGuard()
    {
        ui.mainTextArea.setText("Guard: Hello stranger, I have never seen your face before. \n\n We cannot allow a stanger to enter our town.");
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPos1 = "townGate";
        game.nextPos2 = "";
        game.nextPos3 = "";
        game.nextPos4 = "";
    }
    public void attackGuard()
    {
        ui.mainTextArea.setText("Guard: Dont be foolish! \n\nThe Guard attacked you, \n( -3 HP )");
        player.hp = player.hp - 3;
        ui.hpNumberLabel.setText("" + player.hp);
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPos1 = "townGate";
        game.nextPos2 = "";
        game.nextPos3 = "";
        game.nextPos4 = "";
    }
    public void crossRoad()
    {
        ui.mainTextArea.setText("Welcome to Decision Screen: \n Where would you like to go?");
        ui.choice1.setText("");
        ui.choice2.setText("");
        ui.choice3.setText("Town Gate");
        ui.choice4.setText("");

        game.nextPos1 = "";
        game.nextPos2 = "";
        game.nextPos3 = "townGate";
        game.nextPos4 = "";
    }
    public void titleScreen()
    {
        vm.showTitleScreen();
    }


}


