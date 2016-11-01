package com.aqeebrizwan.game.states;

import com.aqeebrizwan.game.FlappyDemo;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Aqeeb on 10/11/2016.
 */

public class MenuState extends State {
    private Texture background;
    private Texture plyBtn;
    public MenuState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, FlappyDemo.WIDTH / 2 , FlappyDemo.HEIGHT / 2);
        background = new Texture("bger.png");
        plyBtn = new Texture("playbtn.png");

    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, 0,0);
        sb.draw(plyBtn, cam.position.x - plyBtn.getWidth() / 2, cam.position.y);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        plyBtn.dispose();
        System.out.println("Menu State disposed");
    }
}
