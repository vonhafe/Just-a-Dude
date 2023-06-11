package org.academiadecodigo.proxymorons.Just_a_Dude.Characters;

public class Position {

    private int xAxis;
    private int yAxis;

    public Position(int x, int y){
       xAxis = x;
       yAxis = y;
    }

    public int getxAxis() {
        return xAxis;
    }

    public int getyAxis() {
        return yAxis;
    }

    public void setxAxis(int xAxis) {
        this.xAxis = xAxis;
    }

    public void setyAxis(int yAxis) {
        this.yAxis = yAxis;
    }

    @Override
    public String toString() {
        return "\nx: " + xAxis + "\ny: " + yAxis;
    }
}
