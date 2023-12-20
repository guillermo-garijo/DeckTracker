package presentation;

import javax.swing.*;

public class Controller {
    private LocalDeckUI localDeckUI;
    private JFrame frame;
    public Controller() {
        frame = new JFrame();
        localDeckUI = new LocalDeckUI();
    }
}
