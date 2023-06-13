package org.academiadecodigo.proxymorons.Just_a_Dude.Inputs;

import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Dude;
import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Position;
import org.academiadecodigo.proxymorons.Just_a_Dude.Logics.Game;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class MyMouseHandler implements MouseHandler {
    private Mouse mouse;
    private Game game;


    public MyMouseHandler(Game game){
        this.game=game;

    }

    public void init(){
        mouse=new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
    }
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        //System.out.println("Someone clicked with the mouse!");
        //System.out.println("They clicked at " + mouseEvent.getX() + " x coordinate");
        //System.out.println("They clicked at " + mouseEvent.getY() + " y coordinate");
        if (!game.isGameover()){
            game.setStarted(true);
        } else {
            game.start();
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
