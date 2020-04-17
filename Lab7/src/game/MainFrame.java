package game;

import javax.swing.*;
import java.awt.*;

// Опис вікна програми
public class MainFrame extends JFrame {
    MainFrame(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        this.setSize(new Dimension(1400, 800));



        var panel = new GamePanel(this, 1366, 768);
        add(panel);
        setVisible(true);
    }
}