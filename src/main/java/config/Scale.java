package config;

public class Scale {
     double xLelft ;
     double yDown ;
     double xRigth ;
     double yUp ;
     double xSize;
     double ySize;

    public Scale() {
        this(0, 0, 40, 40);
        xSize = 40;
        ySize = 40;
    }

    public Scale(double xLelft, double yDown, double xRigth, double yUp) {
        this.xLelft = xLelft;
        this.yDown = yDown;
        this.xRigth = xRigth;
        this.yUp = yUp;
        xSize = xRigth - xLelft;
        ySize = yUp - yDown;
    }

    public static void main(String[] args) {
        System.out.println(new Scale());
    }
}
