/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sounds;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Husna
 */
public class CorrectSound {
    public static void main(String[] args){
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream audio = AudioSystem.getAudioInputStream(CorrectSound.class.getResourceAsStream("/correct-answer.wav"));
            clip.open(audio);
            clip.start();
            Thread.sleep(1000);
            clip.close();
            
        } catch (Exception ex) {
            Logger.getLogger(CorrectSound.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
