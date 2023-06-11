package org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Enemy;

import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Character;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Direction;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Dude;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public abstract class Enemy extends Character {
    private Rectangle sprite;
    private Position position;
    private Direction direction;
    private int speed=1;

    public Enemy(Position position){
        this.position = position;
        sprite = new Rectangle(position.getxAxis(), position.getyAxis(), 20, 40);
        draw();
        direction=direction();
    }

    @Override
    public void draw() {
        sprite.setColor(Color.RED);
        sprite.fill();
    }
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
            this.getPosition().setyAxis(this.getPosition().getyAxis()-speed);
            sprite.translate(0,-speed);
        } else if (this.getDirection().equals(Direction.RIGHT)) {
            this.getPosition().setxAxis(this.getPosition().getxAxis()+speed);
            sprite.translate(speed,0);
        } else if (this.getDirection().equals(Direction.LEFT)) {
            this.getPosition().setxAxis(this.getPosition().getxAxis()-speed);
            sprite.translate(-speed,0);
        }else if (this.getDirection().equals(Direction.DOWN)) {
            this.getPosition().setyAxis(this.getPosition().getyAxis()+speed);
            sprite.translate(0,speed);
        }
    }

    public Direction left(){
        if (this.getDirection().equals(Direction.UP)){
            this.getPosition().setxAxis(this.getPosition().getxAxis()-speed);
            sprite.translate(-speed,0);
            return Direction.LEFT;
        } else if (this.getDirection().equals(Direction.RIGHT)) {
            this.getPosition().setyAxis(this.getPosition().getyAxis()-speed);
            sprite.translate(0,-speed);
            return Direction.UP;
        } else if (this.getDirection().equals(Direction.LEFT)) {
            this.getPosition().setyAxis(this.getPosition().getyAxis()+speed);
            sprite.translate(0,speed);
            return Direction.DOWN;
        }else  {//"down"
            this.getPosition().setxAxis(this.getPosition().getxAxis()+speed);
            sprite.translate(speed,0);
            return Direction.RIGHT;
        }
    }

    public Direction right(){
        if (this.getDirection().equals(Direction.UP)){
            this.getPosition().setxAxis(this.getPosition().getxAxis()+speed);
            sprite.translate(speed,0);
            return Direction.RIGHT;
        } else if (this.getDirection().equals(Direction.RIGHT)) {
            this.getPosition().setyAxis(this.getPosition().getyAxis()+speed);
            sprite.translate(0,speed);
            return Direction.DOWN;
        } else if (this.getDirection().equals(Direction.LEFT)) {
            this.getPosition().setyAxis(this.getPosition().getyAxis()-speed);
            sprite.translate(0,-speed);
            return Direction.UP;
        }else {//down
            this.getPosition().setxAxis(this.getPosition().getxAxis()-speed);
            sprite.translate(-speed,0);
            return Direction.LEFT;
        }
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
