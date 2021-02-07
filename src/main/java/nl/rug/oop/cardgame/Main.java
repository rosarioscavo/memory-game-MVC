package nl.rug.oop.cardgame;

import nl.rug.oop.cardgame.model.Game;
import nl.rug.oop.cardgame.view.SettingsDialog;
import nl.rug.oop.cardgame.view.Frame;

public class Main {

    public static void main(String[] args) {
        SettingsDialog settings = new SettingsDialog();
        Game game = new Game(settings.getNumPairs());
        new Frame(game);
    }
}