package game.elements;

import java.awt.*;

public class Food extends Part implements Element {

    public Food(int x, int y) {
        super(x, y);
    }

    public Food() {
        super();
    }

    @Override
    public void draw(Graphics graphics, int size) {
        graphics.setColor(Color.green);
        super.draw(graphics, size);

    }
}
