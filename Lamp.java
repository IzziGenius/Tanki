package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Random;

public class Lamp extends  Unit {
    int h=40, x, y;
    Random random; //привязать к координатам появления


    public Lamp(Texture img, int x, int y) {
        super(img);
        this.x=x;
        this.y=y;

    }
    public static Lamp spawn(Texture img, int x, int y){
        Lamp lamp= new Lamp(img, x, y);
        return lamp;
    }

    public int getY() {
        return y;
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(img, this.x, this.y, h, h);
    }

    @Override
    public void move() {
        y-=1;
    }

    @Override
    public void shot(SpriteBatch batch) {

    }


}
