package game;

import game.board.GameBoard;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    public GameFrame() throws HeadlessException {
        this.add(new GameBoard());
        this.setTitle("Snake-Game V2");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

}
