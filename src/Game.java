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
                if(tiles.tiles[k].value == 1)
                    g.setColor(Color.BLUE);
                else if(tiles.tiles[k].value == 2)
                    g.setColor(Color.CYAN);
                else if(tiles.tiles[k].value == 3)
                    g.setColor(Color.YELLOW);
                else if(tiles.tiles[k].value == 4)
                    g.setColor(Color.MAGENTA);
                else if(tiles.tiles[k].value == 5)
                    g.setColor(Color.ORANGE);
                else if(tiles.tiles[k].value == 6)
                    g.setColor(Color.PINK);
                else if(tiles.tiles[k].value == 7)
                    g.setColor(new Color(255, 96, 248));
                else if(tiles.tiles[k].value == 8)
                    g.setColor(new Color(18, 114, 185));
                else if(tiles.tiles[k].value == 9)
                    g.setColor(Color.GREEN);
                else if(tiles.tiles[k].value == 10)
                    g.setColor(Color.GRAY);

                g.drawString(String.valueOf(tiles.tiles[k++].value), 250+(j-i)*50 , i*90 + 45);
                if(k != 25 && tiles.tiles[k].value == 0)
                    g.setColor(Color.WHITE);
            }
        }
    }

    private class InputListener extends KeyAdapter{
        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_UP){
                tiles.playUp();
                tiles.randomGenerator();
                tiles.isGameOn();
                repaint();
            }else if(e.getKeyCode() == KeyEvent.VK_LEFT){
                tiles.playLeft();
                tiles.randomGenerator();
                tiles.isGameOn();
                repaint();
            }if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                tiles.playRight();
                tiles.randomGenerator();
                tiles.isGameOn();
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
