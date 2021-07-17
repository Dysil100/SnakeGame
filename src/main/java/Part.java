
public class Part {
    private int x;
    private int y;

    public Part(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Part() {
        this.x = 20;
        this.y = 20;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static Part copyOf(Part part){
        return new Part(part.getX(), part.getY());
    }

    public void goTo(Part part) {
        setX(part.getX());
        setY(part.getY());
    }

    public void draw(){
        StdDraw.filledCircle(x, y, .60);
    }

}
