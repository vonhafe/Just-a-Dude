package org.academiadecodigo.proxymorons.Just_a_Dude.Logics;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Music {

    public void clipSound(String filepath) {
        try {
            File musicPath = new File(filepath);

            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                //clip.loop(Clip.LOOP_CONTINUOUSLY);
                //JOptionPane.showMessageDialog(null, "Press OK to stop playing");
            } else {
                System.out.println("Can't find file");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void backgroundMusic(String filepath) {
        try {
            File musicPath = new File(filepath);

            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                //JOptionPane.showMessageDialog(null, "Press OK to stop playing");
            } else {
                System.out.println("Can't find file");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
