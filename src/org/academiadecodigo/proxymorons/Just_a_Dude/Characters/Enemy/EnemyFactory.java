package org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Enemy;

import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Direction;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Position;

public class EnemyFactory {
    private Direction direction;
    public static Enemy getNewEnemy(){
        if (Math.random() > 0.75f) {
            return new StandardEnemy(new Position(1280, (int) (Math.random() * 720)), Direction.LEFT);
        } else if (Math.random()>0.5f) {
            return new StandardEnemy(new Position( (int) (Math.random() * 1280),720), Direction.UP);
        } else if (Math.random()>0.25f) {
            return new StandardEnemy(new Position(0, (int) (Math.random() * 720)), Direction.RIGHT);
        } else {
            return new StandardEnemy(new Position( (int) (Math.random() * 1280),0), Direction.DOWN);
        }
    }
}
