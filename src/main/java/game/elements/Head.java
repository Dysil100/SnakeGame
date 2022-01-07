package game.elements;


import java.awt.*;

public class Head extends Part implements Element {
    private char direction;

    public Head(int x, int y, char direction) {
        super(x, y);
        this.direction = direction;
    }
    public void setDirection(char direction) {
        this.direction = direction;
    }

    public char getDirection() {
        return direction;
    }


    public Head() {
       super();
        this.direction = 'R';
    }

    @Override
    public void draw(Graphics graphics, int size) {
        graphics.setColor(Color.BLUE);
        super.draw(graphics, size);
    }

    @Override
    public String toString() {
        return "{Head" + super.toString() +
               "directon=" + direction +
               '}';
    }
}
