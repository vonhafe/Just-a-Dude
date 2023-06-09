package org.academiadecodigo.proxymorons.Just_a_Dude.Logics;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Background {
    private Rectangle canvas = new Rectangle(PADDING, PADDING, 1280, 720);
    public final static int PADDING =10;


    public void start() {
        canvas.draw();
    }

    public int getHeight(){
        return canvas.getHeight();
    }

    public int getWidth(){
        return canvas.getWidth();
    }
}
