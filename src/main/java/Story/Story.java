package Story;

import Game.Game;
import Items.SuperItem;
import Monster.Monster_Goblin;
import Monster.SuperMonster;
import Monster.Weapon_Claws;
import Player.Player;
import UI.UI;
import VisibilityManager.VisibilityManager;
import Weapon.SuperWeapon;
import Weapon.Weapon_WoodBow;
import Weapon.Weapon_Knife;

import java.awt.*;

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



//*TODO LIST*
//----------
// Continue Story after boss fight
//Add dmg buff for silver ring
// Add "CRITICAL STRIKE" for attacks higher than a certain number
// Claws as weapon for goblin since it says hes not holding a weapon
//Implement other Attack option, with more rare chance to hit. (so not as boring to just attack)




public class Story {

    Game game;
    UI ui;
    VisibilityManager vm;
    Player player = new Player();
    SuperMonster monster = new SuperMonster();
    SuperItem item = new SuperItem();

    int silverRing;
    int critChanceHat;

    public Story(Game g, UI userInterface, VisibilityManager vManager) {
        game = g;
        ui = userInterface;
        vm = vManager;

        silverRing = 0;
        critChanceHat = 0;
    }

    public void defaultSetup() {
        player.hp = 50;
        ui.hpNumberLabel.setText("" + player.hp);
        ui.hpNumberLabel.setForeground(Color.green);
        ui.hpLabel.setText("HP" + "  :");

        player.currentWeapon = new Weapon_Knife();
        ui.weaponNameLabel.setText("" + player.currentWeapon.name);

    }

    //Switches for button prompts
    public void selectPos(String nextPos) {
        switch (nextPos) {
            case "townGate": townGate(); break;
            case "speakGuard": speakGuard(); break;
            case "attackGuard": attackGuard(); break;
            case "crossRoad": crossRoad(); break;
            case "titleScreen": titleScreen(); break;
            case "forest": forest(); break;
            case "uTunnel": undergroundTunnel(); break;
            case "creek": creek(); break;
            case "followCreek": followCreek(); break;
            case "forestFight": forestFight(); break;
            case "attack": playerAttack(); break;
            case "monsterAttack": monsterAttack(); break;
            case "darkTrees": darkTrees(); break;
            case "yesGnome": gnomeKey(); break;
            case "goblinWin": goblinWin(); break;
            case "continueForest": continueForest(); break;
            case "loseGame": loseGame(); break;
            case "outerForest": outerForest(); break;
            case "enterTown": enterTown(); break;
            case "continueDarkForest": continueDarkForest(); break;
        }

    }

    //TITLE SCREEN METHOD
    public void titleScreen() {
        //"titleScreen" :
        vm.showTitleScreen();
    }




    //WHERE THE STORY BEGINS

    //TODO######****** START CROSS ROAD MENU ######******\\

    public void crossRoad() {
        ui.mainTextArea.setText("You remember nothing. \n\nYou awaken confused and in need of shelter.\tTo your left, is a dense but dark forest.\nTo your right, is a poorly dug Underground Tunnel.\n\n All you have is a knife. (+3 dmg)"); //
        ui.choice1.setText("Forest");
        ui.choice2.setText(".locked.");
        ui.choice3.setText(".locked."); // was Town Gate
        ui.choice4.setText("Underground Tunnel"); // Maybe can implement Town Gate into here if caught.

        game.nextPos1 = "forest";
        game.nextPos2 = "";
        game.nextPos3 = ""; // was townGate
        game.nextPos4 = "uTunnel";
    }

    //TODO######****** END CROSS ROAD MENU ######******\\


    //TODO######****** START INFO SCREEN ######******\\
    public void infoScreen()
    {
        ui.infoTextArea.setText("This is a text-based game where your decisions matter.\n\nClick the button prompts at the bottom of the screen to progress.\n\nGoal: Get into the nearest Town...Alive.");
        ui.choice1.setText("");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPos1 = "";
        game.nextPos2 = "";
        game.nextPos3 = "";
        game.nextPos4 = "";
    }

    //TODO######****** END INFO SCREEN ######******\\


    //TODO######****** START TOWN GATE ROUTE ######******\\
    public void townGate() {
        ui.mainTextArea.setText("You arrive at the Town Gate. \nA guard is standing in front of you.  \n\nWhat do you do?");
        ui.choice1.setText("Speak to Guard");
        ui.choice2.setText("Attack the Guard");
        ui.choice3.setText("Leave");
        ui.choice4.setText("");

        game.nextPos1 = "speakGuard";
        game.nextPos2 = "attackGuard";
        game.nextPos3 = "crossRoad";
        game.nextPos4 = "";
    }

    public void speakGuard() {
        if (silverRing == 0)
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

        } else if(silverRing == 1)
        {ui.mainTextArea.setText("Guard: My grandmothers ring! \n\n Please, come in! She will not believe this.");
            ui.choice1.setText("Enter Town!");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");
            game.nextPos1 = "enterTown";
            game.nextPos2 = "";
            game.nextPos3 = "";
            game.nextPos4 = "";

        }

    }

    public void enterTown()
    {
        ui.mainTextArea.setText("gg");
        ui.choice1.setText("Return to Menu");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPos1 = "crossRoad";
        game.nextPos2 = "";
        game.nextPos3 = "";
        game.nextPos4 = "";

    }

    public void attackGuard() {
        ui.mainTextArea.setText("Guard: Don't be foolish! \n\nThe Guard attacked you, \n( -3 HP )");
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

    //TODO######****** END TOWN GATE ROUTE ######******\\


    //TODO######****** START FOREST ROUTE ######******\\
    public void forest() {
        ui.mainTextArea.setText("You stumble in a nearby forest, you notice a pathway that splits into two... \n\n Left: A narrow pathway leading to a small creek.\n Right: A dim path of dense trees that fades into darkness. \n\nWhich route are you taking?");
        ui.choice1.setText("Creek");
        ui.choice2.setText("Dark Trees");
        ui.choice3.setText("");
        ui.choice4.setText("return");

        game.nextPos1 = "creek";
        game.nextPos2 = "darkTrees";
        game.nextPos3 = "";
        game.nextPos4 = "crossRoad";

    }
    public void creek()
    {
        ui.mainTextArea.setText("You continue towards the small creek..\n\nYou slip and fall into the creek (-2 HP). \n\nYou notice something under the water.. \n(Weapon Unlock: Wood Bow)"); //create bow weapon
        player.hp = player.hp - 2;
        ui.hpNumberLabel.setText("" + player.hp);
        player.currentWeapon = new Weapon_WoodBow();
        ui.weaponNameLabel.setText("" + player.currentWeapon.name);
        ui.choice1.setText("Follow the creek");//ADD A CONTINUE ON? FIGHT A MONSTER?
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("Return to Forest");

        game.nextPos1 = "followCreek";
        game.nextPos2 = "";
        game.nextPos3 = "";
        game.nextPos4 = "forest";

    }
    public void followCreek()
    {
        monster = new Monster_Goblin();

        ui.mainTextArea.setText("You encounter a " + monster.name + "!" + "\nHe has long sharp claws, but looks frail. \n\nWhat do you do?");
        ui.choice1.setText("Fight!");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("Run.");

        game.nextPos1 = "forestFight";
        game.nextPos2 = "";
        game.nextPos3 = "";
        game.nextPos4 = "forest";
    }


    //TODO######****** FOREST FIGHT SCENE WITH ATTACK METHODS ######****** //

    public void forestFight() //
    {
        monster.currentWeapon = new Weapon_Claws();

        ui.mainTextArea.setText("\t\t" + monster.name + ": " + "\n\nHP:" + monster.hp + "\t\tWeapon: " + monster.currentWeapon.name + "\n\n\n\t\t  Your move.");
        ui.choice1.setText("Attack");
        ui.choice2.setText("Special Attack (20%)"); // Add
        ui.choice3.setText("");
        ui.choice4.setText("Run.");

        game.nextPos1 = "attack";
        game.nextPos2 = "";
        game.nextPos3 = "";
        game.nextPos4 = "forest";


    }

    //THESE NEED TO BE DOUBLE CHECKED

    public void playerAttack()
    {
        int playerDmg = new java.util.Random().nextInt(player.currentWeapon.damage); //Dmg is now random
        monster.hp = monster.hp - playerDmg;

        ui.mainTextArea.setText("\t\t" + monster.name + ": " + "\n\nHP: " + monster.hp + "\t\tWeapon: " + monster.currentWeapon.name + "\n\n\tYou attack the " + monster.name + "!" + "\n\t\tHit: " + playerDmg + " dmg!");
        ui.choice1.setText("Attack!");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("Run.");

        if(monster.hp > 0)
        {
            game.nextPos1 = "monsterAttack";
            game.nextPos2 = "";
            game.nextPos3 = "";
            game.nextPos4 = "forest";
        }
        else if(monster.hp <= 3)
        {
            ui.choice1.setText("FINISH HIM!");
            game.nextPos1 = "goblinWin";
            game.nextPos2 = "";
            game.nextPos3 = "";
            game.nextPos4 = "";

        }
    }

    public void monsterAttack()
    {
        int monsterDmg = new java.util.Random().nextInt(monster.attack);

        ui.mainTextArea.setText("\t\t" + monster.name + ": " + "\n\nHP: " + monster.hp + "\t\tWeapon: " + monster.currentWeapon.name + "\n\n\tGoblin Strikes! " + "\n\t\tHit: " + monsterDmg + "!");
        player.hp = player.hp - monsterDmg;
        ui.hpNumberLabel.setText("" + player.hp);
        ui.choice1.setText("Attack!");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("Run.");

        if(monster.hp <= 0)
        {
            ui.choice1.setText("FINISH HIM!");
            game.nextPos1 = "attack";
            game.nextPos2 = "";
            game.nextPos3 = "";
            game.nextPos4 = "forest";
        }

        if(player.hp > 0)
        {
            game.nextPos1 = "attack";
            game.nextPos2 = "";
            game.nextPos3 = "";
            game.nextPos4 = "forest";
        }
        else if(player.hp < 1)
        {
            game.nextPos1 = "loseGame";
            game.nextPos2 = "";
            game.nextPos3 = "";
            game.nextPos4 = "";

        }
    }

    public void loseGame()
    {
        ui.mainTextArea.setText("\t\tYou are dead! \n\n\n<GAME OVER>\t<GAME OVER>\t<GAME OVER>\n<GAME OVER>\t<GAME OVER>\t<GAME OVER>");
        ui.choice1.setText("Restart.");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPos1 = "titleScreen";
        game.nextPos2 = "";
        game.nextPos3 = "";
        game.nextPos4 = "";
    }
    public void goblinWin()
    {
        ui.mainTextArea.setText("\tYou have slain the Goblin!\n\n(You obtained a Silver Ring (+4 dmg))"); // Where to progress from here.
        silverRing = 1;

        ui.choice1.setText("Continue");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPos1 = "continueForest";
        game.nextPos2 = "";
        game.nextPos3 = "";
        game.nextPos4 = "";

    }

    public void continueForest()
    {
        if(silverRing == 1)
        {
            ui.mainTextArea.setText("Goblins lowkey trash, could've done better. \nbut you did beat him. \n\nYou approach the end of the forest."); // Where to progress from here.
            ui.choice1.setText("Exit Forest");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("Forest Entrance");

            game.nextPos1 = "outerForest";
            game.nextPos2 = "";
            game.nextPos3 = "";
            game.nextPos4 = "forest";
        }

    }

    //TODO######****** FOREST FIGHT SCENE WITH ATTACK METHODS ######****** //


    public void outerForest()
    {
        ui.mainTextArea.setText("Suns shining blah, \nDo we just get to the gate now?");

        ui.choice1.setText("Town Gate"); //but you have the silver ring. You can EITHER barter the ring to get in, or get in another way and keep your dmg boost. POG
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPos1 = "townGate";
        game.nextPos2 = "";
        game.nextPos3 = "";
        game.nextPos4 = "";

    }

    public void darkTrees()
    {
        ui.mainTextArea.setText("You manage to work your way through the terribly lit forest\n\n You notice a gnome gesturing you to walk towards him.\n\n\tDo you accept?"); //create gate item
        ui.choice1.setText("Yes.");
        ui.choice2.setText("Hell nah.");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPos1 = "yesGnome";
        game.nextPos2 = "forest";
        game.nextPos3 = "";
        game.nextPos4 = "";

    }

    public void gnomeKey()
    {
        critChanceHat = 1;

            ui.itemNameLabel.setText(String.valueOf(critChanceHat));

            ui.mainTextArea.setText("You were bold enough to approach the bald headed gnome.\n\n(Item Unlocked: Hat! (+3.5% Crit chance))");
            ui.itemLabel.setVisible(true);
            ui.itemNameLabel.setVisible(true);
            ui.choice1.setText("Continue");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("Return to Forest");

            game.nextPos1 = "continueDarkForest"; // change this maybe
            game.nextPos2 = "";
            game.nextPos3 = "";
            game.nextPos4 = "forest";
    }

    public void continueDarkForest()
    {
        critChanceHat = 1;

        ui.itemNameLabel.setText(String.valueOf(critChanceHat));

        ui.mainTextArea.setText("");
        ui.itemLabel.setVisible(true);
        ui.itemNameLabel.setVisible(true);
        ui.choice1.setText("");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("Return to Forest");

        game.nextPos1 = "";
        game.nextPos2 = "";
        game.nextPos3 = "";
        game.nextPos4 = "forest";


    }




    //TODO######****** END FOREST ROUTE ######******\\


    //TODO######****** locked ROUTE ######******\\
    public void lockedR() //IF GUARD ITEM IS SECURED THEN UNLOCK THIS PATH. ELSE LEAVE LOCKED
    {


    }
    //TODO######****** locked ROUTE ######******\\


    //TODO######****** START underground Tunnel ROUTE ######******\\
    public void undergroundTunnel()
    {
        ui.mainTextArea.setText("text about what happens in Tunnel");
        ui.choice1.setText("");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPos1 = "";
        game.nextPos2 = "";
        game.nextPos3 = "";
        game.nextPos4 = "";
    }
 //TODO######****** END SNEAKY ROUTE ######******\\

}


