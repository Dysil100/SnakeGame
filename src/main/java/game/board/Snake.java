package game.board;

import game.elements.BodyPart;
import game.elements.Food;
import game.elements.Head;
import game.elements.Part;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Snake {
    private final List<Part> parts = new ArrayList<>();
    public Head head;
    final int size;


    public Snake(int unitSize) {
        size = unitSize;
        initThis();
    }

    void initThis() {
        head = new Head(3*size, size, 'R');
        parts.add(head);
        parts.add(new BodyPart(2 * size, size));
        parts.add(new BodyPart(size, size));
        parts.add(new BodyPart(0, size));
    }


    public void move() {
        if ('D' == head.getDirection() ) goDown();
        if ('U' == head.getDirection()) goUp();
        if ('L' == head.getDirection()) goLeft();
        if ('R' == head.getDirection()) goRight();
    }

    private void moveRestParts() {
        IntStream.iterate(parts.size() - 1, i -> i > 0, i -> i - 1).forEach(this::shift);
    }

    public void goDown() {
        head.setDirection('D');
        moveRestParts();
        head.setY(head.getY() + size);
    }

    public void goUp() {
        head.setDirection('U');
        moveRestParts();
        head.setY(head.getY() - size);
    }

    public void goLeft() {
        head.setDirection('L');
        moveRestParts();
        head.setX(head.getX() - size);
    }

    public void goRight() {
        head.setDirection('R');
        moveRestParts();
        head.setX(head.getX() + size);
    }

    public void eat() {
        Part lastPart = parts.get(parts.size() - 1);
        Part newPart = new BodyPart(lastPart.getX(), lastPart.getY());
        parts.add(newPart);
    }

    private void shift(int i) {
        parts.get(i).goTo(parts.get(i - 1));
    }

    public List<Part> getParts() {
        return parts;
    }


    @Override
    public String toString() {
        return "Snake{" +
               "parts=" + parts +
               ", size=" + size +
               '}';
    }

    public boolean eatingHisSelf() {
        return IntStream.range(1, parts.size() - 1).anyMatch(i ->
                (head.getX() == parts.get(i).getX()) && (head.getY() == parts.get(i).getY()));
    }

    public boolean isAt(Food food) {
        return (head.getX() == food.getX()) && (head.getY() == food.getY());
    }

    public int getEatens() {
        return parts.size() - 4;
    }

    public boolean doesTouchBorders(int screenHeight, int screenWith) {
        return ((head.getX() < 0) || (head.getX() > screenWith)) || ((head.getY() < 0) || (head.getY() > screenHeight));
    }

    public char getDirection() {
        return head.getDirection();
    }

    public void setDirection(char direction) {
        head.setDirection(direction);
    }
}
