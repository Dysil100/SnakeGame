package game;

import config.Unit;
import libraries.StdDraw;

public class Food extends Part implements Element{

    public Food(double x, double y, String direction) {
        super(x, y, direction);
    }

    public Food() {
        x = 21;
        y = 21;
    }

    @Override
    public void draw(Unit unit) {
        StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
        StdDraw.filledCircle(x, y, unit.mesureOf(.60));
        StdDraw.setPenColor(StdDraw.YELLOW);
        StdDraw.filledCircle(x, y + unit.mesureOf(0.2), unit.mesureOf(.20));
    }
}
