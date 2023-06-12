package org.academiadecodigo.proxymorons.Just_a_Dude.Logics.HUD;

import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Dude;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class HealthBar {
    private Dude dude;
    private int health = 296;
    private Rectangle greyBackground = new Rectangle(20, 20, 300, 20);
    private Rectangle healthBar = new Rectangle(22, 22, health, 16);


    public HealthBar(Dude dude){
        this.dude = dude;
        greyBackground.setColor(Color.LIGHT_GRAY);
        greyBackground.fill();
        healthBar.setColor(Color.GREEN);
        healthBar.fill();
    }

    public void update(){
        health = ((dude.getHealth() * 296)/100);
        healthBar.delete();
        healthBar = new Rectangle(22, 22, health, 16);
        if(dude.getHealth() > 75){
            healthBar.setColor(Color.GREEN);
        } else if (dude.getHealth() > 40) {
            healthBar.setColor(Color.YELLOW);
        } else if (dude.getHealth() > 15) {
            healthBar.setColor(Color.ORANGE);
        }else {
            healthBar.setColor(Color.RED);
        }
        healthBar.fill();
    }

}
