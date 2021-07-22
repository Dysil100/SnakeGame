package config;

import game.Food;
import game.Snake;
import libraries.StdDraw;

import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

public class GameBoard {
    Boolean isAlive;
    Configuration config = new Configuration();
    Snake snake = new Snake(config.allXPosition, config.allYPosition, config.unit);
    Food food =  new Food();
    int showTime = 200;
    private String currentDirection;

    public void init(){
        StdDraw.setCanvasSize(config.canvas.width, config.canvas.higth);
        StdDraw.setXscale(config.scale.xLelft, config.scale.xRigth);
        StdDraw.setYscale(config.scale.yDown, config.scale.yUp);
        isAlive = true;
        currentDirection = "up";
        drawComponents();
        StdDraw.show();
    }


    public void run() throws InterruptedException {

        while (isAlive){
            if (snake.doesMett(food)){
                snake.eat();
                foodAtRandomPosition();
            }

            if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) currentDirection = "down";

            if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) currentDirection = "up";

            if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) currentDirection = "left";

            if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) currentDirection = "right";

            snake.walk(currentDirection);
            StdDraw.clear();
            drawComponents();

            if (snakeDoesDie()){
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.text(config.unit.mesureOf(config.allXPosition / 2), config.unit.mesureOf(config.allYPosition / 2), "Game Over");
                StdDraw.setPenColor(StdDraw.GREEN);
                StdDraw.text(config.unit.mesureOf((config.allXPosition / 2)), config.unit.mesureOf((config.allYPosition / 2) - 1), snake.doesDie());
                isAlive = false;
            }
            StdDraw.show(showTime);
        }

    }

    private boolean snakeDoesDie() {
        return snake.head.getX() > config.scale.xRigth - config.unit.mesureOf1Unit || snake.head.getY() > config.scale.yUp - config.unit.mesureOf1Unit||
         snake.head.getX() < config.scale.xLelft + config.unit.mesureOf1Unit || snake.head.getY() < config.scale.yDown + config.unit.mesureOf1Unit /* || (snake.parts.stream().map(p -> List.of(p.x, p.y)).distinct().count() != (snake.parts.size()))*/;
    }

    private void foodAtRandomPosition() {
        Random r = new Random();
        food.setX(config.unit.mesureOf(r.nextInt((config.allXPosition - 1) ) + 1));
        food.setY(config.unit.mesureOf(r.nextInt((config.allYPosition - 1) ) + 1));
    }

    private void drawComponents() {
        snake.draw(config.unit);
        food.draw(config.unit);
    }
}
