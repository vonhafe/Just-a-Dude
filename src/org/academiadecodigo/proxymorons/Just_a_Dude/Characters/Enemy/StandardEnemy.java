package org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Enemy;

import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Direction;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class StandardEnemy extends Enemy{


    public StandardEnemy(Position position, Direction direction) {
        super(position,direction, new Picture(position.getxAxis(), position.getyAxis(), "Assets/Enemy/Standing/Front (22x50).png"));
        draw();
        //setDirection(direction());
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

    /*
        public Direction getDirection() {
            return direction;
        }


        public Position getPosition() {
            return position;
        }

        public void setPosition(Position position) {
            this.position = position;
        }
        */
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


    /*
    public void forward(){
        //System.out.println(this.getDirection());
        if (this.getDirection().equals(Direction.UP)){
            this.getPosition().setyAxis(this.getPosition().getyAxis()-10);
            super.
        } else if (this.getDirection().equals(Direction.RIGHT)) {
            this.getPosition().setxAxis(this.getPosition().getxAxis()+10);
        } else if (this.getDirection().equals(Direction.LEFT)) {
            this.getPosition().setxAxis(this.getPosition().getxAxis()-10);
        }else if (this.getDirection().equals(Direction.DOWN)) {
            this.getPosition().setyAxis(this.getPosition().getyAxis()+10);
        }
    }

    public Direction left(){
        if (this.getDirection().equals(Direction.UP)){
            this.getPosition().setxAxis(this.getPosition().getxAxis()-10);
            return Direction.LEFT;
        } else if (this.getDirection().equals(Direction.RIGHT)) {
            this.getPosition().setyAxis(this.getPosition().getyAxis()-10);
            return Direction.UP;
        } else if (this.getDirection().equals(Direction.LEFT)) {
            this.getPosition().setyAxis(this.getPosition().getyAxis()+10);
            return Direction.DOWN;
        }else  {//"down"
            this.getPosition().setxAxis(this.getPosition().getxAxis()+10);
            return Direction.RIGHT;
        }
    }

    public Direction right(){
        if (this.getDirection().equals(Direction.UP)){
            this.getPosition().setxAxis(this.getPosition().getxAxis()+10);
            return Direction.RIGHT;
        } else if (this.getDirection().equals(Direction.RIGHT)) {
            this.getPosition().setyAxis(this.getPosition().getyAxis()+10);
            return Direction.DOWN;
        } else if (this.getDirection().equals(Direction.LEFT)) {
            this.getPosition().setyAxis(this.getPosition().getyAxis()-10);
            return Direction.UP;
        }else {//down
            this.getPosition().setxAxis(this.getPosition().getxAxis()-10);
            return Direction.LEFT;
        }
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
*/
}
