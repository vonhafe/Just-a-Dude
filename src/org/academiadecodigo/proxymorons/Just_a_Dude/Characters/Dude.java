package org.academiadecodigo.proxymorons.Just_a_Dude.Characters;


import org.academiadecodigo.proxymorons.Just_a_Dude.Bullet;
import org.academiadecodigo.proxymorons.Just_a_Dude.Logics.Game;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Dude extends Character implements Shooter {
    private int health = 100;
    public final static int SPEED = 5;

    public Dude(Position position) {
        super(position, Direction.UP, new Picture(position.getxAxis(), position.getyAxis(), "Assets/Dude/DudeStanding/Front (26x50).png"));
    }

    public void draw() {
        getSprite().draw();
    }


    public void move(Direction direction) {
        switch (direction) {
            case UP:
                setDirection(Direction.UP);
                getSprite().translate(0, -SPEED);
                getPosition().setyAxis(getPosition().getyAxis() - SPEED);
                break;
            case RIGHT:
                setDirection(Direction.RIGHT);
                getSprite().translate(SPEED, 0);
                getPosition().setxAxis(getPosition().getxAxis() + SPEED);
                break;
            case DOWN:
                setDirection(Direction.DOWN);
                getSprite().translate(0, SPEED);
                getPosition().setyAxis(getPosition().getyAxis() + SPEED);
                break;
            case LEFT:
                setDirection(Direction.LEFT);
                getSprite().translate(-SPEED, 0);
                getPosition().setxAxis(getPosition().getxAxis() - SPEED);
                break;
        }
    }

    public void shoot() {
        int x = ((getSprite().getX() + (getSprite().getX() + getSprite().getWidth()))/2);
        int y = ((getSprite().getY() + (getSprite().getY() + getSprite().getHeight()))/2);
        Picture bulletSprite = new Picture(x, y, "Assets/Bullet/BulletDown (3x4).png");
        bulletSprite.draw();
        Position tempPos = new Position(getPosition().getxAxis(), getPosition().getyAxis());
        Bullet bullet = new Bullet(bulletSprite, getDirection(), tempPos);
        Game.bullets.add(bullet);
    }




    public void hit() {
        this.health--;
        if (health <= 0){
            health = 0;
            setDead(true);
        }
    }

    public Position[] getHitBox() {
        return super.getHitBox();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
