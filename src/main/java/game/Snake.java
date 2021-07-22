package game;

import config.Unit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Snake {
     public final List<Part> parts = new ArrayList<>();
     public final Head head;
     final Unit unit;

    public Snake(double allXPosition, double allYPosition, Unit unit) {
        this.unit = unit;
        int xCenter = (int) (allXPosition / 2);
        int yCenter = (int) (allYPosition / 2);
        head  = new Head(unit.mesureOf(xCenter), unit.mesureOf(yCenter), "up");
        parts.addAll(List.of(head,
                new BodyPart(unit.mesureOf(xCenter), unit.mesureOf(xCenter - 1), "up"),
                new BodyPart(unit.mesureOf(xCenter), unit.mesureOf(yCenter - 2), "up")));
    }

    public void walk(String direction){
        if ("down".equals(direction)){
            if ((!head.direction.equals("up"))) goDown();
            else goUp();
        }if ("up".equals(direction)){
            if (!head.direction.equals("down")) goUp();
            else goDown();
        }if ("left".equals(direction)){
            if (!head.direction.equals("right")) goLeft();
            else goRight();
        }if ("right".equals(direction)){
            if (!head.direction.equals("left"))goRight();
            else goLeft();
        }
    }

    private void moveRestParts() {
        IntStream.iterate(parts.size() - 1, i -> i > 0, i -> i - 1)
                .forEach(i -> parts.get(i).goTo(parts.get(i - 1)));
    }

    public void goDown(){
        head.setY(head.getY() - unit.mesureOf1Unit);
        head.setDirection("down");
        moveRestParts();
    }

    public void goUp(){
        head.setY(head.getY() + unit.mesureOf1Unit);
        head.setDirection("up");
        moveRestParts();
    }

    public void goLeft(){
        head.setX(head.getX() - unit.mesureOf1Unit);
        head.setDirection("left");
        moveRestParts();
    }

    public void goRight(){
        head.setX(head.getX() + unit.mesureOf1Unit);
        head.setDirection("right");
        moveRestParts();
    }

    public void eat(){
        parts.add(Part.copyOf(parts.get(parts.size() - 1)));
    }

    public boolean doesMett(Part part){
        return (head.getX() == part.getX() && head.getY() == part.getY());
    }

    public void draw(Unit unit) {
        parts.forEach(p -> p.draw(unit));
        head.draw(unit);
    }

    public String doesDie() {
        return "Your score ist : " + (parts.size() - 3) + "\n";
    }
}
