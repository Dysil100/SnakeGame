public class Food extends Part implements Element{

    @Override
    public void draw(Unit unit) {
        StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
        StdDraw.filledCircle(x, y, .60);
        StdDraw.setPenColor(StdDraw.YELLOW);
        StdDraw.filledCircle(x, y + unit.unitsOf(0.2), .20);
    }
}
