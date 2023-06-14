package org.academiadecodigo.proxymorons.Just_a_Dude.Inputs;

import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Direction;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Dude;
import org.academiadecodigo.proxymorons.Just_a_Dude.Logics.Game;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.HashSet;
import java.util.Set;

public class MyKeyboardHandler implements KeyboardHandler {
    private Keyboard keyboard;
    private Dude dude;
    public final static long SHOOT_DELAY = 200;
    private long lastShootTime = System.currentTimeMillis();
    private Set<Integer> pressedKeys = new HashSet<>();

    public MyKeyboardHandler(Dude dude) {
        this.dude = dude;
    }

    public void init() {
        keyboard = new Keyboard(this);

        KeyboardEvent k1 = new KeyboardEvent();
        k1.setKey(KeyboardEvent.KEY_A);
        k1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(k1);

        KeyboardEvent k2 = new KeyboardEvent();
        k2.setKey(KeyboardEvent.KEY_D);
        k2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(k2);

        KeyboardEvent k3 = new KeyboardEvent();
        k3.setKey(KeyboardEvent.KEY_W);
        k3.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(k3);

        KeyboardEvent k4 = new KeyboardEvent();
        k4.setKey(KeyboardEvent.KEY_S);
        k4.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(k4);

        KeyboardEvent k5 = new KeyboardEvent();
        k5.setKey(KeyboardEvent.KEY_SPACE);
        k5.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(k5);

        KeyboardEvent k6 = new KeyboardEvent();
        k6.setKey(KeyboardEvent.KEY_R);
        k6.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(k6);

        KeyboardEvent k7Release = new KeyboardEvent();
        k7Release.setKey(KeyboardEvent.KEY_A);
        k7Release.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(k7Release);

        KeyboardEvent k8Release = new KeyboardEvent();
        k8Release.setKey(KeyboardEvent.KEY_D);
        k8Release.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(k8Release);

        KeyboardEvent k9Release = new KeyboardEvent();
        k9Release.setKey(KeyboardEvent.KEY_W);
        k9Release.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(k9Release);

        KeyboardEvent k10Release = new KeyboardEvent();
        k10Release.setKey(KeyboardEvent.KEY_S);
        k10Release.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(k10Release);

        KeyboardEvent k11Release = new KeyboardEvent();
        k11Release.setKey(KeyboardEvent.KEY_SPACE);
        k11Release.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(k11Release);

        KeyboardEvent k12Release = new KeyboardEvent();
        k12Release.setKey(KeyboardEvent.KEY_R);
        k12Release.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(k12Release);


    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (Game.isStarted()){
            if (!dude.isDead()) {
                pressedKeys.add(keyboardEvent.getKey());

                handleMovement();

                if (pressedKeys.contains(KeyboardEvent.KEY_SPACE)) {
                    // Check if enough time has passed since the last shoot
                    if (System.currentTimeMillis() - dude.getLastShootTime() >= SHOOT_DELAY) {
                        dude.shoot();
                        dude.setLastShootTime(System.currentTimeMillis());
                    }
                }
                if (pressedKeys.contains(KeyboardEvent.KEY_R)) {
                    dude.reload();
                }
            }
        }
    }
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        pressedKeys.remove(keyboardEvent.getKey());
    }

    private void handleMovement() {
        // Determine movement direction based on the combination of keys pressed
        Direction direction = Direction.NONE;
        if (pressedKeys.contains(KeyboardEvent.KEY_A) && pressedKeys.contains(KeyboardEvent.KEY_W)) {
            direction = Direction.UP_LEFT;
        } else if (pressedKeys.contains(KeyboardEvent.KEY_D) && pressedKeys.contains(KeyboardEvent.KEY_W)) {
            direction = Direction.UP_RIGHT;
        } else if (pressedKeys.contains(KeyboardEvent.KEY_A) && pressedKeys.contains(KeyboardEvent.KEY_S)) {
            direction = Direction.DOWN_LEFT;
        } else if (pressedKeys.contains(KeyboardEvent.KEY_D) && pressedKeys.contains(KeyboardEvent.KEY_S)) {
            direction = Direction.DOWN_RIGHT;
        } else if (pressedKeys.contains(KeyboardEvent.KEY_A)) {
            direction = Direction.LEFT;
        } else if (pressedKeys.contains(KeyboardEvent.KEY_D)) {
            direction = Direction.RIGHT;
        } else if (pressedKeys.contains(KeyboardEvent.KEY_W)) {
            direction = Direction.UP;
        } else if (pressedKeys.contains(KeyboardEvent.KEY_S)) {
            direction = Direction.DOWN;
        }

        // Move the Dude based on the determined direction
        dude.move(direction);
    }

}
