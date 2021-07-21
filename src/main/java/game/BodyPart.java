package game;

import config.Unit;
import libraries.StdDraw;

public class BodyPart extends Part implements Element{
    
    public BodyPart(double x) {
        super();
    }

    public BodyPart(double x, double y, String direction) {
        super(x, y, direction);
    }
    @Override
    public void draw(Unit unit){
        StdDraw.setPenColor(StdDraw.GREEN);
        super.draw(unit);
    }
}
