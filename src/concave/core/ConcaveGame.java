package concave.core;

import concave.ui.GameGUI;
import javax.swing.SwingUtilities;

public class ConcaveGame {

    public static void main(String[] args) {
        ConcaveGame game = new ConcaveGame();


        SwingUtilities.invokeLater(() -> {
            GameGUI gui = new GameGUI(game);
            gui.setVisible(true);
        });
    }
}
