package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Random;

public class TankGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	OrthographicCamera camera;
	Tank tank;
	Enemy enemy;
	Bullet bullet;
	Bullet bullet2;
	//Music gameSound;
	Lamp lamp1;
	Lamp lamp2;
	Random random;
	EnemyList enemyList=null;




	@Override
	public void create () {
		batch = new SpriteBatch();
		tank= new Tank(new Texture("tank.png"));
		img= new Texture("robot.png");
		enemy= Enemy.spawn(img);
		enemyList= new EnemyList(img);
		lamp1=Lamp.spawn(new Texture("left.png"),10, 500);
		lamp2=Lamp.spawn(new Texture("rigth.png"), 470, 500);
		bullet= new Bullet(new Texture("roket.png"), tank);
		bullet2= new Bullet(new Texture("roket.png"), enemy);
		//gameSound= Gdx.audio.newMusic(Gdx.files.internal("DogFire.mp3"));
		//gameSound.setLooping(true);
		// gameSound.play();
		camera= new OrthographicCamera();
		camera.setToOrtho(false, 480, 800);

	}

	@Override
	public void render () {
		enemyList.move(batch);
		enemy.move();
		tank.move();
		enemy.shot(batch);
		bullet.move();
		bullet2.move();
		lamp1.move();
		lamp2.move();
		//if(bullet.explosion(enemy))
		if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
			bullet= new Bullet(new Texture("roket.png"), tank);
		/*if(lamp1.getY()==300)
			bullet2= new Bullet(new Texture("roket.png"), enemy);*/
		if(lamp1.getY()==0)
			lamp1=Lamp.spawn(new Texture("left.png"),10, 500);
		if(lamp2.getY()==0)
			lamp2=Lamp.spawn(new Texture("rigth.png"),470, 500);
		if(lamp2.getY()==100||lamp1.getY()==187)		//здесь условия, при которых генерятся новые враги
			enemyList.spawn();
		Gdx.gl.glClearColor(0, 0.2f, 0.5f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		tank.draw(batch);
		enemy.draw(batch);
		bullet.draw(batch);
		bullet2.draw(batch);
		lamp1.draw(batch);
		lamp2.draw(batch);
		enemyList.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		tank.dispose();
		bullet.dispose();
		bullet2.dispose();
		lamp1.dispose();
		lamp2.dispose();
	}
}
