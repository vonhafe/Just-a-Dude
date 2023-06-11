package org.academiadecodigo.proxymorons.Just_a_Dude.Logics;

import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Dude;

public class AnimationLoop {
    private Game game;
    private Dude dude;
    public void  setDude(Dude dude, Game game){
        this.dude=dude;
        this.game=game;
    }
    public void start(){

        // !gameover
        while(true){

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            game.moveAllEnemies(game.getEnemies());
            dude.updateBullet();
        }
    }
}
