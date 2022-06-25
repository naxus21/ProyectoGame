package com.prog.grafica;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Random;

public class Principal extends ApplicationAdapter {
	Random random = new Random();
	//MoveByAction action;
	int a;
	SpriteBatch batch;
	Texture img;
	//private OrthographicCamera camera;
	private Stage escenario;
	private Helicoptero h1;

	@Override
	public void create () {
		escenario = new Stage(new ScreenViewport());
		//action.setAmount(escenario.getHeight(),0f);
		//action.setDuration(10f);
		//h1 = new Helicoptero("heli2.jpg", action, Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
		//escenario.addActor(h1);

		batch = new SpriteBatch();
		//camera = new OrthographicCamera();
		//camera.setToOrtho(false,800,480); // Y apunta hacia arriba,
		//camera.update();


	}

	@Override
	public void render () {
		ScreenUtils.clear(255, 255 ,255, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//camera.update();
		//batch.setProjectionMatrix(camera.combined);
		escenario.act(Gdx.graphics.getDeltaTime());
		a = random.nextInt(200+1)+0;
		if(a==200){
			h1 = new Helicoptero("helicopter2.png",Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
			h1.moveBy(0,random.nextInt(Gdx.graphics.getHeight()/2)+1);
			escenario.addActor(h1);
		}
		escenario.act();
		escenario.draw();


	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}



}