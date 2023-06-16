package org.academiadecodigo.proxymorons.Just_a_Dude.Characters;


import org.academiadecodigo.proxymorons.Just_a_Dude.Bullet;
import org.academiadecodigo.proxymorons.Just_a_Dude.Logics.Background;
import org.academiadecodigo.proxymorons.Just_a_Dude.Logics.Endscreen;
import org.academiadecodigo.proxymorons.Just_a_Dude.Logics.Game;
import org.academiadecodigo.proxymorons.Just_a_Dude.Logics.HUD.BulletsLeft;
import org.academiadecodigo.proxymorons.Just_a_Dude.Logics.HUD.HUD;
import org.academiadecodigo.proxymorons.Just_a_Dude.Logics.Music;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import static org.academiadecodigo.proxymorons.Just_a_Dude.Logics.Background.PADDING;

public class Dude extends Character implements Shooter {
    private int health = 100;
    public final static int SPEED = 5;
    public final static int DIAGONAL_SPEED = (int) (Math.sqrt((SPEED*SPEED)/2));
    public final static int BULLETLIMIT = 15;
    private int shots = 0;
    private boolean shooting;
    private long lastShootTime = System.currentTimeMillis();
    private int spriteChanger=4;

    public Dude(Position position) {
        super(position, Direction.UP, new Picture(position.getxAxis(), position.getyAxis(), "Assets/Dude/DudeStanding/Front (26x50).png"));
    }

    public void draw() {
        if (getSprite() != null) {
            getSprite().delete();
        }
        if (isDead()) {
            getSprite().draw();
            return;
        }

        switch (getDirection()) {
            case UP:
                if (isShooting()) {
                    setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeShooting/BackShooting/BackShooting1 (26x50).png"));
                } else {
                    if (spriteChanger%16==0||spriteChanger%16==1||spriteChanger%16==2||spriteChanger%16==3){
                        setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Back/Back1 (26x48).png"));
                       spriteChanger++;
                    } else if (spriteChanger%16==4||spriteChanger%16==5||spriteChanger%16==6||spriteChanger%16==7) {
                        setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Back/Back2 (26x50).png"));
                        spriteChanger++;
                    } else if (spriteChanger%16==8||spriteChanger%16==9||spriteChanger%16==10||spriteChanger%16==11) {
                        setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Back/Back3 (26x48).png"));
                        spriteChanger++;
                    }else{
                        setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Back/Back4 (26x50).png"));
                        spriteChanger++;
                    }
                    //setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Back/Back2 (26x50).png"));
                }
                getSprite().draw();
                break;
            case DOWN:
                if (isShooting()) {
                    setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeShooting/FrontShooting/FrontShooting1 (26x48).png"));
                } else {
                    if (spriteChanger%16==0||spriteChanger%16==1||spriteChanger%16==2||spriteChanger%16==3){
                        setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Front/Front1 (26x48).png"));
                        spriteChanger++;
                    } else if (spriteChanger%16==4||spriteChanger%16==5||spriteChanger%16==6||spriteChanger%16==7) {
                        setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Front/Front2 (26 x 50).png"));
                        spriteChanger++;
                    } else if (spriteChanger%16==8||spriteChanger%16==9||spriteChanger%16==10||spriteChanger%16==11) {
                        setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Front/Front3 (26x48).png"));
                        spriteChanger++;
                    }else{
                        setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Front/Front4 (26 x 50).png"));
                        spriteChanger++;
                    }
                }
                getSprite().draw();
                break;
            case LEFT:
                if (isShooting()) {
                    setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeShooting/LeftShooting/LeftShooting1 (36x48).png"));
                } else {
                    if (spriteChanger%16==0||spriteChanger%16==1||spriteChanger%16==2||spriteChanger%16==3){
                        setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Left/Left1 (24x48).png"));
                        spriteChanger++;
                    } else if (spriteChanger%16==4||spriteChanger%16==5||spriteChanger%16==6||spriteChanger%16==7) {
                        setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Left/Left2 (12x25).png"));
                        spriteChanger++;
                    } else if (spriteChanger%16==8||spriteChanger%16==9||spriteChanger%16==10||spriteChanger%16==11) {
                        setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Left/Left3 (12x24).png"));
                        spriteChanger++;
                    }else{
                        setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Left/Left4 (12x25).png"));
                        spriteChanger++;
                    }
                }
                getSprite().draw();
                break;
            case RIGHT:
                if (isShooting()) {
                    setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeShooting/RightShooting/RightShooting1 (36x48).png"));
                } else {
                    if (spriteChanger%16==0||spriteChanger%16==1||spriteChanger%16==2||spriteChanger%16==3){
                        setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Right/Right1 (24x48).png"));
                        spriteChanger++;
                    } else if (spriteChanger%16==4||spriteChanger%16==5||spriteChanger%16==6||spriteChanger%16==7) {
                        setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Right/Right2 (12x25).png"));
                        spriteChanger++;
                    } else if (spriteChanger%16==8||spriteChanger%16==9||spriteChanger%16==10||spriteChanger%16==11) {
                        setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Right/Right3 (12x24).png"));
                        spriteChanger++;
                    }else{
                        setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Right/Right4 (12x25).png"));
                        spriteChanger++;
                    }
                }
                getSprite().draw();
                break;
            case UP_LEFT:
                if (isShooting()) {
                    setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeShooting/BackShooting/BackShooting1 (26x50).png"));
                } else {
                    if (spriteChanger%16==0||spriteChanger%16==1||spriteChanger%16==2||spriteChanger%16==3){
                        setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Back/Back1 (26x48).png"));
                        spriteChanger++;
                    } else if (spriteChanger%16==4||spriteChanger%16==5||spriteChanger%16==6||spriteChanger%16==7) {
                        setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Back/Back2 (26x50).png"));
                        spriteChanger++;
                    } else if (spriteChanger%16==8||spriteChanger%16==9||spriteChanger%16==10||spriteChanger%16==11) {
                        setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Back/Back3 (26x48).png"));
                        spriteChanger++;
                    }else{
                        setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Back/Back4 (26x50).png"));
                        spriteChanger++;
                    }
                }
                getSprite().draw();
                break;
            case UP_RIGHT:
                if (isShooting()) {
                    setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeShooting/BackShooting/BackShooting1 (26x50).png"));
                } else {
                    if (spriteChanger%16==0||spriteChanger%16==1||spriteChanger%16==2||spriteChanger%16==3){
                        setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Back/Back1 (26x48).png"));
                        spriteChanger++;
                    } else if (spriteChanger%16==4||spriteChanger%16==5||spriteChanger%16==6||spriteChanger%16==7) {
                        setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Back/Back2 (26x50).png"));
                        spriteChanger++;
                    } else if (spriteChanger%16==8||spriteChanger%16==9||spriteChanger%16==10||spriteChanger%16==11) {
                        setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Back/Back3 (26x48).png"));
                        spriteChanger++;
                    }else{
                        setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Back/Back4 (26x50).png"));
                        spriteChanger++;
                    }
                }
                getSprite().draw();
                break;
            case DOWN_LEFT:
                if (isShooting()) {
                    setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeShooting/FrontShooting/FrontShooting1 (26x48).png"));
                } else {
                    if (spriteChanger%16==0||spriteChanger%16==1||spriteChanger%16==2||spriteChanger%16==3){
                        setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Front/Front1 (26x48).png"));
                        spriteChanger++;
                    } else if (spriteChanger%16==4||spriteChanger%16==5||spriteChanger%16==6||spriteChanger%16==7) {
                        setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Front/Front2 (26 x 50).png"));
                        spriteChanger++;
                    } else if (spriteChanger%16==8||spriteChanger%16==9||spriteChanger%16==10||spriteChanger%16==11) {
                        setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Front/Front3 (26x48).png"));
                        spriteChanger++;
                    }else{
                        setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Front/Front4 (26 x 50).png"));
                        spriteChanger++;
                    }
                }
                getSprite().draw();
                break;
            case DOWN_RIGHT:
                if (isShooting()) {
                    setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeShooting/FrontShooting/FrontShooting1 (26x48).png"));
                } else {
                    if (spriteChanger%16==0||spriteChanger%16==1||spriteChanger%16==2||spriteChanger%16==3){
                        setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Front/Front1 (26x48).png"));
                        spriteChanger++;
                    } else if (spriteChanger%16==4||spriteChanger%16==5||spriteChanger%16==6||spriteChanger%16==7) {
                        setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Front/Front2 (26 x 50).png"));
                        spriteChanger++;
                    } else if (spriteChanger%16==8||spriteChanger%16==9||spriteChanger%16==10||spriteChanger%16==11) {
                        setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Front/Front3 (26x48).png"));
                        spriteChanger++;
                    }else{
                        setSprite(new Picture(getPosition().getxAxis(), getPosition().getyAxis(), "Assets/Dude/DudeWalking/Front/Front4 (26 x 50).png"));
                        spriteChanger++;
                    }
                }
                getSprite().draw();
                break;
        }

    }


    public void move(Direction direction) {
        switch (direction) {
            case UP:
                if (getPosition().getyAxis() - SPEED > PADDING) {
                    setDirection(Direction.UP);
                    draw();
                    getSprite().translate(0, -SPEED);
                    getPosition().setyAxis(getPosition().getyAxis() - SPEED);
                } else {
                    setDirection(Direction.DOWN);
                    getSprite().translate(0, -getSprite().getY() + PADDING);
                    getPosition().setyAxis(PADDING);
                }
                break;
            case RIGHT:
                if (getPosition().getxAxis() + SPEED < PADDING + Background.getWidth() - getSprite().getWidth()) {
                    setDirection(Direction.RIGHT);
                    draw();
                    getSprite().translate(SPEED, 0);
                    getPosition().setxAxis(getPosition().getxAxis() + SPEED);
                } else {
                    setDirection(Direction.LEFT);
                    getSprite().translate(Background.getWidth() - (getSprite().getX() - PADDING) - getSprite().getWidth(), 0);
                    getPosition().setxAxis(PADDING + Background.getWidth() - getSprite().getWidth());
                }
                break;
            case DOWN:
                if (getPosition().getyAxis() + SPEED < PADDING + Background.getHeight() - getSprite().getHeight()) {
                    setDirection(Direction.DOWN);
                    draw();
                    getSprite().translate(0, SPEED);
                    getPosition().setyAxis(getPosition().getyAxis() + SPEED);
                } else {
                    setDirection(Direction.UP);
                    getSprite().translate(0, Background.getHeight() - (getSprite().getY() - PADDING) - getSprite().getHeight());
                    getPosition().setyAxis(PADDING + Background.getHeight() - getSprite().getHeight());
                }
                break;
            case LEFT:
                if (getPosition().getxAxis() - SPEED > PADDING) {
                    setDirection(Direction.LEFT);
                    draw();
                    getSprite().translate(-SPEED, 0);
                    getPosition().setxAxis(getPosition().getxAxis() - SPEED);
                } else {
                    setDirection(Direction.RIGHT);
                    getSprite().translate(-getSprite().getX() + PADDING, 0);
                    getPosition().setxAxis(PADDING);
                }
                break;
            case UP_LEFT:
                if (getPosition().getyAxis() - DIAGONAL_SPEED > PADDING && getPosition().getxAxis() - DIAGONAL_SPEED > PADDING) {
                    setDirection(Direction.UP_LEFT);
                    draw();
                    getSprite().translate(-DIAGONAL_SPEED, -DIAGONAL_SPEED);
                    getPosition().setyAxis(getPosition().getyAxis() - DIAGONAL_SPEED);
                    getPosition().setxAxis(getPosition().getxAxis() - DIAGONAL_SPEED);
                } else {
                    getSprite().translate(0,0);
                }
                break;
            case UP_RIGHT:
                if (getPosition().getyAxis() - DIAGONAL_SPEED > PADDING && getPosition().getxAxis() + SPEED < PADDING + Background.getWidth() - getSprite().getWidth()) {
                    setDirection(Direction.UP_RIGHT);
                    draw();
                    getSprite().translate(DIAGONAL_SPEED, -DIAGONAL_SPEED);
                    getPosition().setyAxis(getPosition().getyAxis() - DIAGONAL_SPEED);
                    getPosition().setxAxis(getPosition().getxAxis() + DIAGONAL_SPEED);
                } else {
                    getSprite().translate(0,0);
                }
                break;
            case DOWN_LEFT:
                if (getPosition().getyAxis() + DIAGONAL_SPEED < PADDING + Background.getHeight() - getSprite().getHeight() && getPosition().getxAxis() - SPEED > PADDING) {
                    setDirection(Direction.DOWN_LEFT);
                    draw();
                    getSprite().translate(-DIAGONAL_SPEED, DIAGONAL_SPEED);
                    getPosition().setyAxis(getPosition().getyAxis() + DIAGONAL_SPEED);
                    getPosition().setxAxis(getPosition().getxAxis() - DIAGONAL_SPEED);
                } else {
                    getSprite().translate(0,0);
                }
                break;
            case DOWN_RIGHT:
                if (getPosition().getyAxis() + SPEED < PADDING + Background.getHeight() - getSprite().getHeight() && getPosition().getxAxis() + SPEED < PADDING + Background.getWidth() - getSprite().getWidth()) {
                    setDirection(Direction.DOWN_RIGHT);
                    draw();
                    getSprite().translate(DIAGONAL_SPEED, DIAGONAL_SPEED);
                    getPosition().setyAxis(getPosition().getyAxis() + DIAGONAL_SPEED);
                    getPosition().setxAxis(getPosition().getxAxis() + DIAGONAL_SPEED);
                } else {
                    getSprite().translate(0,0);
                }
                break;
            default:
                break;
        }
    }

    public void shoot() {
        if(shots == BULLETLIMIT){
            return;
        }
        if (shots == BULLETLIMIT - 1){
            HUD.reloadDraw();
        }
        setShooting(true);
        draw();
        int x = ((getSprite().getX() + (getSprite().getX() + getSprite().getWidth())) / 2);
        int y = ((getSprite().getY() + (getSprite().getY() + getSprite().getHeight())) / 2);
        Picture bulletSprite = new Picture();
        switch (getDirection()) {
            case DOWN:
                Picture down = new Picture(x-2, y+20, "Assets/Bullet/BulletDown (6x8).png");
                bulletSprite = down;
                break;
            case UP:
                Picture up = new Picture(x-2, y-30, "Assets/Bullet/BulletFront (6x8).png");
                bulletSprite = up;
                break;
            case LEFT:
                Picture left = new Picture(x-20, y-2, "Assets/Bullet/BulletLeft (8x6).png");
                bulletSprite = left;
                break;
            case RIGHT:
                Picture right = new Picture(x+20, y-2, "Assets/Bullet/BulletRight (8x6).png");
                bulletSprite = right;
                break;
            case UP_LEFT:
            case UP_RIGHT:
                Picture ups = new Picture(x, y, "Assets/Bullet/BulletFront (6x8).png");
                bulletSprite = ups;
                break;
            case DOWN_LEFT:
            case DOWN_RIGHT:
                Picture downs = new Picture(x, y, "Assets/Bullet/BulletDown (6x8).png");
                bulletSprite = downs;
                break;


        }
        bulletSprite.draw();
        Position tempPos = new Position(x, y);
        Bullet bullet = new Bullet(bulletSprite, getDirection(), tempPos);
        Game.bullets.add(bullet);
        shots++;
        BulletsLeft.updateScore();
        setShooting(false);
        //sound effect
        String filepath = "Assets/Sound/shoot.wav";
        Music music = new Music();
        music.clipSound(filepath);
    }

    public void reload() {
        shots = 0;
        HUD.resetReload();
        BulletsLeft.resetBulletsLeft();
    }
    public Position[] getHitBox() {
        return super.getHitBox();
    }

    public void hit(){
        if (!isDead()) {
            this.health--;
            if (health <= 0) {
                health = 0;
                setDead(true);
                Game.gameover=true;
                Endscreen.start();
                Game.clean();
            }
        }
    }

    @Override
    public void setDead(boolean dead) {
        super.setDead(dead);
        getSprite().delete();
        setSprite(new Picture(getSprite().getX(), getSprite().getY() + 34, "Assets/Dude/DudeDeath/Death (42x16).png"));
        draw();
    }

    public void heal(){
        if (health+20<100) {
            health += 20;
        }else {
            health=100;
        }
    }

    public int getHealth() {
        return health;
    }


    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isShooting() {
        return shooting;
    }

    public void setShooting(boolean shooting) {
        this.shooting = shooting;
    }


    public long getLastShootTime() {
        return lastShootTime;
    }

    public void setLastShootTime(long lastShootTime) {
        this.lastShootTime = lastShootTime;
    }

    public void reset(){
        setHealth(100);
        setDead(false);
        setPosition(new Position(Background.getWidth() / 2, Background.getHeight() / 2));
        setDirection(Direction.DOWN);
        draw();
        shots = 0;
    }

}
