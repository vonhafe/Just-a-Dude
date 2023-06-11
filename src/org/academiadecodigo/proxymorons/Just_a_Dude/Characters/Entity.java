package org.academiadecodigo.proxymorons.Just_a_Dude.Characters;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public abstract class Entity {
    private Position position;
    private Direction direction;
    private Rectangle sprite; //picture later
    private int speed;

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
        Position[] thisHitBox = getHitBox();
        Position[] entityHitBox = entity.getHitBox();
        for (Position positionThis : thisHitBox){

        }
        return false;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setSprite(Rectangle sprite) {
        this.sprite = sprite;
    }
}
