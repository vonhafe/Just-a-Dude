package org.academiadecodigo.proxymorons.Just_a_Dude.Logics.HUD;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Score {
    private int roundNumber = 1;
    private int score = 0;
    private Text roundText;
    private Text scoreText;

    public Score(){
        roundText = new Text(640,40, "ROUND #"+ getRoundNumber());
        drawRound();
        scoreText = new Text(1100, 40,"ENEMIES KILLED: " + getScore());
        drawScore();
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public int getScore() {
        return score;
    }

    public void drawRound(){
        roundText.setColor(Color.WHITE);
        roundText.grow(80, 30);
        roundText.draw();

    }

    public void drawScore(){
        scoreText.setColor(Color.WHITE);
        scoreText.grow(115, 30);
        scoreText.draw();
    }

    public void updateRound(){
        roundNumber++;
        roundText.delete();
        roundText = new Text(640,40, "ROUND #"+ getRoundNumber());
        drawRound();
    }

    public void updateScore(){
        score++;
        scoreText.delete();
        scoreText = new Text(1100, 40,"ENEMIES KILLED: " + getScore());
        drawScore();
    }
}
