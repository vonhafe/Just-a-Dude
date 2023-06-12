package org.academiadecodigo.proxymorons.Just_a_Dude.Characters;


import org.academiadecodigo.proxymorons.Just_a_Dude.Bullet;
import org.academiadecodigo.proxymorons.Just_a_Dude.Logics.Background;
import org.academiadecodigo.proxymorons.Just_a_Dude.Logics.Game;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import static org.academiadecodigo.proxymorons.Just_a_Dude.Logics.Background.PADDING;
import static org.academiadecodigo.proxymorons.Just_a_Dude.Logics.Background.getWidth;

public class Dude extends Character implements Shooter {
    private int health = 100;
    public final static int SPEED = 5;

    public Dude(Position position) {
        super(position, Direction.UP, new Rectangle(position.getxAxis(), position.getyAxis(), 20, 40));
    }

    public void draw() {
        getSprite().setColor(Color.BLUE);
        getSprite().fill();
    }


    public void move(Direction direction) {
        switch (direction) {
            case UP:
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
        Rectangle bulletSprite = new Rectangle(getSprite().getX(), getSprite().getY(), 10, 10);
        bulletSprite.draw();
        Position tempPos = new Position(getPosition().getxAxis(), getPosition().getyAxis());
        Bullet bullet = new Bullet(bulletSprite, getDirection(), tempPos);
        Game.bullets.add(bullet);
    }





    public Position[] getHitBox() {
        return super.getHitBox();
    }


    public void hit(){

    }


    public int getHealth() {
        return health;
    }


    public void setHealth(int health) {
        this.health = health;
    }
}
