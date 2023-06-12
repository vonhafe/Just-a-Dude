package org.academiadecodigo.proxymorons.Just_a_Dude;

import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Direction;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Dude;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Enemy.Enemy;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Enemy.StandardEnemy;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Position;

public class Tests {
    public static void main(String[] args) {

        Dude dude = new Dude(new Position(0, 0));

        Enemy enemy = new StandardEnemy(new Position(0, 0), Direction.DOWN);
        //Bullet bullet = new Bullet();

        for (Position position : dude.getHitBox()){
            System.out.println(position);
        }
    }
}
