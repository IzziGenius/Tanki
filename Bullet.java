package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Bullet extends  Unit {
   int h=15, x, y;

    public Bullet(Texture img, Tank tank) {
        super(img);
        this.x= tank.getX()+tank.h/2;
        this.y=tank.getY()+tank.h;
    }
    public Bullet(Texture img, Enemy enemy) {
        super(img);
        this.x= enemy.getX();
        this.y=enemy.getY();
    }
    public void explosion(Unit unit){

    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(img, x, y, h, h );
    }

    @Override
    public void move() {
        y+=3;
    }


    @Override
    public void shot() {

    }
}
