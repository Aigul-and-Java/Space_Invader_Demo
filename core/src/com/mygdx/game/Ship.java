package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Ship {
    MyGdxGame game;
    Texture texture;
    Vector2 position;
    float speed;

    float fireRate;
    float fireTime;

    public Ship(MyGdxGame game){
        this.game = game;
        texture = new Texture("Space_Ships.png");
        position = new Vector2(100,328);
        speed = 400;
        fireRate = 0.2f;
    }

    public void render(SpriteBatch batch){
        batch.draw(texture,position.x -32,position.y -32);

    }
    public void update(float dt){
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            position.x +=speed * dt;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            position.x -=speed * dt;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            position.y +=speed * dt;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            position.y -=speed * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            fireTime += dt;
          if (fireTime > fireRate){
              fireTime -= fireRate;
              fire();
          }
        }
    }
    public void fire(){
        for (int i = 0; i < game.bullets.length; i++){
            if (!game.bullets[i].alive){
                game.bullets[i].setup(position);
                return;
            }
        }
    }
}


