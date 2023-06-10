package org.academiadecodigo.proxymorons.Just_a_Dude.Logics;

import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Dude;

public class AnimationLoop {
    private Dude dude;
    public void  setDude(Dude dude){
        this.dude=dude;
    }
    public void start(){

        // !gameover
        while(true){

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            dude.updateBullet();
        }
    }
}
