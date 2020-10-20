package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tank extends Unit {
    static  int h=80;
    public Tank(Texture img) {
        super(img);
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(img, x, y, h, h );
    }

    @Override
    public void move() {

    }

    @Override
    public void shot() {

    }
}
