package com.salvador.deque.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class BoxLine extends Actor {

    Texture texture;

    public BoxLine(float x, float y, float width, float height) {
        setPosition(x, y);
        setSize(width, height);
        texture = new Texture(Gdx.files.internal("deque.png"));
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(texture,getX(),getY(),getWidth(),getHeight());
    }
}
