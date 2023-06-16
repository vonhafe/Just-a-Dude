package org.academiadecodigo.proxymorons.Just_a_Dude.Logics;

import org.academiadecodigo.proxymorons.Just_a_Dude.Inputs.ResourceHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Endscreen {
    public final static int PADDING =10;
    public final static Picture canvas = new Picture(PADDING, PADDING, ResourceHandler.PREFIX+"Endscreen2.png");


    public static void start() {
        canvas.draw();
    }
    public void hide(){
        canvas.delete();
    }
}
