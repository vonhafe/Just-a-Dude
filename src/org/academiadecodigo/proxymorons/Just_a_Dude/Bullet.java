package org.academiadecodigo.proxymorons.Just_a_Dude;

import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Direction;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Entity;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Position;
import org.academiadecodigo.proxymorons.Just_a_Dude.Logics.Background;
import org.academiadecodigo.proxymorons.Just_a_Dude.Logics.Game;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Bullet extends Entity {
    private boolean shooting;
    public static int SPEED = 10;

    public Bullet(Rectangle bulletSprite, Direction direction, Position position) {
        super(position,direction,bulletSprite);
        this.shooting = true;
    }

    public void move(Direction direction) {
        switch (direction) {
            case UP:
                getSprite().translate(0, -SPEED);
                getPosition().setyAxis(getPosition().getyAxis() - SPEED);
                break;
            case RIGHT:
                getSprite().translate(SPEED, 0);
                getPosition().setxAxis(getPosition().getxAxis() + SPEED);
                break;
            case DOWN:
                getSprite().translate(0, SPEED);
                getPosition().setyAxis(getPosition().getyAxis() + SPEED);
                break;
            case LEFT:
                getSprite().translate(-SPEED, 0);
                getPosition().setxAxis(getPosition().getxAxis() - SPEED);
                break;
        }
    }

    public boolean isShooting() {
        return shooting;
    }

    public void setShooting(boolean shooting) {
        this.shooting = shooting;
    }

    public boolean isOutOfBounds() {
        if (getPosition().getyAxis() < 10) {
            return true;
        }
        if (getPosition().getyAxis() > Background.getHeight()) {
            return true;
        }
        if (getPosition().getxAxis() < 10) {
            return true;
        }
        if (getPosition().getxAxis() > Background.getWidth()) {
            return true;
        }
    return false;
    }

    public boolean  hitEnemy(){
        return false;
    }

    public void updateBullet() {
        if (isShooting()) {
            move(getDirection());
        }
    }


    @Override
    public void hit() {
        shooting = false;
        getSprite().delete();
    }
}
