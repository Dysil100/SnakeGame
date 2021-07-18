
public abstract class Part implements Element {
    double x;
    double y;
    String direction;

    public Part(double x, double y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Part() {
        this.x = 20;
        this.y = 20;
        this.direction = "up";
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String getDirection() {
        return direction;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public static Part copyOf(Part part){
        return new BodyPart(part.getX(), part.getY(), part.getDirection());
    }

    public void goTo(Part part) {
        setX(part.getX());
        setY(part.getY());
        setDirection(part.getDirection());
    }

    public  void draw(Unit unit){
            double[] xS;
            double[] yS;
        if ("right".equals(direction)) {
            xS = new double[]{x + unit.unitsOf(0.75), x - unit.unitsOf(.5), x - unit.unitsOf(.5)};
            yS = new double[]{y, y - unit.unitsOf(.5), y + unit.unitsOf(.5)};
            //StdDraw.filledSquare(x, y, .60);
            StdDraw.filledPolygon(xS, yS);
        }if ("left".equals(direction)) {
            xS = new double[]{x - unit.unitsOf(0.75), x + unit.unitsOf(.5), x + unit.unitsOf(.5)};
            yS = new double[]{y, y - unit.unitsOf(.5), y + unit.unitsOf(.5)};
            //StdDraw.filledSquare(x, y, .60);
            StdDraw.filledPolygon(xS, yS);
        }if ("up".equals(direction)) {
            xS = new double[]{x, x - unit.unitsOf(.5), x + unit.unitsOf(.5)};
            yS = new double[]{y  + unit.unitsOf(0.75), y - unit.unitsOf(.5), y - unit.unitsOf(.5)};
            //StdDraw.filledSquare(x, y, .60);
            StdDraw.filledPolygon(xS, yS);
        }if ("down".equals(direction)) {
            xS = new double[]{x, x - unit.unitsOf(.5), x + unit.unitsOf(.5)};
            yS = new double[]{y  - unit.unitsOf(0.75), y + unit.unitsOf(.5), y + unit.unitsOf(.5)};
            //StdDraw.filledSquare(x, y, .60);
            StdDraw.filledPolygon(xS, yS);
        }
    }
}
