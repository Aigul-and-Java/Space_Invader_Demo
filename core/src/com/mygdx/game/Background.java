package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Background {
    class Star{
        Vector2 position;
        float speed;

        static final float MIN_SPEED = 20.0f;
        static final float MAX_SPEED = 80.0f;

        public Star(){
            position = new Vector2(1600 * (float)Math.random(),720 * (float)Math.random());
            speed = MathUtils.random(MIN_SPEED, MAX_SPEED);
        }

        public void update(float dt) {
            position.x -= speed * dt;
            if (position.x < -50){
                position.x = 1280;
                position.y = 720 * (float)Math.random();
                speed = MathUtils.random(MIN_SPEED, MAX_SPEED);
            }
        }
    }


    Texture texture;
    Texture textureStar;
    Star[] stars;

    public Background(){
        texture = new Texture("SpaceWallpaper.png");
        textureStar = new Texture("Star.png");
        stars = new Star[400];
        for (int  i = 0; i < stars.length; i++){
            stars[i] = new Star();
        }
    }

    public void render(SpriteBatch batch){
        batch.draw(texture,0,0);
        for (int i = 0; i < stars.length; i++){
            float scale = 0.7f + stars[i].speed/Star.MAX_SPEED * 0.8f;
            batch.draw(textureStar, stars[i].position.x-8,stars[i].position.y-8,8,8,16,16,0.7f,0.7f,0,0,0,16,16,false,false);
            if (Math.random() < 0.05f){
                scale *=1.5f;
                batch.draw(textureStar, stars[i].position.x-8,stars[i].position.y-8,8,8,16,16,0.7f,0.7f,0,0,0,16,16,false,false);
            }
        }
    }

    public void update(float dt){
        for (int i = 0; i < stars.length; i++) {
            stars[i].update(dt);
        }
    }
}
