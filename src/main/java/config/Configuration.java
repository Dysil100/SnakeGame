package config;

public class Configuration {
    private Canvas canvas;
    private Scale scale;
    private Unit unit;
    private int allXPosition;
    private int allYPosition;


    public Configuration() {
        this(new Canvas(), new Scale(), new Unit());
        setAllXPosition((int) (getScale().xSize / getUnit().mesureOf1Unit));
        setAllYPosition((int) (getScale().ySize / getUnit().mesureOf1Unit));
    }

    public Configuration(Canvas canvas, Scale scale, Unit unit) {
        this.setCanvas(canvas);
        this.setScale(scale);
        this.setUnit(unit);
        setAllXPosition((int) (scale.xSize / unit.mesureOf1Unit));
        setAllYPosition((int) (scale.ySize / unit.mesureOf1Unit));
    }

    public int getAllXPosition() {
        return allXPosition;
    }

    public void setAllXPosition(int allXPosition) {
        this.allXPosition = allXPosition;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public Scale getScale() {
        return scale;
    }

    public void setScale(Scale scale) {
        this.scale = scale;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public int getAllYPosition() {
        return allYPosition;
    }

    public void setAllYPosition(int allYPosition) {
        this.allYPosition = allYPosition;
    }
}
