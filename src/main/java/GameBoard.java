import java.awt.event.KeyEvent;
import java.util.Random;

public class GameBoard {
    private static Boolean isAlive;
    private final Snake snake = new Snake();
    private final Part  food =  new Part();

    public void init(){
        StdDraw.setCanvasSize(700, 700);
        StdDraw.setXscale(0, 40);
        StdDraw.setYscale(0, 40);
        isAlive = true;
        drawComponents();
    }

    private void foodAtRandomPosition() {
        Random r = new Random();
        food.setX(r.nextInt(39) + 1);
        food.setY(r.nextInt(39) + 1);
        food.draw();
    }

    public void run() throws InterruptedException {

        while (isAlive){
            if (snake.doesMett(food)){
                snake.eat();
                foodAtRandomPosition();
            }

            if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)){
                snake.goDown();
            }

            if (StdDraw.isKeyPressed(KeyEvent.VK_UP)){
                snake.goUp();
            }

            if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)){
                snake.goLeft();
            }

            if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)){
                snake.goRight();
            }

            StdDraw.clear();
            drawComponents();
            StdDraw.show(10);
            sleep();
        }

    }

    private void drawComponents() {
        snake.draw();
        food.draw();
    }

    private static void sleep() throws InterruptedException {
        Thread.sleep(50);
    }

}
