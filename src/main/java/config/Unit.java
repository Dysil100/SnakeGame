package config;

public class Unit {
    public double mesureOf1Unit;

    public Unit() {
        this(2.0);
    }

    public Unit(double mesureUnits) {
        this.mesureOf1Unit = mesureUnits;
    }

    public double mesureOf(double length){
        return mesureOf1Unit * length;
    }
}