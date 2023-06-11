package org.academiadecodigo.proxymorons.Just_a_Dude.Characters;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public abstract class Entity {
    private Position position;
    private Direction direction;
    private Rectangle rectangle; //picture later
    private int speed;

    public abstract void move(Direction direction);
    public abstract void hit();

    public void draw() {
        rectangle.draw();
    }
    public void hide(){
        rectangle.delete();
    }

}
