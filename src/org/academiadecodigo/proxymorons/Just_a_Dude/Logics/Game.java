package org.academiadecodigo.proxymorons.Just_a_Dude.Logics;

import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Direction;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Dude;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Enemy.Enemy;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Enemy.EnemyFactory;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Position;
import org.academiadecodigo.proxymorons.Just_a_Dude.Inputs.MyKeyboardHandler;

import java.util.LinkedList;

public class Game {
    private Background background;
    private Dude dude;
    private LinkedList<Enemy> enemies= new LinkedList<>();
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
        createEnemies(10);
        AnimationLoop loop = new AnimationLoop();
        loop.setDude(dude,this);
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

            //System.out.println(c+" "+c.getPos().getCol()+" "+c.getPos().getRow());
            //if (!enemy.isCrashed()) {
                //System.out.println("not crashed");
                int chance = (int) Math.ceil(Math.random() * 1000);
                //System.out.println("chance: " + chance);
            //System.out.println(enemy.getPosition().getxAxis());
                if (enemy.getPosition().getxAxis() == background.getWidth() - 1) {
                    enemy.getPosition().setxAxis(enemy.getPosition().getxAxis() - 1);
                    enemy.setDirection(Direction.LEFT);
                } else if (enemy.getPosition().getxAxis() == 0) {
                    enemy.getPosition().setxAxis(enemy.getPosition().getxAxis() + 1);
                    enemy.setDirection(Direction.RIGHT);
                } else if (enemy.getPosition().getyAxis() == background.getHeight() - 1) {
                    enemy.getPosition().setyAxis(enemy.getPosition().getyAxis() - 1);
                    enemy.setDirection(Direction.UP);
                } else if (enemy.getPosition().getyAxis() == 0) {
                    enemy.getPosition().setyAxis(enemy.getPosition().getyAxis() + 1);
                    enemy.setDirection(Direction.DOWN);
                } else {
                    //System.out.println("BANANA");
                    if (chance <= 990 && chance > 980) {
                        System.out.println("here");
                        Direction direction = enemy.left();
                        enemy.setDirection(direction);
                    } else if (chance <= 980) {
                        enemy.forward();
                        //System.out.println(c.left());
                    } else {
                        Direction direction = enemy.right();
                        System.out.println("here2");
                        //System.out.println(c.right());
                        enemy.setDirection(direction);
                    }
                }
            //}

        }

    }

    public LinkedList<Enemy> getEnemies() {
        return enemies;
    }
}
