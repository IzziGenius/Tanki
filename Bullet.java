package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bullet extends  Unit {
   int h=15, x, y;
Sound shot= Gdx.audio.newSound(Gdx.files.internal("shot.mp3")); //звук выстрела
    public Bullet(Texture img, Tank tank) {
        super(img);
        shot.play();
        this.x= tank.getX()+tank.h/2;
        this.y=tank.getY()+tank.h;
    }
    public Bullet(Texture img, Enemy enemy) {
        super(img);
        this.x= enemy.getX();
        this.y=enemy.getY();
    }

    public int getY() {
        return y;
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


    public boolean explosion(Enemy enemy) { //метод, позволяющий уничтожать роботов
        int r1= enemy.getY();
        int r2=this.getY();
        if(r1==r1)return true;
        else return  false;
    }
}
