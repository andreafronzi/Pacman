package it.unibo.view.impl;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import it.unibo.controller.impl.ControllerImpl;
import it.unibo.controller.api.Controller;

public class ButtonsPanel extends JPanel {

    final Controller controller = new ControllerImpl();

    ButtonsPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        final JButton down = new JButton("DOWN");
    //down.addActionListener(e -> controller.moveDown());
        this.add(down);
        final JButton up = new JButton("UP");
    //up.addActionListener(e -> controller.moveUp());
        this.add(up);
        final JButton right = new JButton("RIGHT");
    //right.addActionListener(e -> controller.moveRight());
        this.add(right);
        final JButton left = new JButton("LEFT");
    //left.addActionListener(e -> controller.moveLeft());
        this.add(left);
    }
}

