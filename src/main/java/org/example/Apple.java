package org.example;

public class Apple {
    public int posX;
    public int posY;

    public Apple(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public void randomPos() {

        posX = Math.abs((int) (Math.random() * ProjectSnake.WIDTH - 1));
        posY = Math.abs((int) (Math.random() * ProjectSnake.HEIGHT - 1));
    }
}
