package org.academiadecodigo.proxymorons.Just_a_Dude.Characters;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.awt.*;

public abstract class Character extends Entity{
    private int health;
    private boolean dead;

    public Character(Position position, Direction direction, Rectangle sprite) {
        super(position, direction, sprite);
    }


    public boolean isDead() {
        return dead;
    }
}
