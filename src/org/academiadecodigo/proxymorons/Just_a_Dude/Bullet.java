package org.academiadecodigo.proxymorons.Just_a_Dude;

import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Direction;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Entity;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Position;
import org.academiadecodigo.proxymorons.Just_a_Dude.Logics.Background;
import org.academiadecodigo.proxymorons.Just_a_Dude.Logics.Game;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Bullet extends Entity {
    private Rectangle bulletSprite;
    private boolean shooting;
    private Direction direction;
    private Position position;
    public static int SPEED = 10;

    public Bullet(Rectangle bulletSprite, Direction direction, Position position) {
        this.position = position;
        this.direction = direction;
        this.bulletSprite = bulletSprite;
        this.shooting = true;
    }

    public void move(Direction direction) {
        switch (direction) {
            case UP:
                bulletSprite.translate(0, -SPEED);
                position.setyAxis(position.getyAxis() - SPEED);
                break;
            case RIGHT:
                bulletSprite.translate(SPEED, 0);
                position.setxAxis(position.getxAxis() + SPEED);
                break;
            case DOWN:
                bulletSprite.translate(0, SPEED);
                position.setyAxis(position.getyAxis() + SPEED);
                break;
            case LEFT:
                bulletSprite.translate(-SPEED, 0);
                position.setxAxis(position.getxAxis() - SPEED);
                break;
        }
    }

    public boolean isShooting() {
        return shooting;
    }

    public void setShooting(boolean shooting) {
        this.shooting = shooting;
    }

    public void setBulletSprite(Rectangle bulletSprite) {
        this.bulletSprite = bulletSprite;
    }

    public Rectangle getBulletSprite() {
        return bulletSprite;
    }

    public boolean isOutOfBounds() {
        if (position.getyAxis() < 10) {
            return true;
        }
        if (position.getyAxis() > Background.getHeight()) {
            return true;
        }
        if (position.getxAxis() < 10) {
            return true;
        }
        if (position.getxAxis() > Background.getWidth()) {
            return true;
        }
    return false;
    }

    public boolean  hitEnemy(){
        return false;
    }

    public void updateBullet() {
        if (isShooting()) {
            move(direction);
        }
    }


    @Override
    public void hit() {
        shooting = false;
        bulletSprite.delete();
    }
}
