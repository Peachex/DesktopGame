package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Spaceship {
    Texture img;
    Vector2 pos;

    public Spaceship() {
        this.img = new Texture("spaceship1.png");
        this.pos = new Vector2(600, 0);
    }

    public void render(SpriteBatch batch) {
        batch.draw(img, pos.x, pos.y);
    }

    public void update() {
        outOfMap();
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            pos.y += 2;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            pos.y += - 2;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            pos.x += 2;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            pos.x += - 4;
        }
    }

    public void outOfMap() {
        if (pos.x > 1230) {
            pos.x = -170;
        }
        if (pos.x < -180) {
            pos.x = 1230;
        }
        if (pos.y > 650) {
            pos.y = -150;
        }
        if (pos.y < -150) {
            pos.y = 650;
        }
    }
}
