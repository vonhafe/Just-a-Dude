package org.academiadecodigo.proxymorons.Just_a_Dude.Logics;

import org.academiadecodigo.proxymorons.Just_a_Dude.Bullet;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Enemy.Enemy;

public class AnimationLoop {

    private Game game;


    public void setGame(Game game) {

        this.game = game;
    }

    public void start() {

        // !gameover
        while (true) {

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            game.moveAllEnemies(game.getEnemies());


            //see synchronization, still has concurrent modification error
            for (Bullet bullet : Game.bullets) {
                if (bullet.isOutOfBounds() || bullet.hitEnemy(game)) {
                    bullet.hit();
                }
                if (bullet.isShooting()) {
                    bullet.updateBullet();
                }

            }

            //remove not shooting bullets
            for (int i = 0; i < Game.bullets.size(); i++) {
                Bullet bullet = Game.bullets.get(i);
                if (!bullet.isShooting()) {
                    Game.bullets.remove(bullet);
                    i--;
                }
            }

            for (int i = 0; i < game.getEnemies().size(); i++) {
                Enemy enemy = game.getEnemies().get(i);
                if (enemy.isDead()) {
                    game.getEnemies().remove(enemy);
                    i--;
                }
            }

            //new round
            if(game.getEnemies().size() == 0){
                game.setEnemiesPerRound(game.getEnemiesPerRound() + 5);
                game.createEnemies(game.getEnemiesPerRound());
            }

        }
    }
}
