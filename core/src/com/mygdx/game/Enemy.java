package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Enemy {
    Texture img;
    Vector2 pos;
    float speed;
    long count;
    boolean isAlive;
    Circle circle;
    Random random = new Random();

    public Enemy() {
        this.img = new Texture("enemy.png");
        this.pos = new Vector2(1280, random.nextInt(641) + 10);
        this.speed = 4;
        this.count = 0;
        this.isAlive = true;
        circle = new Circle(pos.x, pos.y, 156);
    }

    public void render(SpriteBatch batch) {
        batch.draw(img, pos.x, pos.y);
    }

    public void update() {
        if (this.pos.x < -150) {
            this.pos.x = 1280;
            this.pos.y = random.nextInt(641) + 10;
            circle.y = pos.y;
            circle.x = pos.x;
            isAlive = false;
            count++;
        }
        if (count == 3 && this.speed < 10) {
            this.speed += 2;
            this.count = 0;
        }
        circle.x -= speed;
        this.pos.x -= this.speed;
    }

    public Vector2 getPos() {
        return pos;
    }

    public void setPos(Vector2 pos) {
        this.pos = pos;
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }
}