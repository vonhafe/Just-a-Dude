package org.academiadecodigo.proxymorons.Just_a_Dude.Characters;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Entity {
    private Position position;
    private Direction direction;
    private Picture sprite; //picture later
    private int speed;

    public Entity(Position position, Direction direction, Picture sprite){
        this.position=position;
        this.direction=direction;
        this.sprite=sprite;
    }

    public abstract void move(Direction direction);
    public abstract void hit();

    public void draw() {
        sprite.draw();
    }
    public void hide(){
        sprite.delete();
    }

    public Position[] getHitBox(){
        Position[] hitBox = new Position[4];
        hitBox[0] = new Position(sprite.getX(), sprite.getY());
        hitBox[1] = new Position(sprite.getX() + sprite.getWidth(), sprite.getY());
        hitBox[2] = new Position(sprite.getX(), sprite.getY() + sprite.getHeight());
        hitBox[3] = new Position(sprite.getX() + sprite.getWidth(), sprite.getY() + sprite.getHeight());
        return hitBox;
    }

    public boolean isTouching(Entity entity){
            Position[] dudeTouchingBox = entity.getHitBox();
            for (Position point : dudeTouchingBox) {
                if (point.getxAxis() >= this.getPosition().getxAxis()
                        && point.getxAxis() <= this.getPosition().getxAxis() + this.getSprite().getWidth()
                        && point.getyAxis() >= this.getPosition().getyAxis()
                        && point.getyAxis() <= this.getPosition().getyAxis() + this.getSprite().getHeight()) {
                    return true;
                }
            }
        return false;
    }

    public Direction getDirection() {
        return direction;
    }

    public Position getPosition() {
        return position;
    }

    public Picture getSprite() {
        return sprite;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setSprite(Picture sprite) {
        this.sprite = sprite;
    }
}
