public class Canvas {
     int width;
     int higth;

    public Canvas(int canvasWidth, int canvasHigth) {
        this.width = canvasWidth;
        this.higth = canvasHigth;
    }

    public Canvas() {
        this(600, 600);
    }

    @Override
    public String toString() {
        return "Canvas{" +
                "width=" + width +
                ", higth=" + higth +
                '}';
    }
}
