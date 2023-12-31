package org.academiadecodigo.proxymorons.Just_a_Dude.Characters;


import org.academiadecodigo.proxymorons.Just_a_Dude.Bullet;
import org.academiadecodigo.proxymorons.Just_a_Dude.Logics.Background;
import org.academiadecodigo.proxymorons.Just_a_Dude.Logics.Endscreen;
import org.academiadecodigo.proxymorons.Just_a_Dude.Logics.Game;
import org.academiadecodigo.proxymorons.Just_a_Dude.Logics.Music;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import static org.academiadecodigo.proxymorons.Just_a_Dude.Logics.Background.PADDING;
import static org.academiadecodigo.proxymorons.Just_a_Dude.Logics.Background.getWidth;

public class Dude extends Character implements Shooter {
    private int health = 100;
    public final static int SPEED = 5;
    public boolean shooting;
    private long lastShootTime = System.currentTimeMillis();

    public Dude(Position position) {
        super(position, Direction.UP, new Picture(position.getxAxis(), position.getyAxis(), "Assets/Dude/DudeStanding/Front (26x50).png"));
    }

    public void draw() {
        if (getSprite() != null){
            getSprite().delete();
        }
        if (isDead()){
            getSprite().draw();
            return;
        }

        switch (getDirection()){
            case UP:
                if (isShooting()){
                    setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeShooting/BackShooting/BackShooting1 (26x50).png"));
                } else {
                    setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Back/Back2 (26x50).png"));
                }
                getSprite().draw();
                break;
            case DOWN:
                if (isShooting()){
                    setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeShooting/FrontShooting/FrontShooting1 (26x48).png"));
                } else {
                    setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Front/Front2 (26 x 50).png"));
                }
                getSprite().draw();
                break;
            case LEFT:
                if (isShooting()){
                    setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeShooting/LeftShooting/LeftShooting1 (36x48).png"));
                } else {
                    setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Left/Left1 (24x48).png"));
                }
                getSprite().draw();
                break;
            case RIGHT:
                if (isShooting()){
                    setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeShooting/RightShooting/RightShooting1 (36x48).png"));
                } else {
                    setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Right/Right1 (24x48).png"));
                }
                getSprite().draw();
                break;

        }

    }


    public void move(Direction direction) {
        switch (direction) {
            case UP:
                if (getPosition().getyAxis() - SPEED > PADDING) {
                    setDirection(Direction.UP);
                    draw();
                    getSprite().translate(0, -SPEED);
                    getPosition().setyAxis(getPosition().getyAxis() - SPEED);
                } else {
                    setDirection(Direction.DOWN);
                    getSprite().translate(0, -getSprite().getY() + PADDING);
                    getPosition().setyAxis(PADDING);
                    //System.out.println(getSprite().getY());
                    //System.out.println(getPosition().getyAxis());
                }
                break;
            case RIGHT:
                if (getPosition().getxAxis() + SPEED < PADDING + Background.getWidth() - getSprite().getWidth()) {
                    setDirection(Direction.RIGHT);
                    draw();
                    getSprite().translate(SPEED, 0);
                    getPosition().setxAxis(getPosition().getxAxis() + SPEED);
                } else {
                    setDirection(Direction.LEFT);
                    getSprite().translate(Background.getWidth()-(getSprite().getX()-PADDING)-getSprite().getWidth(), 0);
                    getPosition().setxAxis(PADDING+Background.getWidth()-getSprite().getWidth());
                    //System.out.println(getSprite().getX());
                    //System.out.println(getPosition().getxAxis());
                }
                break;
            case DOWN:
                if (getPosition().getyAxis() + SPEED < PADDING + Background.getHeight() - getSprite().getHeight()) {
                    setDirection(Direction.DOWN);
                    draw();
                    getSprite().translate(0, SPEED);
                    getPosition().setyAxis(getPosition().getyAxis() + SPEED);
                } else {
                    setDirection(Direction.UP);
                    getSprite().translate(0, Background.getHeight() - (getSprite().getY() - PADDING) - getSprite().getHeight());
                    getPosition().setyAxis(PADDING + Background.getHeight() - getSprite().getHeight());
                    //System.out.println(getSprite().getY());
                    //System.out.println(getPosition().getyAxis());
                }
                break;
            case LEFT:
                if (getPosition().getxAxis() - SPEED > PADDING) {
                    setDirection(Direction.LEFT);
                    draw();
                    getSprite().translate(-SPEED, 0);
                    getPosition().setxAxis(getPosition().getxAxis() - SPEED);
                } else {
                    setDirection(Direction.RIGHT);
                    getSprite().translate(-getSprite().getX() + PADDING, 0);
                    getPosition().setxAxis(PADDING);
                    //System.out.println(getSprite().getX());
                    //System.out.println(getPosition().getxAxis());
                }
                break;
        }
    }

    public void shoot() {
        setShooting(true);
        draw();
        int x = ((getSprite().getX() + (getSprite().getX() + getSprite().getWidth()))/2);
        int y = ((getSprite().getY() + (getSprite().getY() + getSprite().getHeight()))/2);
        Picture bulletSprite = new Picture();
        switch (getDirection()) {
            case DOWN:
                Picture down = new Picture(x, y, "Assets/Bullet/BulletDown (6x8).png");
                bulletSprite = down;
                break;
            case UP:
                Picture up = new Picture(x, y, "Assets/Bullet/BulletFront (6x8).png");
                bulletSprite = up;
                break;
            case LEFT:
                Picture left = new Picture(x, y, "Assets/Bullet/BulletLeft (8x6).png");
                bulletSprite = left;
                break;
            case RIGHT:
                Picture right = new Picture(x, y, "Assets/Bullet/BulletRight (8x6).png");
                bulletSprite = right;
                break;
        }
        bulletSprite.draw();
        Position tempPos = new Position(x, y);
        Bullet bullet = new Bullet(bulletSprite, getDirection(), tempPos);
        Game.bullets.add(bullet);
        setShooting(false);
        //sound effect
        String filepath = "Assets/Sound/shoot.wav";
        Music music = new Music();
        music.clipSound(filepath);
    }





    public Position[] getHitBox() {
        return super.getHitBox();
    }


    public void hit(){
        if (!isDead()) {
            this.health--;
            if (health <= 0) {
                health = 0;
                setDead(true);
                Game.gameover=true;
                Endscreen.start();
            }
        }
    }

    @Override
    public void setDead(boolean dead) {
        super.setDead(dead);
        getSprite().delete();
        setSprite(new Picture(getSprite().getX(), getSprite().getY() + 34, "Assets/Dude/DudeDeath/Death (42x16).png"));
        draw();
    }

    public int getHealth() {
        return health;
    }


    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isShooting() {
        return shooting;
    }

    public void setShooting(boolean shooting) {
        this.shooting = shooting;
    }


    public long getLastShootTime() {
        return lastShootTime;
    }

    public void setLastShootTime(long lastShootTime) {
        this.lastShootTime = lastShootTime;
    }

}
