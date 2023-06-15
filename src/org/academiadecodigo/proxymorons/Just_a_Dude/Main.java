package org.academiadecodigo.proxymorons.Just_a_Dude;

import org.academiadecodigo.proxymorons.Just_a_Dude.Logics.Game;
import org.academiadecodigo.proxymorons.Just_a_Dude.Logics.Music;
import org.academiadecodigo.simplegraphics.graphics.Canvas;

public class Main {
    public static void main(String[] args) {
        Canvas.setMaxY(730);
        Canvas.setMaxX(1290);
        Game game = new Game();
        game.start();
    }
}
