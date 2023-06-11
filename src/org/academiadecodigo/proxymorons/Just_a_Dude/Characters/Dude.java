package org.academiadecodigo.proxymorons.Just_a_Dude.Characters;


import org.academiadecodigo.proxymorons.Just_a_Dude.Bullet;
import org.academiadecodigo.proxymorons.Just_a_Dude.Logics.Game;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Dude extends Character implements Shooter {
    private int health = 100;
    private Position position;
    private Direction direction;
    private Rectangle sprite;
    public final static int SPEED = 5;

    public Dude(Position position) {

        this.direction = Direction.DOWN;
        this.position = position;
        sprite = new Rectangle(position.getxAxis(), position.getyAxis(), 20, 40);
    }

    public void draw() {
        sprite.setColor(Color.BLUE);
        sprite.fill();
    }


    public void move(Direction direction) {
        switch (direction) {
            case UP:
                this.direction = Direction.UP;
                sprite.translate(0, -SPEED);
                position.setyAxis(position.getyAxis() - SPEED);
                break;
            case RIGHT:
                this.direction = Direction.RIGHT;
                sprite.translate(SPEED, 0);
                position.setxAxis(position.getxAxis() + SPEED);
                break;
            case DOWN:
                this.direction = Direction.DOWN;
                sprite.translate(0, SPEED);
                position.setyAxis(position.getyAxis() + SPEED);
                break;
            case LEFT:
                this.direction = Direction.LEFT;
                sprite.translate(-SPEED, 0);
                position.setxAxis(position.getxAxis() - SPEED);
                break;
        }
    }

    public void shoot() {
        Rectangle bulletSprite = new Rectangle(sprite.getX(), sprite.getY(), 10, 10);
        bulletSprite.draw();
        Position tempPos = new Position(getPosition().getxAxis(), getPosition().getyAxis());
        Bullet bullet = new Bullet(bulletSprite, direction, tempPos);
        Game.bullets.add(bullet);
    }


    public void hit() {
        health--;
    }


    public Direction getDirection() {
        return direction;
    }

    public Position getPosition() {
        return position;
    }


    public Position[] getHitBox() {
        return super.getHitBox();
    }
}
