package game;

import config.Unit;
import libraries.StdDraw;

public abstract class Part implements Element {
    public double x;
    public double y;
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

    public void draw(Unit unit){
            double[] xS; double[] yS;
        if ("right".equals(direction)) {
            xS = new double[]{x + unit.mesureOf(0.75), x - unit.mesureOf(.5), x - unit.mesureOf(.5)};
            yS = new double[]{y, y - unit.mesureOf(.5), y + unit.mesureOf(.5)};
            StdDraw.filledPolygon(xS, yS);
        }

        if ("left".equals(direction)) {
            xS = new double[]{x - unit.mesureOf(0.75), x + unit.mesureOf(.5), x + unit.mesureOf(.5)};
            yS = new double[]{y, y - unit.mesureOf(.5), y + unit.mesureOf(.5)};
            StdDraw.filledPolygon(xS, yS);
        }

        if ("up".equals(direction)) {
            xS = new double[]{x, x - unit.mesureOf(.5), x + unit.mesureOf(.5)};
            yS = new double[]{y  + unit.mesureOf(0.75), y - unit.mesureOf(.5), y - unit.mesureOf(.5)};
            StdDraw.filledPolygon(xS, yS);
        }

        if ("down".equals(direction)) {
            xS = new double[]{x, x - unit.mesureOf(.5), x + unit.mesureOf(.5)};
            yS = new double[]{y  - unit.mesureOf(0.75), y + unit.mesureOf(.5), y + unit.mesureOf(.5)};
            StdDraw.filledPolygon(xS, yS);
        }
    }
}
