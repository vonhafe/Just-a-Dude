package org.academiadecodigo.proxymorons.Just_a_Dude.Logics;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Startscreen {
    public final static int PADDING =10;
    public final static Picture canvas = new Picture(PADDING, PADDING, "Assets/End-screen/Startscreen.png");


    public void start() {
        canvas.draw();
    }
    public void hide(){
        canvas.delete();
    }
}
