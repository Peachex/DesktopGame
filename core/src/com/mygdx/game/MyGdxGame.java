package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    Background bg;
    Spaceship spaceship;
    Enemy enemy;
    Logic logic;

    @Override
    public void create() {
        batch = new SpriteBatch();
        bg = new Background();
        spaceship = new Spaceship();
        enemy = new Enemy();
        logic = new Logic();
    }

    @Override
    public void render() {
        update();
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        this.bg.render(this.batch);
        this.spaceship.render(this.batch);
        this.enemy.render(this.batch);
        batch.end();
    }

    public void update() {
        this.bg.update();
        this.spaceship.update();
        this.enemy.update();
        this.logic.update(this.spaceship, this.enemy);
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
