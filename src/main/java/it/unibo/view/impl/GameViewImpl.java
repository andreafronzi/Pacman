package it.unibo.view.impl;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import it.unibo.controller.api.Controller;
import it.unibo.controller.impl.ControllerImpl;
import it.unibo.view.api.GameView;

public class GameViewImpl implements GameView {

    private final static int PROPORTION = 5;

    private final Controller controller = new ControllerImpl();
    private final JFrame view = new JFrame("pacman");

    public GameViewImpl () {
        final JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        final JPanel map = new JPanel();
        mainPanel.add(map, BorderLayout.CENTER);

        final JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
        final JButton down = new JButton("DOWN");
        //down.addActionListener(e -> controller.moveDown());
        buttons.add(down);
        final JButton up = new JButton("UP");
        //up.addActionListener(e -> controller.moveUp());
        buttons.add(up);
        final JButton right = new JButton("RIGHT");
        //right.addActionListener(e -> controller.moveRight());
        buttons.add(right);
        final JButton left = new JButton("LEFT");
        //left.addActionListener(e -> controller.moveLeft());
        buttons.add(left);
        mainPanel.add(buttons, BorderLayout.SOUTH);

        this.view.setContentPane(mainPanel);
        this.view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setScreenSize() {
        final Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        final int height = (int) screenDimension.getHeight();
        final int width = (int) screenDimension.getWidth();
        this.view.setSize(width/PROPORTION, height/PROPORTION);
    }




    @Override
    public void open() {
        setScreenSize();
        this.view.setVisible(true);
    }

    public static void main(final String... args) {
        new GameViewImpl().open();
    }

}


