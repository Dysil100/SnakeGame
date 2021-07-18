public class Unit {
    double mesureOf1Unit;

    public Unit() {
        this(1.0);
    }

    public Unit(double mesureUnits) {
        this.mesureOf1Unit = mesureUnits;
    }

    public double unitsOf(double length){
        return mesureOf1Unit * length;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "mesureOf1Unit=" + mesureOf1Unit +
                '}';
    }
}
