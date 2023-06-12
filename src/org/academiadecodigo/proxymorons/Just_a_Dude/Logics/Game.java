package org.academiadecodigo.proxymorons.Just_a_Dude.Logics;


import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Direction;

import org.academiadecodigo.proxymorons.Just_a_Dude.Bullet;

import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Dude;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Enemy.Enemy;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Enemy.EnemyFactory;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Position;
import org.academiadecodigo.proxymorons.Just_a_Dude.Inputs.MyKeyboardHandler;
import org.academiadecodigo.proxymorons.Just_a_Dude.Inputs.MyMouseHandler;

import java.util.LinkedList;

import static org.academiadecodigo.proxymorons.Just_a_Dude.Logics.Background.PADDING;

public class Game {
    private Background background;
    private Dude dude;
    private LinkedList<Enemy> enemies = new LinkedList<>();
    public static LinkedList<Bullet> bullets = new LinkedList<>();
    private MyKeyboardHandler myKeyboardHandler;
    private MyMouseHandler myMouseHandler;


    public Game() {
        background = new Background();
        dude = new Dude(new Position(Background.getWidth() / 2, Background.getHeight() / 2));
        myKeyboardHandler = new MyKeyboardHandler(dude);
        myMouseHandler = new MyMouseHandler(dude);


    }

    public void start() {
        background.start();
        dude.draw();
        myKeyboardHandler.init();
        myMouseHandler.init();
        createEnemies(10);
        AnimationLoop loop = new AnimationLoop();
        loop.setGame(this);
        loop.start();

    }

    public LinkedList<Enemy> createEnemies(int numberEnemies) {
        for (int i = 0; i < numberEnemies; i++) {
            enemies.add(EnemyFactory.getNewEnemy());
            //System.out.println(enemies.size());
        }
        return enemies;
    }

    public void moveAllEnemies(LinkedList<Enemy> enemies) {
        for (Enemy enemy : enemies) {

            //if (!enemy.isCrashed()) {
            if (dude.getPosition().getyAxis() < enemy.getPosition().getyAxis()) {
                enemy.getPosition().setyAxis(enemy.getPosition().getyAxis() - 1);
                enemy.getSprite().translate(0, -1);
            } else if (dude.getPosition().getyAxis() > enemy.getPosition().getyAxis()) {
                enemy.getPosition().setyAxis(enemy.getPosition().getyAxis() + 1);
                enemy.getSprite().translate(0, 1);

            }
            if (dude.getPosition().getxAxis() < enemy.getPosition().getxAxis()) {
                enemy.getPosition().setxAxis(enemy.getPosition().getxAxis() - 1);
                enemy.getSprite().translate(-1, 0);
            } else if (dude.getPosition().getxAxis() > enemy.getPosition().getxAxis()) {
                enemy.getPosition().setxAxis(enemy.getPosition().getxAxis() + 1);
                enemy.getSprite().translate(1, 0);

            }
            //}

        }

    }

    public LinkedList<Enemy> getEnemies() {
        return enemies;
    }
}
