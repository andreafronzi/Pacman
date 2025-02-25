package it.unibo.view.impl;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.awt.Toolkit;

import it.unibo.model.api.Position;
import it.unibo.view.api.GameView;

public class GameViewImpl implements GameView {

    private static final int PROPORTION = 5;
    private static final int  WINDOW_SIZE_X  = 800;
    private static final int  WINDOW_SIZE_Y  = 600;

    private final JFrame view = new JFrame("pacman");

    public GameViewImpl () {
        final JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        final JPanel map = new VisualiserPanel();
        mainPanel.add(map, BorderLayout.CENTER);

        final JPanel buttons = new ButtonsPanel();
        mainPanel.add(buttons, BorderLayout.SOUTH);

        this.view.setContentPane(mainPanel);
        this.view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setScreenSize() {
        final Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        final int height = (int) screenDimension.getHeight();
        final int width = (int) screenDimension.getWidth();
        this.view.setSize(width/PROPORTION, height/PROPORTION);
        this.view.setResizable(false);
    }




    @Override
    public void open() {
        setScreenSize();
        this.view.setVisible(true);
    }

    public static class VisualiserPanel extends JPanel {

        private final static int PROPORTION2 = 10;
        
        private final List<Position> positions;
        private Font usedFont;

        public VisualiserPanel() {
            this.usedFont = new Font("Verdana", Font.PLAIN, 24);
            positions = new ArrayList<>();
        }

        public void paint(Graphics g) {
            

            Graphics2D g2 = (Graphics2D) g;

            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    		g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

    		g2.clearRect(0, 0, WINDOW_SIZE_X, WINDOW_SIZE_Y);
			int dx = WINDOW_SIZE_X / 2;
			int dy = WINDOW_SIZE_Y / 2;
            synchronized (this) {
				if (positions != null) {
					for (int i = 0; i < positions.size(); i++) {
						Position p = positions.get(i);
						int x0 = (int) (dx + p.X() * dx);
						int y0 = (int) (dy + p.Y() * dy);
						g.drawOval(x0, y0, 20, 20);
					}
				}
			}
            g2.setFont(usedFont);
            g2.setColor(Color.blue);
        }
    }



    public static void main(final String... args) {
        new GameViewImpl().open();
    }

}


