package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;



import java.util.Random;

public class Enemy extends Unit {
    public  static Random random= new Random();
    static int h=50;
    int y=480;
    public Enemy(Texture img) {
        super(img);

    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(img, x, y, h, h);
    }

    @Override
    public void move() {
        y-=1;

    }
    public static Enemy spawn(Texture img){
        Enemy enemy= new Enemy(img);
        enemy.x= random.nextInt(480);
        return enemy;
    }

    @Override
    public void shot() {

    }
}
