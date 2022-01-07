package game.elements;

import java.awt.*;

public abstract class Part implements Element {
    private int x;
    private int y;

    public Part(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Part() {
        this.x = 20;
        this.y = 20;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static Part copyOf(Part part) {
        return new BodyPart(part.getX(), part.getY());
    }

    public void goTo(Part part) {
        this.setX(part.getX());
        this.setY(part.getY());
    }

    public void draw(Graphics graphics, int size) {
        graphics.fillRect(x, y, size, size);
    }

    @Override
    public String toString() {
        return "Part{" +
               "x=" + x +
               ", y=" + y +
               '}';
    }
}
