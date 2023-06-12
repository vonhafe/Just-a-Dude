package org.academiadecodigo.proxymorons.Just_a_Dude.Characters;


import org.academiadecodigo.proxymorons.Just_a_Dude.Bullet;
import org.academiadecodigo.proxymorons.Just_a_Dude.Logics.Background;
import org.academiadecodigo.proxymorons.Just_a_Dude.Logics.Game;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import static org.academiadecodigo.proxymorons.Just_a_Dude.Logics.Background.PADDING;
import static org.academiadecodigo.proxymorons.Just_a_Dude.Logics.Background.getWidth;

public class Dude extends Character implements Shooter {
    private int health = 100;
    public final static int SPEED = 5;

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
                setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Back/Back2 (26x50).png"));
                getSprite().draw();
                break;
            case DOWN:
                setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Front/Front2 (26 x 50).png"));
                getSprite().draw();
                break;
            case LEFT:
                setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Left/Left1 (24x48).png"));
                getSprite().draw();
                break;
            case RIGHT:
                setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Right/Right1 (24x48).png"));
                getSprite().draw();
                break;

        }

    }


    public void move(Direction direction) {
        switch (direction) {
            case UP:
                draw();
                if (getPosition().getyAxis() - SPEED > PADDING) {
                    setDirection(Direction.UP);
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
                draw();
                if (getPosition().getxAxis() + SPEED < PADDING + Background.getWidth() - getSprite().getWidth()) {
                    setDirection(Direction.RIGHT);
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
                draw();
                if (getPosition().getyAxis() + SPEED < PADDING + Background.getHeight() - getSprite().getHeight()) {
                    setDirection(Direction.DOWN);
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
                draw();
                if (getPosition().getxAxis() - SPEED > PADDING) {
                    setDirection(Direction.LEFT);
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
        int x = ((getSprite().getX() + (getSprite().getX() + getSprite().getWidth()))/2);
        int y = ((getSprite().getY() + (getSprite().getY() + getSprite().getHeight()))/2);
        Picture bulletSprite = new Picture(x, y, "Assets/Bullet/BulletDown (6x8).png");
        bulletSprite.draw();
        Position tempPos = new Position(getPosition().getxAxis(), getPosition().getyAxis());
        Bullet bullet = new Bullet(bulletSprite, getDirection(), tempPos);
        Game.bullets.add(bullet);
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
}
