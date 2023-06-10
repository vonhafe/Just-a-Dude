package org.academiadecodigo.proxymorons.Just_a_Dude;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Bullet {
    private Rectangle bulletSprite;

    public Bullet(Rectangle bulletSprite){
        this.bulletSprite=bulletSprite;
    }
    public void move(){
        bulletSprite.translate(1,0);
    }
}
