/**
 * Created by Caner on 14/07/2015.
 */
public class Tile {
    Tile up,left,right;
    int value;

    public Tile(Tile up, Tile left, Tile right) {
        value = 0;
        this.up = up;
        this.left = left;
        this.right = right;
    }

    public void moveUp(){
        if( up != null && (up.value == value && value != 0 || up.value == 0)){
            if(up.value == value && value != 0)
                up.value++;
            else if(up.value == 0)
                up.value = value;
            value = 0;
            up.moveUp();
        }
    }

    public void moveLeft(){
        if( left != null && (left.value == value && value != 0 || left.value == 0)){
            if(left.value == value  && value != 0)
                left.value++;
            else if(left.value == 0)
                left.value = value;
            value = 0;
            left.moveLeft();
        }
    }

    public void moveRight(){
        if( right != null && (right.value == value && value != 0 || right.value == 0)){
            if(right.value == value && value != 0)
                right.value++;
            else if(right.value == 0)
                right.value = value;
            value = 0;
            right.moveRight();
        }
    }

    public void setUp(Tile up) {
        this.up = up;
    }

    public void setLeft(Tile left) {
        this.left = left;
    }

    public void setRight(Tile right) {
        this.right = right;
    }

}
