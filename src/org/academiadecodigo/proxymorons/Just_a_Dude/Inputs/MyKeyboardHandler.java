package org.academiadecodigo.proxymorons.Just_a_Dude.Inputs;

import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Direction;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Dude;
import org.academiadecodigo.proxymorons.Just_a_Dude.Logics.Game;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class MyKeyboardHandler implements KeyboardHandler {
    private Keyboard keyboard;
    private Dude dude;
    public final static long SHOOT_DELAY = 200;
    private long lastShootTime = System.currentTimeMillis();

    public MyKeyboardHandler(Dude dude) {
        this.dude = dude;
    }

    public void init() {
        keyboard = new Keyboard(this);

        KeyboardEvent k1 = new KeyboardEvent();
        k1.setKey(KeyboardEvent.KEY_A);
        k1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent k2 = new KeyboardEvent();
        k2.setKey(KeyboardEvent.KEY_D);
        k2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent k3 = new KeyboardEvent();
        k3.setKey(KeyboardEvent.KEY_W);
        k3.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent k4 = new KeyboardEvent();
        k4.setKey(KeyboardEvent.KEY_S);
        k4.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent k5 = new KeyboardEvent();
        k5.setKey(KeyboardEvent.KEY_SPACE);
        k5.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent k6 = new KeyboardEvent();
        k6.setKey(KeyboardEvent.KEY_R);
        k6.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


        keyboard.addEventListener(k1);
        keyboard.addEventListener(k2);
        keyboard.addEventListener(k3);
        keyboard.addEventListener(k4);
        keyboard.addEventListener(k5);
        keyboard.addEventListener(k6);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (!dude.isDead()) {
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_A) {
                dude.move(Direction.LEFT);
            }
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_D) {
                dude.move(Direction.RIGHT);
            }
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_W) {
                dude.move(Direction.UP);
            }
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_S) {
                dude.move(Direction.DOWN);
            }
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
                // Check if enough time has passed since the last shoot
                if (System.currentTimeMillis() - dude.getLastShootTime() >= SHOOT_DELAY) {
                    dude.shoot();
                    dude.setLastShootTime(System.currentTimeMillis());
                }
            }
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_R) {
                dude.reload();
            }
        }
    }
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }


}
