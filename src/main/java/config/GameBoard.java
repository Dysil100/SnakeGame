package config;

import game.Food;
import game.Snake;
import libraries.StdDraw;

import java.awt.event.KeyEvent;
import java.util.Random;

public class GameBoard {
    Boolean isAlive;
    Configuration config = new Configuration();
    Snake snake = new Snake(config.getAllXPosition(), config.getAllYPosition(), config.getUnit());
    Food food =  new Food();
    int showTime = 50;
    private String currentDirection;

    public void init(){
        StdDraw.setCanvasSize(config.getCanvas().width, config.getCanvas().higth);
        StdDraw.setXscale(config.getScale().xLelft, config.getScale().xRigth);
        StdDraw.setYscale(config.getScale().yDown, config.getScale().yUp);
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
                StdDraw.text(config.getUnit().mesureOf(config.getAllXPosition() >> 1), config.getUnit().mesureOf(config.getAllYPosition() >> 1), "Game Over");
                StdDraw.setPenColor(StdDraw.GREEN);
                StdDraw.text(config.getUnit().mesureOf(config.getAllXPosition() >> 1), config.getUnit().mesureOf((config.getAllYPosition() >> 1) - 1), snake.doesDie());
                isAlive = false;
            }
            StdDraw.show(showTime);
        }

    }

    private void newGame() throws InterruptedException {
    }

    private boolean snakeDoesDie() {
        return snake.head.getX() > config.getScale().xRigth - config.getUnit().mesureOf1Unit || snake.head.getY() > config.getScale().yUp - config.getUnit().mesureOf1Unit||
         snake.head.getX() < config.getScale().xLelft + config.getUnit().mesureOf1Unit || snake.head.getY() < config.getScale().yDown + config.getUnit().mesureOf1Unit;
    }

    private void foodAtRandomPosition() {
        Random r = new Random();
        food.setX(config.getUnit().mesureOf(r.nextInt((config.getAllXPosition() - 1) ) + 1));
        food.setY(config.getUnit().mesureOf(r.nextInt((config.getAllYPosition() - 1) ) + 1));
    }

    private void drawComponents() {
        snake.draw(config.getUnit());
        food.draw(config.getUnit());
    }
}
