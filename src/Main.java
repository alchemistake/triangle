import java.util.Random;
import java.util.Scanner;

/**
 * Created by Caner on 14/07/2015.
 */
public class Main {
//    static Tile[] tiles;
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        tiles = new Tile[9];
//
//        tiles[0] = new Tile(null,null,null);
//        tiles[4] = new Tile(null,null,null);
//        tiles[8] = new Tile(null,null,null);
//
//        tiles[1] = new Tile(null,null,null);
//        tiles[3] = new Tile(null,null,null);
//        tiles[6] = new Tile(null,null,null);
//
//        tiles[2] = new Tile(tiles[0],tiles[1],tiles[3]);
//        tiles[6].setUp(tiles[2]);
//
//        tiles[5] = new Tile(tiles[1],tiles[4],tiles[6]);
//        tiles[3].setLeft(tiles[5]);
//
//        tiles[7] = new Tile(tiles[3],tiles[6],tiles[8]);
//        tiles[1].setRight(tiles[7]);
//
//        Random random = new Random();
//
//        do{
//            tiles[random.nextInt(9)].value = 1;
//
//            tilePrinter(tiles);
//
//            play(scanner.next().charAt(0));
//        }while(!isGameOver());
//    }
//
//    public static void tilePrinter(Tile[] tiles) {
//        int length = tiles.length-((int)Math.pow(Math.sqrt(tiles.length) - 1,2));
//
//        int k = 0;
//        for (int i = 1; i <= length; i += 2) {
//            for (int j = 0; j < (length - i) / 2; j++) {
//                System.out.print(" ");
//            }
//            for (int j = 0; j < i; j++) {
//                System.out.print(tiles[k++].value);
//            }
//            System.out.println();
//        }
//    }
//
//    public static void play( char c){
//        if( c == 'w'){
//            for (int i = 0; i < 9; i++) {
//                tiles[i].moveUp();
//            }
//        }else if( c == 'a'){
//            for (int i = 0; i < 9; i++) {
//                tiles[i].moveLeft();
//            }
//        }else if( c == 'd'){
//            for (int i = 0; i < 9; i++) {
//                tiles[i].moveRight();
//            }
//        }
//    }
//
//    public static boolean isGameOver(){
//        for (int i = 0; i < 9; i++) {
//            if( tiles[i].value == 0)
//                return false;
//        }
//        return true;
//    }
    public static void main(String[] args) {
        Tiles tiles = new Tiles();
        Scanner scanner = new Scanner(System.in);

        do{
            tiles.randomGenerator();
            System.out.println(tiles);
            String str = scanner.next().toLowerCase();
            if(str.charAt(0)=='w')
                tiles.playUp();
            else if(str.charAt(0) == 'a')
                tiles.playLeft();
            else if(str.charAt(0) == 'd')
                tiles.playRight();
        }while(tiles.isGameOn());
    }
        // LEFT

//        for (int i = 0; i < 5; i++) {
//            for (int j = i; j < 5; j++) {
//                System.out.println(j*j + 2 * i);
//            }
//            for (int j = i + 1; j < 5; j++) {
//                System.out.println(j*j + 2 * i + 1);
//            }
//        }


        // RIGHT

//        for (int i = 1; i < 6; i++) {
//            for (int j = i; j < 6; j++) {
//                System.out.println(j*j - 2 * i + 1);
//            }
//            for (int j = i + 1; j < 6; j++) {
//                System.out.println(j*j - 2 * i);
//            }
//        }
//    }
}
