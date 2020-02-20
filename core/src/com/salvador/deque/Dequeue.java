package com.salvador.deque;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import static com.salvador.deque.Values.SCREEN_HIGHT;

public class Dequeue extends ApplicationAdapter {

	private Stage stage;
	private ExtendViewport viewport;

	private OrthographicCamera cam;
	private StageDeque stageDeque;

	@Override
	public void create() {

		//Setup UI
		cam = new OrthographicCamera(Values.SCREEN_WIDTH, SCREEN_HIGHT);
		viewport = new ExtendViewport(Values.SCREEN_WIDTH, SCREEN_HIGHT, cam);

		cam.position.set(cam.viewportWidth / 2f, cam.viewportHeight / 2f, 0);
		cam.update();

		stage = new Stage(viewport);
		//stage.setDebugAll(true);
		Gdx.input.setInputProcessor(stage);

		stageDeque = new StageDeque(this,stage);

	}


	@Override
	public void resize(int width, int height) {
		super.resize(width, height);

		stage.getViewport().update(width, height, true);
	}


	@Override
	public void render() {
		stage.act();
		stage.draw();
	}

}
