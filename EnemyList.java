package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.LinkedList;
import java.util.Random;

public class EnemyList {
    Texture img;
    Random random;
    Enemy enemy;
    LinkedList<Enemy> list= new LinkedList<Enemy>();

    public EnemyList(Texture img) {
        this.img = img;
    }
    public void draw(SpriteBatch batch){
        for(Enemy e:list){
            e.draw(batch);
        }
    }
    public void move(SpriteBatch batch){
        for(Enemy e:list){
            e.move();
        }
        for (int i = 0; i <list.size() ; i++) {
            if(!(list.get(i).isVisible()))
                list.remove(i);
        }
    }
    public  void spawn(){
            list.add(Enemy.spawn(img));
    }
}
