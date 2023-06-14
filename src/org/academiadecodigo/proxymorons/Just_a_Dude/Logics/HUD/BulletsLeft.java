package org.academiadecodigo.proxymorons.Just_a_Dude.Logics.HUD;

import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Dude;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class BulletsLeft {
    private static int bulletsLeft = Dude.BULLETLIMIT;
    private static Text bulletsLeftText;

    public BulletsLeft(){
        bulletsLeftText = new Text(1100, 700,"BULLETS: " + getBulletsLeft());
        drawBulletsScore();

    }
    public static int getBulletsLeft() {
        return bulletsLeft;
    }

    public static void resetBulletsLeft() {
        bulletsLeft = Dude.BULLETLIMIT;
        bulletsLeftText.delete();
        bulletsLeftText = new Text(1100, 700,"BULLETS: " + getBulletsLeft());
        drawBulletsScore();
    }

    public static void drawBulletsScore(){
        bulletsLeftText.setColor(Color.WHITE);
        bulletsLeftText.grow(80,30);
        bulletsLeftText.draw();
    }

    public static void updateScore(){
        bulletsLeft--;
        bulletsLeftText.delete();
        bulletsLeftText = new Text(1100, 700,"BULLETS: " + getBulletsLeft());
        drawBulletsScore();
    }

    public static void setBulletsLeft(int bulletsLeft) {
        BulletsLeft.bulletsLeft = bulletsLeft;
    }
}
