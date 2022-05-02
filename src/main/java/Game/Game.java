package Game;

import Story.Story;
import UI.UI;
import VisibilityManager.VisibilityManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    //INSTANTIATE
    ChoiceHandler choiceHandler = new ChoiceHandler();
    UI ui = new UI(); //
    VisibilityManager vm = new VisibilityManager(ui);
    Story story = new Story(this, ui, vm);

    public String nextPos1;
    public String nextPos2;
    public String nextPos3;
    public String nextPos4;


    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        //Calls our CreateUI method to show window.
        ui.createUI(choiceHandler);
        story.defaultSetup();
        vm.showTitleScreen();

    }

    public class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();

            switch (yourChoice) {
                case "start": vm.titleToTown(); story.townGate();
                    break;
                case "c1": story.selectPos(nextPos1);
                    break;
                case "c2": story.selectPos(nextPos2);
                    break;
                case "c3": story.selectPos(nextPos3);
                    break;
                case "c4": story.selectPos(nextPos4);
                    break;
            }
        }
    }
}
