import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Snake {
    private final List<Part> parts = new ArrayList<>();
    private final Head head;
    private final Unit unit;


    public Snake(int allXPosition, int allYPosition, Unit unit) {
        this.unit = unit;
        double xCenter = allXPosition >> 1;
        double yCenter = allYPosition >> 1;
        head  = new Head();
        parts.addAll(List.of(head,
                new BodyPart(xCenter, yCenter - unit.mesureOf1Unit, "up"),
                new BodyPart(xCenter, yCenter - unit.unitsOf(2), "up")));
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

}
