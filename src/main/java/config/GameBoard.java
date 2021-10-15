package config;

import game.Food;
import game.Snake;
import libraries.StdDraw;

import java.awt.event.KeyEvent;
import java.util.Random;

public class GameBoard {
     int level ;
     int score;
    Boolean isAlive;
    Configuration config = new Configuration();
    Snake snake;
    Food food =  new Food();
    int showTime;
    private String currentDirection;

    public void init(){
        StdDraw.setCanvasSize(config.getCanvas().width, config.getCanvas().higth);
        StdDraw.setXscale(config.getScale().xLelft, config.getScale().xRigth);
        StdDraw.setYscale(config.getScale().yDown, config.getScale().yUp);
        isAlive = true;
        level = 0;
        score = 0;
         showTime = 110;
        snake = new Snake(config.getAllXPosition(), config.getAllYPosition(), config.getUnit());
        currentDirection = "up";
        StdDraw.show();
    }


    public void run() throws InterruptedException {
        while (isAlive){
            if (snake.doesMett(food)){
                snake.eat();
                score++;
                foodAtRandomPosition();
            }
            checkDircetion();
            snake.walk(currentDirection);
            StdDraw.clear();
            drawBoard();
            if (snakeDoesDie()){
                write();
                isAlive = false;
            }
            StdDraw.show(showTime);
            updatelevel();
            checkStage();
        }

    }
     //Unpassende Implementation
    private void updatelevel() {
        if ((score / 10 > level)) {
            level = level + 1;
            showTime-= 10;
        }
    }

    private void write() {
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.text(config.getUnit().mesureOf(config.getAllXPosition() >> 1), config.getUnit().mesureOf(config.getAllYPosition() >> 1), "Game Over");
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.text(config.getUnit().mesureOf(config.getAllXPosition() >> 1), config.getUnit().mesureOf((config.getAllYPosition() >> 1) - 1), snake.doesDie());
        StdDraw.setPenColor(StdDraw.PINK);
        StdDraw.text(config.getUnit().mesureOf(config.getAllXPosition() >> 1), config.getUnit().mesureOf((config.getAllYPosition() >> 1) - 2), "Level: " + level);
    }

    private void checkStage() throws InterruptedException {
        if (!isAlive) {
            while (true) {
                if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER)) {
                    isAlive = true;
                    init();
                    run();
                    break;
                }
            }
        }
    }

    private void checkDircetion() {
        if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN))
            if (!"up".equals(currentDirection)) currentDirection = "down";

        if (StdDraw.isKeyPressed(KeyEvent.VK_UP))
            if (!"down".equals(currentDirection)) currentDirection = "up";

        if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT))
            if (!"right".equals(currentDirection)) currentDirection = "left";

        if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT))
            if (!"left".equals(currentDirection)) currentDirection = "right";
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

    private void drawBoard() {
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.text(config.getUnit().mesureOf(config.getAllXPosition() >> 2), config.getUnit().mesureOf((config.getAllYPosition() - .5)), "Level: " + level);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.text(config.getUnit().mesureOf((config.getAllXPosition() >> 1) + 5 ), config.getUnit().mesureOf((config.getAllYPosition() - .5)), "your Score ist : " + score);
        snake.draw(config.getUnit());
        food.draw(config.getUnit());
    }
}
