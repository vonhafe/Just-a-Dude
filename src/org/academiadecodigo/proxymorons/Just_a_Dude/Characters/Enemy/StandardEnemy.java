package org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Enemy;

import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Direction;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Position;
import org.academiadecodigo.proxymorons.Just_a_Dude.Inputs.ResourceHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class StandardEnemy extends Enemy{


    public StandardEnemy(Position position, Direction direction) {
        super(position,direction, new Picture(position.getxAxis(), position.getyAxis(), ResourceHandler.PREFIX+"ZombieFront.png"));
        draw();
    }


    @Override
    public void move(Direction direction) {
    }

    @Override
    public void hit() {

    }

    @Override
    public void setDirection(Direction direction) {
        super.setDirection(direction);
        draw();
    }


    public void draw() {
        if (getSprite() != null){
            getSprite().delete();
        }
        if (isDead()){
            getSprite().draw();
            return;
        }

        switch (getDirection()) {
            case UP:
                setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), ResourceHandler.PREFIX+"ZombieBack.png"));
                getSprite().draw();
                break;
            case DOWN:
                setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), ResourceHandler.PREFIX+"ZombieFront.png"));
                getSprite().draw();
                break;
            case LEFT:
                setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), ResourceHandler.PREFIX+"ZombieLeft.png"));
                getSprite().draw();
                break;
            case RIGHT:
                setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), ResourceHandler.PREFIX+"ZombieRight.png"));
                getSprite().draw();
                break;
        }

    }
}
