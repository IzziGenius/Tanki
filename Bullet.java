package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;

public class Bullet extends  Unit {
   int h=15, x, y, dx;
Sound shot= Gdx.audio.newSound(Gdx.files.internal("shot.mp3")); //звук выстрела
    public Bullet(Texture img, Tank tank) {
        super(img);
        shot.play();
        this.x= tank.getX()+(tank.h/2-9);
        this.y=tank.getY()+tank.h;
        dx=3;
    }
    public Bullet(Texture img, Enemy enemy) {
        super(img);
        shot.play();
        this.x= enemy.getX();
        this.y=enemy.getY();
        dx=-3;
    }

    public int getY() {
        return y;
    }
    public int getX() {
        return x;
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(img, x, y, h, h );
    }

    @Override
    public void move() {
        y+=dx;
    }

    @Override
    public void shot(SpriteBatch batch) {

    }

    public Rectangle getRectangle(){						//метод, необходимый для получения координат. применялся в методе eat для сравнения координат яблока и головы
        return new Rectangle(x, y, h, h);
    }

    @Override
    public void touch( Unit unit) {

    }

}
