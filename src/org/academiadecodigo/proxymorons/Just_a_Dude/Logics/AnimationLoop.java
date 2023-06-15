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

            if (game.isStarted()) {
                game.getStartScreen().hide();
                game.moveAllEnemies(game.getEnemies());

                //see synchronization, still has concurrent modification error
                //check collision bullets
                for (int i = 0; i < Game.bullets.size(); i++) {
                    if (Game.bullets.get(i).isOutOfBounds() || Game.bullets.get(i).hitEnemy(game)) {
                        Game.bullets.get(i).hit();
                    }
                    if (Game.bullets.get(i).isShooting()) {
                        Game.bullets.get(i).updateBullet();
                    }
                }

                for (int i = 0; i < Game.enemyBullets.size(); i++) {
                    if (Game.enemyBullets.get(i).isOutOfBounds() || Game.enemyBullets.get(i).hitDude(game)) {
                        Game.enemyBullets.get(i).hit();
                    }
                    if (Game.enemyBullets.get(i).isShooting()) {
                        Game.enemyBullets.get(i).updateBullet();
                    }

                }

                //check collision enemies
                for (Enemy enemy : game.getEnemies()) {
                    if (!enemy.isDead()) {
                        if (enemy.isTouching(game.getDude())) {
                            game.getDude().hit();
                            game.getHUD().getHealthBar().update();
                        }
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
                for (int i = 0; i < Game.enemyBullets.size(); i++) {
                    Bullet bullet = Game.enemyBullets.get(i);
                    if (!bullet.isShooting()) {
                        Game.enemyBullets.remove(bullet);
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
                if (game.getEnemies().size() == 0 && !Game.isGameover()) {
                    game.getHUD().getScore().updateRound();
                    game.setEnemiesPerRound(game.getEnemiesPerRound() + 5);
                    game.createEnemies(game.getEnemiesPerRound());
                }
            }

        }
    }
}
