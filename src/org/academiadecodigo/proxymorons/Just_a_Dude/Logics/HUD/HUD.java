package org.academiadecodigo.proxymorons.Just_a_Dude.Logics.HUD;

import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Dude;
import org.academiadecodigo.proxymorons.Just_a_Dude.Logics.Game;

public class HUD {
    private Dude dude;
    private HealthBar healthBar;
    private Score score;

    public HUD(Game game){
        this.dude = game.getDude();
        this.healthBar = new HealthBar(dude);
        this.score = new Score();
    }

    public HealthBar getHealthBar() {
        return healthBar;
    }

    public Score getScore() {
        return score;
    }
}

