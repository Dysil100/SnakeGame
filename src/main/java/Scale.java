public class Scale {
     int xLelft ;
     int yDown ;
     int xRigth ;
     int yUp ;

    public Scale() {
        this(0, 0, 40, 40);
    }

    public Scale(int xLelft, int yDown, int xRigth, int yUp) {
        this.xLelft = xLelft;
        this.yDown = yDown;
        this.xRigth = xRigth;
        this.yUp = yUp;
    }

    @Override
    public String toString() {
        return "Scale{" +
                "xLelft=" + xLelft +
                ", yDown=" + yDown +
                ", xRigth=" + xRigth +
                ", yUp=" + yUp +
                '}';
    }


}
