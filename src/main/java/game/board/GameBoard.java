package game.board;

import game.elements.Food;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;


public class GameBoard extends JPanel implements ActionListener {

    static final int SCREEN_WITH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    //static final int GAME_UNITS = (SCREEN_HEIGHT * SCREEN_WITH) / UNIT_SIZE;
    final int DELAY = 75;
    private Food food;
    Snake snake;
    boolean running = false;
    Timer timer;
    Random random;

    public GameBoard() {
        this.setPreferredSize(new Dimension(SCREEN_WITH, SCREEN_HEIGHT));
        this.setBackground(Color.MAGENTA);
        this.setFocusable(true);
        this.addKeyListener(new MykeyAdapter());
        aChance();
    }

    private void aChance() {
        this.snake = new Snake(UNIT_SIZE);
        random = new Random();
        startGame();
    }

    public void startGame() {
        newFood();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }


    public void newFood() {
        int foodX = random.nextInt((SCREEN_WITH / UNIT_SIZE)) * UNIT_SIZE;
        int foodY = random.nextInt((SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
        food = new Food(foodX, foodY);
    }


    public void move() {
        snake.move();
    }

    public void checkFood() {
        if (snake.isAt(food)) {
            snake.eat();
            newFood();
        }
    }

    public void checkCollisions() {
        if (snake.eatingHisSelf()) running = false;
        if (snake.doesTouchBorders(SCREEN_HEIGHT, SCREEN_WITH)) running = false;
        if (!running) timer.stop();
    }

    public void gameOver(Graphics graphics) {
        drawElements(graphics);
        write(graphics, "Game Over", Color.RED, new Font("Ink Free", Font.BOLD, 75), SCREEN_WITH / 2);
    }

    private void write(Graphics graphics, String text, Color color, Font font, int y) {
        graphics.setColor(color);
        graphics.setFont(font);
        FontMetrics metrics0 = getFontMetrics(graphics.getFont());
        graphics.drawString(text, (SCREEN_WITH - metrics0.stringWidth(text)) / 2, y);
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        draw(graphics);
    }

    public void draw(Graphics graphics) {
        if (running) {
            //todo: handle it(schowing food and parts of the snake)
            // with Images instead of Colored Rectangle
            drawElements(graphics);
        } else gameOver(graphics);
    }

    private void drawElements(Graphics graphics) {
        food.draw(graphics, UNIT_SIZE);
        snake.getParts().forEach(p -> p.draw(graphics, UNIT_SIZE));
        write(graphics, "Score: " + snake.getEatens(), Color.BLUE, new Font("Ink Free", Font.BOLD, 40), graphics.getFont().getSize() + UNIT_SIZE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkFood();
            checkCollisions();
        }
        repaint();
    }

    public class MykeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT -> {
                    if (snake.getDirection() != 'R') snake.setDirection('L');
                }
                case KeyEvent.VK_RIGHT -> {
                    if (snake.getDirection() != 'L') snake.setDirection('R');
                }
                case KeyEvent.VK_UP -> {
                    if (snake.getDirection() != 'D') snake.setDirection('U');
                }
                case KeyEvent.VK_DOWN -> {
                    if (snake.getDirection() != 'U') snake.setDirection('D');
                }
                case KeyEvent.VK_ENTER -> {
                    if (!running) aChance();
                }
            }
        }
    }
}
