package com.mygdx.game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;
import java.util.Random;
public class Enemy extends Unit {
    public  static Random random= new Random();
    static int h=50;
    int y=500;

    public Enemy(Texture img, int x) {
        super(img);
        this.x=x;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(img, x, y, h, h);
    }

    @Override
    public void move() {
        y-=1;
    }

    public static Enemy spawn(Texture img){
        return new Enemy(img, (random.nextInt(300)+80)); //координата для спауна роботов
    }
    public Rectangle getRectangle(){						//метод, необходимый для получения координат. применялся в методе eat для сравнения координат яблока и головы
        return new Rectangle(x, y, h, h);
    }

    @Override
    public void touch(Unit unit) {

    }

    public void shot(SpriteBatch batch) {       //метод выстрела, при выстреле игра вылетает
      /* this.batch=batch;
       if(this.getY()==250)
        bullet= new Bullet(new Texture("roket.png"), this);
      bullet.draw(batch);*/

        }
        public  void  intersection(Bullet bullet){
                Rectangle robot= this.getRectangle();
                Rectangle raketa= bullet.getRectangle();
                if(robot.overlaps(raketa))
                    this.y=-10;
        }

    public boolean isVisible(){
        return x>0;
    } // метод, определяющий видимость объекта

}
