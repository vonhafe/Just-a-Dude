package org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Enemy;

import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Character;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Direction;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Entity;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Enemy extends Character {

    private int speed=1;

    public Enemy(Position position, Direction direction){
        super(position,direction,new Picture(position.getxAxis(), position.getyAxis(), "Assets/Enemy/Standing/Front1 (24 x 44).png"));
        draw();
    }

    @Override
    public void draw() {
        getSprite().draw();
    }

    public Direction direction() {
        int direction = (int) Math.ceil(Math.random() * 4);
        switch (direction) {
            case 1:
                return Direction.UP;
            case 2:
                return Direction.RIGHT;
            case 3:
                return Direction.LEFT;
            default:
                return Direction.DOWN;
        }
    }
    public void forward(){
        if (getDirection().equals(Direction.UP)){
            getPosition().setyAxis(getPosition().getyAxis()-speed);
            getSprite().translate(0,-speed);
        } else if (getDirection().equals(Direction.RIGHT)) {
            getPosition().setxAxis(getPosition().getxAxis()+speed);
            getSprite().translate(speed,0);
        } else if (getDirection().equals(Direction.LEFT)) {
            getPosition().setxAxis(getPosition().getxAxis()-speed);
            getSprite().translate(-speed,0);
        }else if (getDirection().equals(Direction.DOWN)) {
            getPosition().setyAxis(getPosition().getyAxis()+speed);
            getSprite().translate(0,speed);
        }
    }

    public Direction left(){
        if (getDirection().equals(Direction.UP)){
            getPosition().setxAxis(getPosition().getxAxis()-speed);
            getSprite().translate(-speed,0);
            return Direction.LEFT;
        } else if (getDirection().equals(Direction.RIGHT)) {
            getPosition().setyAxis(getPosition().getyAxis()-speed);
            getSprite().translate(0,-speed);
            return Direction.UP;
        } else if (getDirection().equals(Direction.LEFT)) {
            getPosition().setyAxis(getPosition().getyAxis()+speed);
            getSprite().translate(0,speed);
            return Direction.DOWN;
        }else  {//"down"
            getPosition().setxAxis(getPosition().getxAxis()+speed);
            getSprite().translate(speed,0);
            return Direction.RIGHT;
        }
    }

    public Direction right(){
        if (getDirection().equals(Direction.UP)){
            getPosition().setxAxis(getPosition().getxAxis()+speed);
            getSprite().translate(speed,0);
            return Direction.RIGHT;
        } else if (getDirection().equals(Direction.RIGHT)) {
            getPosition().setyAxis(getPosition().getyAxis()+speed);
            getSprite().translate(0,speed);
            return Direction.DOWN;
        } else if (getDirection().equals(Direction.LEFT)) {
            getPosition().setyAxis(getPosition().getyAxis()-speed);
            getSprite().translate(0,-speed);
            return Direction.UP;
        }else {//down
            getPosition().setxAxis(getPosition().getxAxis()-speed);
            getSprite().translate(-speed,0);
            return Direction.LEFT;
        }
    }


    public Direction enemiesTouching(Entity entity) {
            Position[] enemyTouchingBox = entity.getHitBox();

                for (int i = 0; i < enemyTouchingBox.length; i++) {


                if (enemyTouchingBox[i].getxAxis() >= this.getPosition().getxAxis()
                        && enemyTouchingBox[i].getxAxis() <= this.getPosition().getxAxis() + this.getSprite().getWidth()
                        && enemyTouchingBox[i].getyAxis() >= this.getPosition().getyAxis()
                        && enemyTouchingBox[i].getyAxis() <= this.getPosition().getyAxis() + this.getSprite().getHeight()) {
                    if (i==0){

                    }
                }
            }
            return null;
    }

    public void dies(){
        setDead(true);
        getSprite().delete();
    }

}
