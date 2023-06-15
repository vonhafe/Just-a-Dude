package org.academiadecodigo.proxymorons.Just_a_Dude.Characters;

import org.academiadecodigo.simplegraphics.pictures.Picture;


public abstract class Character extends Entity{
    private int health;
    private boolean dead;

    public Character(Position position, Direction direction, Picture sprite) {
        super(position, direction, sprite);
    }


    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public boolean isDead() {
        return dead;
    }
}
