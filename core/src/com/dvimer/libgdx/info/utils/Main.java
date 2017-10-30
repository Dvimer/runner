package com.dvimer.libgdx.info.utils;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.dvimer.libgdx.info.runner.factory.MyLabel;

public class Main extends ApplicationAdapter {
    private Stage stage;
    private MyImage myImage;
    private MyLabel myLabel;
    private MyButton myButton;
    private MyCamera myCamera;


    @Override
    public void create() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        myCamera = new MyCamera(stage);
//        myButton = new MyButton(stage);
//        myButton.draw();
//        myImage = new MyImage(stage);
//        myLabel = new MyLabel(stage);
//        myImage.draw();
//        myLabel.draw();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }
}
