package com.mygdx.game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;
public class Enemy extends Unit {
    public  static Random random= new Random();
    static int h=50;
    int y=0, x=0;
    Bullet bullet;
    SpriteBatch batch;
    public Enemy(Texture img, int x) {
        super(img);
        this.x=x;
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
        Enemy enemy= new Enemy(img, random.nextInt(460));
        enemy.y=500;
        return enemy;
    }

    public void shot(SpriteBatch batch) {
      /*  this.batch=batch;
        if(Gdx.input.isKeyJustPressed(Input.Keys.S)){
            bullet= new Bullet(new Texture("roket.png"), this);
      bullet.draw(batch);

        }*/

    }

    public boolean isVisible(){
        return x>0;
    }

}
