package org.academiadecodigo.proxymorons.Just_a_Dude;

import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Dude;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Position;

public class Tests {
    public static void main(String[] args) {

        Dude dude = new Dude(new Position(0, 0));


        for (Position position : dude.getHitBox()){
            System.out.println(position);
        }
    }
}
