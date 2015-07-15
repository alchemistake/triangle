import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Alchemistake on 15/07/15.
 */
public class Game extends JPanel {
    Tiles tiles;

    public Game() {
        tiles = new Tiles();
        tiles.randomGenerator();
        setPreferredSize(new Dimension(500, 451));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new InputListener());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                g.drawPolygon(new int[]{250 - i * 50 + j * 100, 250 - i * 50 - 50 + j * 100, 250 - i * 50 + 50 + j * 100}, new int[]{i * 90, i * 90 + 90, i * 90 + 90}, 3);
            }
        }

        int k = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 2 * i + 1; j++) {
                g.drawString(String.valueOf(tiles.tiles[k++].value), 250+(j-i)*50 , i*90 + 45);
            }
        }
    }

    private class InputListener extends KeyAdapter{
        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_UP){
                tiles.playUp();
                tiles.randomGenerator();
                repaint();
            }else if(e.getKeyCode() == KeyEvent.VK_LEFT){
                tiles.playLeft();
                tiles.randomGenerator();
                repaint();
            }if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                tiles.playRight();
                tiles.randomGenerator();
                repaint();
            }
        }
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.add(new Game());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
