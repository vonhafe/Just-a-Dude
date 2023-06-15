package org.academiadecodigo.proxymorons.Just_a_Dude.Logics;

import org.academiadecodigo.proxymorons.Just_a_Dude.Characters.Dude;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Music {
    private Clip clip;


    public void backgroundMusic(String filepath) {
        try {
            File musicFile = new File(filepath);
            if (musicFile.exists()) {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(musicFile);
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);

                // Set the loop points to loop the entire audio
                clip.setLoopPoints(0, -1);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                System.out.println("Can't find file");
            }
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }

    public void clipSound(String filepath) {
        try {
            File musicFile = new File(filepath);

            if (musicFile.exists()) {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(musicFile);
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();

            } else {
                System.out.println("Can't find file");
            }
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }

    public void stopMusic(String filepath) {
        if (clip != null && clip.isRunning()) {
            //clip.flush();
            clip.stop();
            clip.close();
        }
    }

}