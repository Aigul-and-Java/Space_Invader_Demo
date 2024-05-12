package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {

	SpriteBatch batch;
	Background background;
	Ship hero;
	Bullet[] bullets;
	Asteroid[] asteroids;

	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Background();
		hero = new Ship(this);
		bullets = new Bullet[100];
		for (int i = 0; i < bullets.length; i++) {
			bullets[i] = new Bullet();
		}
		asteroids = new Asteroid[15];
		for (int i = 0; i < asteroids.length;i ++){
			asteroids[i] = new Asteroid();
		}
	}

	@Override
	public void render () {
		float dt = Gdx.graphics.getDeltaTime();
		update(dt);
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		background.render(batch);
		hero.render(batch);
		for (int i = 0; i < asteroids.length;i ++){
			asteroids[i].render(batch);
		}
		for (int i = 0; i < bullets.length; i++) {
			if (bullets[i].alive){
				bullets[i].render(batch);
			}
		}
		batch.end();
	}

	public void update(float dt){
		background.update(dt);
		hero.update(dt);
		for (int i = 0; i < asteroids.length;i ++){
			asteroids[i].update(dt);
		}
		for (int i = 0; i < bullets.length; i++) {
			if (bullets[i].alive){
				bullets[i].update(dt);
			}
		}
		checkCollisions();
	}

	public void checkCollisions(){
		for (int i = 0; i < bullets.length; i++) {
			if (bullets[i].alive){
				for (int j = 0; j < asteroids.length; j++) {
					if (bullets[i].position.dst(asteroids[j].position) < 24){
						bullets[i].destroy();
						asteroids[j].takeOneDamage();
						break;

					}
				}
			}
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();

	}
}
