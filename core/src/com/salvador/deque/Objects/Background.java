package com.salvador.deque.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Background extends Actor {

    private int w;
    private int h;

    private Texture texture;

    public Background(int w, int h){
        this.w = w;
        this.h = h;
        texture = new Texture(Gdx.files.internal("background.png"));
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(texture,0,0,w,h);
    }
}
