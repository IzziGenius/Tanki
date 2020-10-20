package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bullet extends  Unit {
   static  int h=15;
   int x, y;
    public Bullet(Texture img, Unit unit) {
        super(img);
        this.x= unit.x;
        this.y= unit.y;
    }

    @Override
    public void draw(SpriteBatch batch) {

    }

    @Override
    public void move() {

    }


    public void draw(SpriteBatch batch, int x, int y) {
        batch.draw(img, x, y, h, h );
    }


    public void move(Unit unit) {
        if (unit == new Tank(img)) y-=1;
        if (unit == new Enemy(img)) y+=1;
    }

    @Override
    public void shot() {

    }
}
