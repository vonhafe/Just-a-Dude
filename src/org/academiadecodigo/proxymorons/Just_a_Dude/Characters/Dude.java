package org.academiadecodigo.proxymorons.Just_a_Dude.Characters;


import org.academiadecodigo.proxymorons.Just_a_Dude.Bullet;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Dude extends Character implements Shooter {
    private int health = 100;
    private Position position;
    private Bullet bullet;
    private Direction direction = Direction.UP;
    private Rectangle sprite;
    public final static int SPEED=5;
    private boolean shooting;

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
        position.setyAxis(-SPEED);
        break;
    case RIGHT:
        sprite.translate(SPEED,0);
        position.setxAxis(SPEED);
        break;
    case DOWN:
        sprite.translate(0,SPEED);
        position.setyAxis(SPEED);
        break;
    case LEFT:
        sprite.translate(-SPEED,0);
        position.setxAxis(-SPEED);
        break;
}
    }

    public void shoot(){
        Rectangle bulletSprite = new Rectangle(sprite.getX(), sprite.getY(), 10,10);
        bulletSprite.draw();
        bullet = new Bullet(bulletSprite);
        shooting = true;
    }

    public void updateBullet(){
        if (shooting){
            bullet.move();
        }
    }

    public void hit(){
        health--;
    }

}
