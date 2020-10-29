package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class Unit {
    protected Texture img;
    protected int x, y, h;

    public Unit(Texture img) {
        this.img = img;
    }

    public abstract void draw(SpriteBatch batch);

    public abstract void move();

    public void dispose() {
        img.dispose();
    }

    public abstract void shot(SpriteBatch batch);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rectangle getRectangle() {                        //метод, необходимый для получения координат. применялся в методе eat для сравнения координат яблока и головы
        return new Rectangle(x, y, h, h);
    }

    public abstract void touch( Unit unit);
}