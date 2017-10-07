package com.dvimer.libgdx.info.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by dvime_000 on 01.10.2017.
 */
public class MyImage {

    private Stage stage;
    private Texture texture;

    public MyImage(Stage stage) {
        this.stage = stage;
        texture = new Texture("badlogic.jpg");
    }

    public void draw(){
        Image image1 = new Image(texture);
        image1.setSize(texture.getWidth() / 3, texture.getHeight() / 3);
        image1.setPosition(Gdx.graphics.getWidth() / 3 - image1.getWidth() / 2, Gdx.graphics.getHeight() * 2 / 3 - image1.getHeight() / 2);
        stage.addActor(image1);

        Image image2 = new Image(texture);
        image2.setSize(texture.getWidth() / 3, texture.getHeight() / 3);
        image2.rotateBy(45);
        image2.setOrigin(image2.getWidth() / 2, image2.getHeight() / 2);
        image2.setPosition(Gdx.graphics.getWidth() / 2 - image1.getWidth() / 2, Gdx.graphics.getHeight() * 2 / 3 - image1.getHeight() / 2);
        stage.addActor(image2);

        Image image3 = new Image(texture);
        image3.setSize(texture.getWidth() / 5, texture.getHeight() / 5);
        stage.addActor(image3);


        texture.setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);
        TextureRegion textureRegion = new TextureRegion(texture);
        textureRegion.setRegion(0, 0, texture.getWidth() * 100, texture.getHeight());
        Image image4 = new Image(textureRegion);
        image4.setSize(texture.getWidth() , texture.getHeight() / 5);
        image4.setPosition(100, 100);
        stage.addActor(image4);
    }
}