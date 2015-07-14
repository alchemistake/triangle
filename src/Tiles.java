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
    }
}
