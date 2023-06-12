package org.academiadecodigo.proxymorons.Just_a_Dude.Logics.HUD;

import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Dude;
import org.academiadecodigo.proxymorons.Just_a_Dude.Logics.Game;

public class HUD {
    private Dude dude;
    private HealthBar healthBar;

    public HUD(Game game){
        this.dude = game.getDude();
        this.healthBar = new HealthBar(dude);
    }

    public HealthBar getHealthBar() {
        return healthBar;
    }
}

