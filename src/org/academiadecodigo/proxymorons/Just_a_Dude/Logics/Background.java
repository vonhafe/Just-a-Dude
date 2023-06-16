package org.academiadecodigo.proxymorons.Just_a_Dude.Logics;

import org.academiadecodigo.proxymorons.Just_a_Dude.Inputs.ResourceHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {
    public final static int PADDING =10;
    public final static Picture canvas = new Picture(PADDING, PADDING, ResourceHandler.PREFIX+"mainlevbuild.png");


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
