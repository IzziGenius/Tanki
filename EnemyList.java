package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import java.util.ArrayList;

public class EnemyList {
  Texture img;
    ArrayList<Enemy> list= new ArrayList<Enemy>();

    public EnemyList(Texture img) {
        this.img = img;
    }
    public void draw(SpriteBatch batch){
        for(Enemy e:list){
            e.draw(batch);
        }
    }

    public void touch( Unit unit) {
        boolean x;
        for (Unit a : list) {
            Rectangle robot = a.getRectangle();
            Rectangle raketa = unit.getRectangle();
            if(robot.overlaps(raketa))
                a.x=-10;
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




