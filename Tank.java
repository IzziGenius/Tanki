package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tank extends Unit {
    Bullet bullet;
    static  int h=80;
    int x=200;
    public Tank(Texture img) {
        super(img);
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(img, x, y, h, h );
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    @Override
    public void move() {  //позволяет двагаться налево-направо
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) x -= 200 * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) x += 200 * Gdx.graphics.getDeltaTime();
        if(x < 90) x = 90;      //ограничения для передвижения танка
        if(x > 395) x = 395;

    }

    @Override
    public void shot(SpriteBatch batch) {

    }


}
