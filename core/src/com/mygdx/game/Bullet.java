package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Bullet {
    static Texture texture;
    Vector2 position;
    float speed;
    boolean alive;

    public Bullet(){
        if (texture == null){
            texture = new Texture("bullet.png");
        }

        position = new Vector2(0,0);
        speed = 800.0f;
        alive = false;
    }

    public void render(SpriteBatch batch){
        batch.draw(texture,position.x + 16,position.y + 16);

    }
    public void update(float dt){
        position.x += speed * dt;
        if (position.x > 1280){
            alive = false;
        }
    }

    public void setup (Vector2 position){
        this.position.set(position);
        alive = true;
    }

    public void destroy(){
        alive = false;
    }
}

