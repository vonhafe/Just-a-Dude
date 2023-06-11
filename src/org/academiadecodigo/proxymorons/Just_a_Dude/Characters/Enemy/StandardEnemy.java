package org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Enemy;

import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Direction;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Position;

public class StandardEnemy extends Enemy{


    public StandardEnemy(Position position, Direction direction) {
        super(position,direction);
        //setDirection(direction());
    }

    @Override
    public void draw() {
        super.draw();
    }

    @Override
    public void move(Direction direction) {
    }

    @Override
    public void hit() {

    }
    /*
    public Direction getDirection() {
        return direction;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
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
        //System.out.println(this.getDirection());
        if (this.getDirection().equals(Direction.UP)){
            this.getPosition().setyAxis(this.getPosition().getyAxis()-10);
            super.
        } else if (this.getDirection().equals(Direction.RIGHT)) {
            this.getPosition().setxAxis(this.getPosition().getxAxis()+10);
        } else if (this.getDirection().equals(Direction.LEFT)) {
            this.getPosition().setxAxis(this.getPosition().getxAxis()-10);
        }else if (this.getDirection().equals(Direction.DOWN)) {
            this.getPosition().setyAxis(this.getPosition().getyAxis()+10);
        }
    }

    public Direction left(){
        if (this.getDirection().equals(Direction.UP)){
            this.getPosition().setxAxis(this.getPosition().getxAxis()-10);
            return Direction.LEFT;
        } else if (this.getDirection().equals(Direction.RIGHT)) {
            this.getPosition().setyAxis(this.getPosition().getyAxis()-10);
            return Direction.UP;
        } else if (this.getDirection().equals(Direction.LEFT)) {
            this.getPosition().setyAxis(this.getPosition().getyAxis()+10);
            return Direction.DOWN;
        }else  {//"down"
            this.getPosition().setxAxis(this.getPosition().getxAxis()+10);
            return Direction.RIGHT;
        }
    }

    public Direction right(){
        if (this.getDirection().equals(Direction.UP)){
            this.getPosition().setxAxis(this.getPosition().getxAxis()+10);
            return Direction.RIGHT;
        } else if (this.getDirection().equals(Direction.RIGHT)) {
            this.getPosition().setyAxis(this.getPosition().getyAxis()+10);
            return Direction.DOWN;
        } else if (this.getDirection().equals(Direction.LEFT)) {
            this.getPosition().setyAxis(this.getPosition().getyAxis()-10);
            return Direction.UP;
        }else {//down
            this.getPosition().setxAxis(this.getPosition().getxAxis()-10);
            return Direction.LEFT;
        }
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
*/
}
