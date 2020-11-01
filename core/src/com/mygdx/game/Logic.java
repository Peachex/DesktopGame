package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Logic {
    Random random = new Random();

    public Logic() {
    }

    public void update(Spaceship spaceship, Enemy enemy) {
        if (enemy.circle.contains(spaceship.pos)) {
            enemy.setPos(new Vector2(1280, random.nextInt(641) + 10));
            enemy.getCircle().x = enemy.getPos().x;
            enemy.getCircle().y = enemy.getPos().y;
        }
    }
}
