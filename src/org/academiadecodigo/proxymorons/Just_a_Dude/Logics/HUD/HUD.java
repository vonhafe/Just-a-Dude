package org.academiadecodigo.proxymorons.Just_a_Dude.Logics.HUD;

import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Dude;
import org.academiadecodigo.proxymorons.Just_a_Dude.Logics.Game;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class HUD {
    private Dude dude;
    private HealthBar healthBar;
    private static Text reload;
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

    public static void reloadDraw() {
        if (reload != null) {return;}
        reload = new Text(670, 650, "Press 'R' to reload");
        reload.draw();
        reload.grow(110, 15);
        reload.setColor(Color.RED);
    }
    public void setReload(Text reload) {
        this.reload = reload;
    }

    public static void resetReload(){
        if(reload != null) {
            reload.delete();
            reload = null;
        }
    }
}

