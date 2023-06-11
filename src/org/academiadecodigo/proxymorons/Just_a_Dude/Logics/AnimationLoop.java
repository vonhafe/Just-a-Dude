package org.academiadecodigo.proxymorons.Just_a_Dude.Logics;

import org.academiadecodigo.proxymorons.Just_a_Dude.Bullet;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Dude;

public class AnimationLoop {


    public void start(){

        // !gameover
        while(true){

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //see synchronization, still has concurrent modification error
            for(Bullet bullet : Game.bullets){
                if (bullet.isOutOfBounds() || bullet.hitEnemy()) {
                    bullet.hit();
                }
                if(bullet.isShooting()){
                    bullet.updateBullet();
                }

            }

            //remove not shooting bullets
            for (int i = 0; i < Game.bullets.size(); i++){
                Bullet bullet = Game.bullets.get(i);
                if (!bullet.isShooting()){
                    Game.bullets.remove(bullet);
                    i--;
                }
            }
        }
    }
}
