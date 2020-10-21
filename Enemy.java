package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;
public class Enemy extends Unit {
    public  static Random random= new Random();
    static int h=50;
    int y=0;
    public Enemy(Texture img) {
        super(img);

    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
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
        enemy.x= random.nextInt(450);
        enemy.y=480;
        return enemy;
    }

    @Override
    public void shot() {
        new Bullet(img, this){
            @Override
            public void move() {
                super.move();
                y-=2;

            }
        };

    }

}
