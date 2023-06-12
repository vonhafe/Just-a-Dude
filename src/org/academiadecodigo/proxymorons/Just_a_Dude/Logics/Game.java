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
    private LinkedList<Enemy> enemies= new LinkedList<>();
    public static LinkedList<Bullet> bullets = new LinkedList<>();
    private MyKeyboardHandler myKeyboardHandler;
    private MyMouseHandler myMouseHandler;
    private int enemiesPerRound = 10;

    public Game() {
        background = new Background();
        dude = new Dude(new Position(Background.getWidth()/2, Background.getHeight()/2 ));
        myKeyboardHandler = new MyKeyboardHandler(dude);
        myMouseHandler = new MyMouseHandler(dude);


    }

    public void start() {
        background.start();
        dude.draw();
        myKeyboardHandler.init();
        myMouseHandler.init();
        createEnemies(enemiesPerRound);
        AnimationLoop loop = new AnimationLoop();
        loop.setGame(this);
        loop.start();

    }

    public LinkedList<Enemy> createEnemies(int  numberEnemies){
        for (int i = 0; i < numberEnemies; i++) {
            enemies.add(EnemyFactory.getNewEnemy());
            //System.out.println(enemies.size());
        }
        return enemies;
    }

    public void moveAllEnemies(LinkedList<Enemy> enemies) {
        for (Enemy enemy : enemies) {

            if (!enemy.isDead()) {
                int chance = (int) Math.ceil(Math.random() * 1000);
                if (enemy.getPosition().getxAxis() == Background.getWidth() - enemy.getSprite().getWidth() + PADDING - 1) {
                    enemy.getPosition().setxAxis(enemy.getPosition().getxAxis() - 1);
                    enemy.setDirection(Direction.LEFT);
                } else if (enemy.getPosition().getxAxis() == PADDING) {
                    enemy.getPosition().setxAxis(enemy.getPosition().getxAxis() + 1);
                    enemy.setDirection(Direction.RIGHT);
                } else if (enemy.getPosition().getyAxis() == Background.getHeight() - enemy.getSprite().getHeight() + PADDING - 1) {
                    enemy.getPosition().setyAxis(enemy.getPosition().getyAxis() - 1);
                    enemy.setDirection(Direction.UP);
                } else if (enemy.getPosition().getyAxis() == PADDING) {
                    enemy.getPosition().setyAxis(enemy.getPosition().getyAxis() + 1);
                    enemy.setDirection(Direction.DOWN);
                } else {
                    if (chance <= 995 && chance > 990) {
                        Direction direction = enemy.left();
                        enemy.setDirection(direction);
                    } else if (chance <= 990) {
                        enemy.forward();
                    } else {
                        Direction direction = enemy.right();
                        enemy.setDirection(direction);
                    }
                }
            }

        }

    }

    public LinkedList<Enemy> getEnemies() {
        return enemies;
    }

    public int getEnemiesPerRound() {
        return enemiesPerRound;
    }

    public void setEnemiesPerRound(int enemiesPerRound) {
        this.enemiesPerRound = enemiesPerRound;
    }
}
