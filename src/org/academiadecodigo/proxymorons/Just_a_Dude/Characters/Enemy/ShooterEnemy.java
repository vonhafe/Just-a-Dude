package org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Enemy;

import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Direction;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Dude;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Position;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Shooter;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class ShooterEnemy extends Enemy implements Shooter {
    public ShooterEnemy(Position position, Direction direction) {
        super(position,direction,new Picture(position.getxAxis(), position.getyAxis(), "Assets/Enemy/Standing/Front (22x50).png"));
    }

    @Override
    public void move(Direction direction) {

    }

    @Override
    public void hit() {

    }
}
