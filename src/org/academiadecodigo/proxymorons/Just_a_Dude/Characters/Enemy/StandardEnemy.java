package org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Enemy;

import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Direction;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class StandardEnemy extends Enemy{


    public StandardEnemy(Position position, Direction direction) {
        super(position,direction, new Picture(position.getxAxis(), position.getyAxis(), "Assets/Enemy/Standing/Front (22x50).png"));
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
                setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Enemy/Standing/Back (22x50).png"));
                getSprite().draw();
                break;
            case DOWN:
                setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Enemy/Standing/Front (22x50).png"));
                getSprite().draw();
                break;
            case LEFT:
                setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Enemy/Standing/Left (28x50).png"));
                getSprite().draw();
                break;
            case RIGHT:
                setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Enemy/Standing/Right (28x50).png"));
                getSprite().draw();
                break;
        }

    }
}
