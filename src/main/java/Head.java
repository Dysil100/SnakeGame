public class Head extends Part implements Element {
    public Head(double x, double y, String direction) {
        super(x, y, direction);

    }

    public Head() {
       super();
    }

    @Override
    public void draw(Unit unit) {
        StdDraw.setPenColor(StdDraw.MAGENTA);
        super.draw(unit);
    }
}
