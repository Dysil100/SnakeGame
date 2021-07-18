import java.awt.event.KeyEvent;
import java.util.Random;

public class GameBoard {
    Boolean isAlive;
    Configuration config = new Configuration();
    Snake snake = new Snake(config.allXPosition, config.allYPosition, config.unit);
    Food  food =  new Food();
    int showTime = 100;

    public void init(){
        StdDraw.setCanvasSize(config.canvas.width, config.canvas.higth);
        StdDraw.setXscale(config.scale.xLelft, config.scale.xRigth);
        StdDraw.setYscale(config.scale.yDown, config.scale.yUp);
        isAlive = true;
        drawComponents();
        StdDraw.show();
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
            StdDraw.show(showTime);
        }

    }

    private void foodAtRandomPosition() {
        Random r = new Random();
        food.setX(r.nextInt(config.allXPosition - 1) + 1);
        food.setY(r.nextInt(config.allYPosition - 1) + 1);
    }

    private void drawComponents() {
        snake.draw(config.unit);
        food.draw(config.unit);
    }
}
