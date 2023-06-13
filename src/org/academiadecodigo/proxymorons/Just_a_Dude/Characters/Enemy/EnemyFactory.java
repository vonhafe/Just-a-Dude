package org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Enemy;

import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Direction;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Position;

public class EnemyFactory {
    private Direction direction;
    public static Enemy getNewEnemy(){
        if (Math.random()>0.5) {
            if (Math.random() > 0.75f) {
                return new StandardEnemy(new Position(1320, (int) (Math.random() * 720)), Direction.LEFT);
            } else if (Math.random() > 0.5f) {
                return new StandardEnemy(new Position((int) (Math.random() * 1280), 760), Direction.UP);
            } else if (Math.random() > 0.25f) {
                return new StandardEnemy(new Position(-40, (int) (Math.random() * 720)), Direction.RIGHT);
            } else {
                return new StandardEnemy(new Position((int) (Math.random() * 1280), -40), Direction.DOWN);
            }
        }else {
            if (Math.random() > 0.75f) {
                return new ShooterEnemy(new Position(1320, (int) (Math.random() * 720)), Direction.LEFT);
            } else if (Math.random() > 0.5f) {
                return new ShooterEnemy(new Position((int) (Math.random() * 1280), 760), Direction.UP);
            } else if (Math.random() > 0.25f) {
                return new ShooterEnemy(new Position(-40, (int) (Math.random() * 720)), Direction.RIGHT);
            } else {
                return new ShooterEnemy(new Position((int) (Math.random() * 1280), -40), Direction.DOWN);
            }
        }
    }
}
