package game.elements;


import java.awt.*;
import java.util.Random;

public class BodyPart extends Part implements Element {

    Random random = new Random();

    public BodyPart() {
        super();
    }

    public BodyPart(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics, int size) {
        graphics.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
        super.draw(graphics, size);
    }
}
