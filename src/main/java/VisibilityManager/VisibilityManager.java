package VisibilityManager;

import UI.UI;

public class VisibilityManager {

    UI ui;

    public VisibilityManager(UI userInterface) {
        ui = userInterface;
    }

    //WHENEVER YOU WANT TO DISPLAY TITLE SCREEN USE THIS METHOD
    public void showTitleScreen() {
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
        //Hide the game screen
        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);

        //Show game screen
        ui.mainTextPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(true);
        ui.playerPanel.setVisible(true);
    }
}

