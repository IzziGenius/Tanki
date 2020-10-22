package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Unit {
    protected Texture img;
    protected  int x, y, h;

    public Unit(Texture img){
        this.img= img;
    }
    public  abstract  void draw(SpriteBatch batch);
    public  abstract  void move();
    public  void dispose(){
        img.dispose();
    }
    public abstract void shot(SpriteBatch batch);



}
