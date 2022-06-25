package com.prog.grafica;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class Enemigo extends Actor {
    Texture imagen;
    TextureRegion[] animacionF;
    private Animation animacion;
    private TextureRegion frameActual;
    float tiempo;

    public Enemigo (String imagePath,float x, float y) {
        imagen = new Texture(Gdx.files.internal("chitiniac-move.png"));
        TextureRegion [][] tmp = TextureRegion.split(imagen, imagen.getWidth()/8,imagen.getHeight());
        int in = 0;
        animacionF = new TextureRegion[8];
        for (int i =0;i<8;i++){
            animacionF[i] = tmp[0][i];
        }
        animacion = new Animation(1/10f, animacionF);
        tiempo = 0f;
        setSize(200,120);
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        tiempo += Gdx.graphics.getDeltaTime();
        frameActual =(TextureRegion) animacion.getKeyFrame(tiempo,true);
        batch.draw(frameActual,getX(),getY());
    }



    @Override
    public void act(float delta) {
        super.act(delta);
        if (getX() < getStage().getWidth()/2) {
            setX(getX()+1.5f);
        }else {
            remove();
        }

    }
}
