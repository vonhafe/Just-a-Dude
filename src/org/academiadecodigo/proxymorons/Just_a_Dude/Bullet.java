package org.academiadecodigo.proxymorons.Just_a_Dude;

import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Direction;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Entity;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Bullet extends Entity {
    private Rectangle bulletSprite;
    private boolean connected;

    public Bullet(Rectangle bulletSprite){
        this.bulletSprite=bulletSprite;
    }
    public void move(){
        bulletSprite.translate(1,0);
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    @Override
    public void move(Direction direction) {

    }

    @Override
    public void hit() {

    }
}
