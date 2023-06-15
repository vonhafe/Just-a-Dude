package org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Enemy;

import org.academiadecodigo.proxymorons.Just_a_Dude.Bullet;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Direction;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Dude;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Position;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Shooter;
import org.academiadecodigo.proxymorons.Just_a_Dude.Logics.Game;
import org.academiadecodigo.proxymorons.Just_a_Dude.Logics.Music;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class ShooterEnemy extends Enemy implements Shooter {

    private boolean shooting;
    public ShooterEnemy(Position position, Direction direction) {
        super(position,direction,new Picture(position.getxAxis(), position.getyAxis(), "Assets/Enemy/Standing/Front (22x50).png"));
    }

    @Override
    public void move(Direction direction) {

    }
    public void shootChance(){
        int Chance = (int) (Math.random()*1000);
        if (Chance > 950){
            shoot();
        }
    }
    public void shoot(){
        setShooting(true);
        draw();
        int x = ((getSprite().getX() + (getSprite().getX() + getSprite().getWidth()))/2);
        int y = ((getSprite().getY() + (getSprite().getY() + getSprite().getHeight()))/2);
        Picture bulletSprite = new Picture();
        switch (getDirection()) {
            case DOWN:
                Picture down = new Picture(x, y, "Assets/Bullet/BulletDown (6x8).png");
                bulletSprite = down;
                break;
            case UP:
                Picture up = new Picture(x, y, "Assets/Bullet/BulletFront (6x8).png");
                bulletSprite = up;
                break;
            case LEFT:
                Picture left = new Picture(x, y, "Assets/Bullet/BulletLeft (8x6).png");
                bulletSprite = left;
                break;
            case RIGHT:
                Picture right = new Picture(x, y, "Assets/Bullet/BulletRight (8x6).png");
                bulletSprite = right;
                break;
        }

        bulletSprite.draw();
        Position tempPos = new Position(x, y);
        Bullet bullet = new Bullet(bulletSprite, getDirection(), tempPos);
        Game.enemyBullets.add(bullet);
        setShooting(false);
        //sound effect
        //String filepath = "Assets/Sound/shoot.wav";
        //Music music = new Music();
        //music.clipSound(filepath);
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
                setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/ShooterEnemy/SkeletonFront.png"));
                getSprite().draw();
                break;
            case DOWN:
                setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/ShooterEnemy/SkeletonBack.png"));
                getSprite().draw();
                break;
            case LEFT:
                setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/ShooterEnemy/SkeletonLeft.png"));
                getSprite().draw();
                break;
            case RIGHT:
                setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/ShooterEnemy/SkeletonRight.png"));
                getSprite().draw();
                break;
        }

    }

    @Override
    public void setShooting(boolean shooting) {
        this.shooting=shooting;
    }

    @Override
    public void hit() {

    }
}
