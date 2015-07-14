/**
 * Created by Caner on 14/07/2015.
 */
public class Tile {
    Tile up,left,right,opUp,opLeft,opRight;
    int value;

    public Tile(Tile up, Tile left, Tile right) {
        value = 0;
        this.up = up;
        this.left = left;
        this.right = right;
        if(up != null)
            up.setOpUp(this);
        if(left != null)
            left.setOpLeft(this);
        if(right != null)
            right.setOpRight(this);
    }

    public void moveUp(){
        if( up != null && (up.value == value && value != 0 || up.value == 0)){
            if(up.value == value && value != 0)
                up.value++;
            else if(up.value == 0)
                up.value = value;
            value = 0;
            if(opUp != null)
                opUp.moveUp();
        }
    }

    public void moveLeft(){
        if( left != null && (left.value == value && value != 0 || left.value == 0)){
            if(left.value == value  && value != 0)
                left.value++;
            else if(left.value == 0)
                left.value = value;
            value = 0;
            if(opUp != null)
                opUp.moveLeft();
        }
    }

    public void moveRight(){
        if( right != null && (right.value == value && value != 0 || right.value == 0)){
            if(right.value == value && value != 0)
                right.value++;
            else if(right.value == 0)
                right.value = value;
            value = 0;
            if(opRight != null)
                opRight.moveRight();
        }
    }

    public void setUp(Tile up) {
        this.up = up;
        if(up != null)
            up.setOpUp(this);
    }

    public void setLeft(Tile left) {
        this.left = left;
        if(left != null)
            left.setOpLeft(this);
    }

    public void setRight(Tile right) {
        this.right = right;
        if(right != null)
            right.setOpRight(this);
    }

    private void setOpUp(Tile opUp) {
        this.opUp = opUp;
    }

    private void setOpLeft(Tile opLeft) {
        this.opLeft = opLeft;
    }

    private void setOpRight(Tile opRight) {
        this.opRight = opRight;
    }
}
