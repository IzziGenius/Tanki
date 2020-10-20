package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.Timer;

public class TankGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	OrthographicCamera camera;
	Tank tank;
	Enemy enemy;
	Bullet bullet;
	Bullet bullet2;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		tank= new Tank(new Texture("tank.png"));
		img= new Texture("robot.png");
		enemy= Enemy.spawn(img);
		bullet= new Bullet(new Texture("roket.png"), tank);
		bullet2= new Bullet(new Texture("roket.png"), enemy);
		camera= new OrthographicCamera();
		camera.setToOrtho(false, 480, 800);
	}

	@Override
	public void render () {
		enemy.move();
		tank.move();
		Gdx.gl.glClearColor(0, 0.2f, 0.5f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		tank.draw(batch);
		enemy.draw(batch);
		bullet.draw(batch);
		bullet2.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		tank.dispose();
	}
}
