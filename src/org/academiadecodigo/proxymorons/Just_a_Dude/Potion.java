package org.academiadecodigo.proxymorons.Just_a_Dude;

import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Direction;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Entity;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Potion extends Entity {
    private boolean used;

    public Potion(Position position, Direction direction, Picture sprite) {
        super(position, direction, sprite);
    }

    @Override
    public void move(Direction direction) {

    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    @Override
    public void hit() {

    }
}
