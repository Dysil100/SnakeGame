
public class Configuration {
    Canvas canvas;
    Scale scale;
    Unit unit;
    int allXPosition;
    int allYPosition;


    public Configuration() {
        this(new Canvas(), new Scale(), new Unit());
        allXPosition = (int) ((scale.xRigth - scale.xLelft) / unit.mesureOf1Unit);
        allYPosition = (int) ((scale.yUp - scale.yDown) / unit.mesureOf1Unit);
    }

    public Configuration(Canvas canvas, Scale scale, Unit unit) {
        this.canvas = canvas;
        this.scale = scale;
        this.unit = unit;
        allXPosition = (int) ((scale.xRigth - scale.xLelft) / unit.mesureOf1Unit);
        allYPosition = (int) ((scale.yUp - scale.yDown) / unit.mesureOf1Unit);
    }
}
