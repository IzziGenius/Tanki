package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TankGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	OrthographicCamera camera;
	Tank tank;
	Enemy enemy;
	Bullet bullet;
	//Bullet bullet2;
	//Music gameSound;
	Lamp lamp1;
	Lamp lamp2;
	Lamp lamp3;
	Lamp lamp4;
	EnemyList enemyList=null;



	@Override
	public void create () {
		batch = new SpriteBatch();
		tank= new Tank(new Texture("tank.png"));
		img= new Texture("robot.png");
		enemy= Enemy.spawn(img);
		enemyList= new EnemyList(img);
		lamp1=Lamp.spawn(new Texture("dom1.png"),10, 500);
		lamp2=Lamp.spawn(new Texture("dom2.png"), 470, 540);
		lamp3=Lamp.spawn(new Texture("dom.png"), 10, 650);
		lamp4=Lamp.spawn(new Texture("dom4.png"), 470, 720);
		bullet= new Bullet(new Texture("roket.png"), tank);
		//bullet2= new Bullet(new Texture("roket.png"), enemy);
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
		//bullet2.move();
		lamp1.move();
		lamp2.move();
		lamp3.move();
		lamp4.move();
		if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
			bullet= new Bullet(new Texture("roket.png"), tank);

		/*if(lamp1.getY()==300)
			bullet2= new Bullet(new Texture("roket.png"), enemy);*/
		if(lamp1.getY()==-40)
			lamp1=Lamp.spawn(new Texture("dom1.png"),10, tank.getX()+500);
		if(lamp2.getY()==-40)
			lamp2=Lamp.spawn(new Texture("dom2.png"),470, tank.getX()+510);
		if(lamp3.getY()==-100)
			lamp3=Lamp.spawn(new Texture("dom.png"), 10, tank.getX()+520);
		if(lamp4.getY()==-100)
			lamp4=Lamp.spawn(new Texture("dom4.png"), 470, tank.getX()+650);
		if(lamp2.getY()==100||lamp1.getY()==187||lamp3.getY()==25||lamp4.getY()==235||lamp1.getY()==345||lamp2.getY()==421)	{	//здесь условия, при которых генерятся новые враги
			enemyList.spawn();
		}
		Gdx.gl.glClearColor(0, 0.2f, 0.5f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		tank.draw(batch);
		//enemy.draw(batch);
		bullet.draw(batch);
		//bullet2.draw(batch);
		lamp1.draw(batch);
		lamp2.draw(batch);
		lamp3.draw(batch);
		lamp4.draw(batch);
		enemyList.touch(bullet);
		enemyList.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		tank.dispose();
		bullet.dispose();
		//bullet2.dispose();
		lamp1.dispose();
		lamp2.dispose();
		lamp3.dispose();
		lamp4.dispose();
	}
}
