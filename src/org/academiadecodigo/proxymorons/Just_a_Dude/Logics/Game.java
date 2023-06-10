package org.academiadecodigo.proxymorons.Just_a_Dude.Logics;

import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Dude;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Enemy.Enemy;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Position;
import org.academiadecodigo.proxymorons.Just_a_Dude.Inputs.MyKeyboardHandler;

import java.util.LinkedList;

public class Game {
    private Background background;
    private Dude dude;
    private LinkedList<Enemy> enemies;
    private MyKeyboardHandler myKeyboardHandler;


    public Game() {
        background = new Background();
        dude = new Dude(new Position(background.getWidth()/2, background.getHeight()/2 ));
        myKeyboardHandler = new MyKeyboardHandler(dude);

    }

    public void start() {

        background.start();
        dude.draw();
        myKeyboardHandler.init();
        AnimationLoop loop = new AnimationLoop();
        loop.setDude(dude);
        loop.start();
    }
}
