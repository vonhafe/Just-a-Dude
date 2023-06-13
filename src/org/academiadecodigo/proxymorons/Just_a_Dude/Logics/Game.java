package org.academiadecodigo.proxymorons.Just_a_Dude.Logics;


import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Direction;

import org.academiadecodigo.proxymorons.Just_a_Dude.Bullet;

import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Dude;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Enemy.Enemy;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Enemy.EnemyFactory;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Position;
import org.academiadecodigo.proxymorons.Just_a_Dude.Inputs.MyKeyboardHandler;
import org.academiadecodigo.proxymorons.Just_a_Dude.Inputs.MyMouseHandler;
import org.academiadecodigo.proxymorons.Just_a_Dude.Logics.HUD.HUD;

import java.util.LinkedList;

import static org.academiadecodigo.proxymorons.Just_a_Dude.Logics.Background.PADDING;

public class Game {
    private Background background;
    private Dude dude;
    private HUD hud;
    private LinkedList<Enemy> enemies = new LinkedList<>();
    public static LinkedList<Bullet> bullets = new LinkedList<>();
    private MyKeyboardHandler myKeyboardHandler;
    private MyMouseHandler myMouseHandler;
    private int enemiesPerRound = 10;

    public Game() {
        background = new Background();
        background.start();
        dude = new Dude(new Position(Background.getWidth() / 2, Background.getHeight() / 2));
        myKeyboardHandler = new MyKeyboardHandler(dude);
        myMouseHandler = new MyMouseHandler(dude);
        hud = new HUD(this);


    }

    public void start() {
        dude.draw();
        myKeyboardHandler.init();
        myMouseHandler.init();
        createEnemies(enemiesPerRound);
        //sound effect
        String filepath = "Assets/Sound/background.wav";
        Music music = new Music();
        music.backgroundMusic(filepath);
        AnimationLoop loop = new AnimationLoop();
        loop.setGame(this);
        loop.start();

    }

    public LinkedList<Enemy> createEnemies(int numberEnemies) {
        for (int i = 0; i < numberEnemies; i++) {
            enemies.add(EnemyFactory.getNewEnemy());
        }
        return enemies;
    }

    public void moveAllEnemies(LinkedList<Enemy> enemies) {
        for (Enemy enemy : enemies) {

            if (!enemy.isDead()) {
                if (enemy.getPosition().getyAxis() < dude.getPosition().getyAxis()+200 &&
                        enemy.getPosition().getyAxis() > dude.getPosition().getyAxis()-200 &&
                        enemy.getPosition().getxAxis() < dude.getPosition().getxAxis()+200 &&
                        enemy.getPosition().getxAxis() > dude.getPosition().getxAxis()-200) {
                    seekMovement(enemy);

                } else if (enemy.getPosition().getyAxis() < PADDING ||
                        enemy.getPosition().getyAxis() > PADDING + Background.getHeight() - enemy.getSprite().getHeight() ||
                        enemy.getPosition().getxAxis() < PADDING ||
                        enemy.getPosition().getxAxis() > PADDING + Background.getWidth() - enemy.getSprite().getWidth()) {
                    seekMovement(enemy);

                } else {
                    randomMovements(enemy);
                }
            }
        }
    }

    public void seekMovement(Enemy enemy){
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
    }

    public void randomMovements(Enemy enemy){

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


    public LinkedList<Enemy> getEnemies() {
        return enemies;
    }

    public int getEnemiesPerRound() {
        return enemiesPerRound;
    }

    public void setEnemiesPerRound(int enemiesPerRound) {
        this.enemiesPerRound = enemiesPerRound;
    }

    public Dude getDude() {
        return dude;
    }

    public HUD getHUD() {
        return hud;
    }
}
