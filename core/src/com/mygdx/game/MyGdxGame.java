package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    Background bg;
    Spaceship spaceship;
    Enemy enemy;
    Texture gameOverTexture;
    Texture win;

    @Override
    public void create() {
        batch = new SpriteBatch();
        bg = new Background();
        spaceship = new Spaceship();
        enemy = new Enemy();
        gameOverTexture = new Texture("gameOver.jpg");
        win = new Texture("win.jpg");
    }

    @Override
    public void render() {
        update();
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        this.bg.render(this.batch);
        if (!enemy.isGameOver && !enemy.isWin) {
            this.spaceship.render(this.batch);
            this.enemy.render(this.batch);
        } else {
            if (enemy.isGameOver) {
                batch.draw(gameOverTexture, 10, 0);
            } else {
                if (enemy.isWin) {
                    batch.draw(win, 20, 0);
                }
            }
        }
        batch.end();
    }

    public void update() {
        this.bg.update();
        this.spaceship.update();
        this.enemy.update(spaceship);
        if (Gdx.input.isKeyPressed(Input.Keys.R)) {
            spaceship.recreate();
            enemy.recreate();
            enemy.life = 3;
            enemy.count = 0;
            enemy.isGameOver = false;
            enemy.isWin = false;
            enemy.speed = 6;
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}