import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Snake {
    private final List<Part> parts = new ArrayList<>();
    private final Part head;

    public Snake() {
        parts.addAll(List.of(new Part(), new Part(20, 19), new Part(20, 18)));
        head  = parts.get(0);
    }

    private void moveRestParts() {
        IntStream.iterate(parts.size() - 1, i -> i > 0, i -> i - 1)
                .forEach(i -> parts.get(i).goTo(parts.get(i - 1)));
    }

    public void goDown(){
        head.setY(head.getY() - 1);
        moveRestParts();
    }

    public void goUp(){
        head.setY(head.getY() + 1);
        moveRestParts();
    }

    public void goLeft(){
        head.setX(head.getX() - 1);
        moveRestParts();
    }

    public void goRight(){
        head.setX(head.getX() + 1);
        moveRestParts();
    }

    public void eat(){
        parts.add(Part.copyOf(parts.get(parts.size() - 1)));
    }

    public boolean doesMett(Part part){
        return (head.getX() == part.getX() && head.getY() == part.getY());
    }

    public void draw() {
        parts.forEach(Part::draw);
    }

}
