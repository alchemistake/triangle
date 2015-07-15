import javax.swing.*;
import java.util.Random;

/**
 * Created by Caner on 14/07/2015.
 */
public class Tiles {
    final static int SIZE = 5;

    Tile[] tiles;

    public Tiles() {
        tiles = new Tile[SIZE * SIZE];

        for (int i = 0; i < SIZE * SIZE; i++) {
            tiles[i] = new Tile(null,null,null);
        }

        // 0 null

        tiles[1].setRight(tiles[7]);

        tiles[2].setLeft(tiles[1]);
        tiles[2].setRight(tiles[3]);
        tiles[2].setUp(tiles[0]);

        tiles[3].setLeft(tiles[5]);

        tiles[4].setRight(tiles[12]);

        tiles[5].setUp(tiles[1]);
        tiles[5].setLeft(tiles[4]);
        tiles[5].setRight(tiles[6]);

        tiles[6].setUp(tiles[2]);
        tiles[6].setLeft(tiles[10]);
        tiles[6].setRight(tiles[14]);

        tiles[7].setUp(tiles[3]);
        tiles[7].setLeft(tiles[6]);
        tiles[7].setRight(tiles[8]);

        tiles[8].setLeft(tiles[12]);

        tiles[9].setRight(tiles[19]);

        tiles[10].setUp(tiles[4]);
        tiles[10].setLeft(tiles[9]);
        tiles[10].setRight(tiles[11]);

        tiles[11].setUp(tiles[5]);
        tiles[11].setLeft(tiles[17]);
        tiles[11].setRight(tiles[21]);

        tiles[12].setUp(tiles[6]);
        tiles[12].setLeft(tiles[11]);
        tiles[12].setRight(tiles[13]);

        tiles[13].setUp(tiles[7]);
        tiles[13].setLeft(tiles[19]);
        tiles[13].setRight(tiles[23]);

        tiles[14].setUp(tiles[8]);
        tiles[14].setLeft(tiles[13]);
        tiles[14].setRight(tiles[15]);

        tiles[15].setLeft(tiles[21]);

        // 16 null

        tiles[17].setUp(tiles[9]);
        tiles[17].setLeft(tiles[16]);
        tiles[17].setRight(tiles[18]);

        tiles[18].setUp(tiles[10]);

        tiles[19].setUp(tiles[11]);
        tiles[19].setRight(tiles[20]);
        tiles[19].setLeft(tiles[18]);

        tiles[20].setUp(tiles[12]);

        tiles[21].setUp(tiles[13]);
        tiles[21].setLeft(tiles[20]);
        tiles[21].setRight(tiles[22]);

        tiles[22].setUp(tiles[14]);

        tiles[23].setUp(tiles[15]);
        tiles[23].setLeft(tiles[22]);
        tiles[23].setRight(tiles[24]);

        // 24 null
    }

    @Override
    public String toString() {
        int length = tiles.length-((int)Math.pow(Math.sqrt(tiles.length) - 1,2));
        int k = 0;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1; i <= length; i += 2) {
            for (int j = 0; j < (length - i) / 2; j++) {
                stringBuffer.append(" ");
            }
            for (int j = 0; j < i; j++) {
                stringBuffer.append(tiles[k++].value);
            }
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }

    public void playUp(){
        for (int i = 0; i < 25; i++) {
            tiles[i].moveUp();
        }
    }

    public void playLeft(){
        for (int i = 0; i < 5; i++) {
            for (int j = i; j < 5; j++) {
                tiles[j*j + 2 * i].moveLeft();
            }
            for (int j = i + 1; j < 5; j++) {
                tiles[j*j + 2 * i + 1].moveLeft();
            }
        }
    }

    public void playRight(){
        for (int i = 1; i < 6; i++) {
            for (int j = i; j < 6; j++) {
                tiles[j*j - 2 * i + 1].moveRight();
            }
            for (int j = i + 1; j < 6; j++) {
                tiles[j*j - 2 * i].moveRight();
            }
        }
    }

    public void randomGenerator(){
        Random random = new Random();
        int i = random.nextInt(25);

        while(tiles[i].value > 0){
            i = random.nextInt(25);
        }

        if(random.nextInt(20) > 16){
            tiles[i].value = 2;
        }else{
            tiles[i].value = 1;
        }
    }

    public boolean isGameOn(){
        for (int i = 0; i < 25; i++) {
            if(tiles[i].value == 0)
                return true;
        }
        for (int i = 0; i < 25; i++) {
            tiles[i].value = 0;
        }
        return true;
    }
}
