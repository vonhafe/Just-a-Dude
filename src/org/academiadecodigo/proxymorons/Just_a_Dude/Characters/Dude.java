package org.academiadecodigo.proxymorons.Just_a_Dude.Characters;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Dude implements Character, Shooter {
    private int health = 100;
    private Position position;
    private Direction direction = Direction.UP;
    private Rectangle sprite;
    public final static int SPEED=5;

    public Dude(Position position){
        this.position = position;
        sprite = new Rectangle(position.getxAxis(), position.getyAxis(), 20, 40);
    }

    public void draw(){
        sprite.setColor(Color.BLUE);
        sprite.fill();
    }



    public void move(Direction direction){
switch (direction){
    case UP:
        sprite.translate(0,-SPEED);
        break;
    case RIGHT:
        sprite.translate(SPEED,0);
        break;
    case DOWN:
        sprite.translate(0,SPEED);
        break;
    case LEFT:
        sprite.translate(-SPEED,0);
        break;
}
    }

    public void shoot(){

    }

    public void hit(){health--;}

}
