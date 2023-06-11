package org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Enemy;

import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Direction;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Dude;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Position;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Shooter;

public class ShooterEnemy extends Enemy implements Shooter {
    public ShooterEnemy(Position position) {
        super(position);
    }

    @Override
    public void move(Direction direction) {

    }

    @Override
    public void hit() {

    }
}
