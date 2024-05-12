package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Asteroid {
    static Texture texture;
    Vector2 position;
    int hp;
    float speed;
    float rotation;
    float scale;

    final float MIN_SPEED = 200.0f;
    final float MAX_SPEED = 400.0f;


    public Asteroid(){
        if (texture == null){
            texture = new Texture("asteroid.png");
        }

        position = new Vector2(MathUtils.random(1300.0f,2500.0f),MathUtils.random(0.0f,720.0f));
        speed = MathUtils.random(MIN_SPEED,MAX_SPEED);
        rotation = MathUtils.random(0.0f,360.0f);
        scale = MathUtils.random(0.8f,1.6f);
        hp = MathUtils.random(2,4);
    }

    public void render(SpriteBatch batch){
        float cscale = 0.8f + hp * 0.5f;
        batch.draw(texture,position.x + 16,position.y + 16,32,32,64,64,cscale,cscale,rotation,0,0,64,64,false,false);

    }
    public void update(float dt){
        position.x -= speed * dt;
        rotation += speed * dt/2.0f;
        if (position.x < -100){
           recreate();
        }
    }

    public void recreate() {
        position.set(MathUtils.random(1300.0f, 2500.0f), MathUtils.random(0.0f, 720.0f));
        speed = MathUtils.random(MIN_SPEED, MAX_SPEED);
    }

    public void takeOneDamage(){
        hp--;
        if(hp <= 0){
            recreate();
        }
    }
}

