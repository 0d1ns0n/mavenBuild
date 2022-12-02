package boomrus.object;

import boomrus.BomGame;

public class Mine {
    public int posX;
    public int posY;

    public Mine(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public void randPos(){
        posX = (int)(Math.random() * BomGame.WIDTH -1);
        posY = (int)(Math.random() * BomGame.HEIGHT -1);
    }
}
