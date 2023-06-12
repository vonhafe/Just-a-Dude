package org.academiadecodigo.proxymorons.Just_a_Dude.Characters;


import org.academiadecodigo.proxymorons.Just_a_Dude.Bullet;
import org.academiadecodigo.proxymorons.Just_a_Dude.Logics.Game;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

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
        Rectangle bulletSprite = new Rectangle(getSprite().getX(), getSprite().getY(), 10, 10);
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
