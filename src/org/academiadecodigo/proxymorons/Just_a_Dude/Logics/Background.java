package org.academiadecodigo.proxymorons.Just_a_Dude.Logics;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Background {
    public final static int PADDING =10;
    public final static Rectangle canvas = new Rectangle(PADDING, PADDING, 1280, 720);


    public void start() {
        canvas.draw();
    }

    public static int getHeight(){
        return canvas.getHeight();
    }

    public static int getWidth(){
        return canvas.getWidth();
    }
}
