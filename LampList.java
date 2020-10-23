package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.LinkedList;
import java.util.Random;

public class LampList {
    Texture img;
    Random random;
    Lamp lamp;
    LinkedList<Lamp> list= new LinkedList<Lamp>();

    public LampList(Lamp... lamp) {
        LinkedList<Lamp> list= new LinkedList<Lamp>();
        for( Lamp i:lamp)
            list.add(i);
    }
    public void draw(SpriteBatch batch){
        for(Lamp e:list){
            e.draw(batch);
        }
    }
    public void move(SpriteBatch batch){
        for(Lamp e:list){
            e.move();
        }
        for (int i = 0; i <list.size() ; i++) {
            if(!(list.get(i).isVisible()))
                list.remove(i);
        }
    }
    public  void spawn(int x, int y){
        list.add(Lamp.spawn(img, x, y));
    }
}


