package VisibilityManager;

import UI.UI;

public class VisibilityManager {

    UI ui;

    public VisibilityManager(UI userInterface) {
        ui = userInterface;
    }

    public void showInfoScreen(){
        //Show info screen
        ui.infoNamePanel.setVisible(true);
        ui.infoButtonPanel.setVisible(true);


        //Show the title Screen
        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);

        //Hide the game screen
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);


    }

    //WHENEVER YOU WANT TO DISPLAY TITLE SCREEN USE THIS METHOD
    public void showTitleScreen() {
        //Hide info screen
        ui.infoNamePanel.setVisible(false);
        ui.infoButtonPanel.setVisible(false);

        //Show the title Screen
        ui.titleNamePanel.setVisible(true);
        ui.startButtonPanel.setVisible(true);

        //Hide the game screen
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);
    }

    public void titleToTown()
    {
        //Hide info Screen
        ui.infoNamePanel.setVisible(false);
        ui.infoButtonPanel.setVisible(false);

        //Hide the game screen
        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);

        //Show game screen
        ui.mainTextPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(true);
        ui.playerPanel.setVisible(true);
    }
}

