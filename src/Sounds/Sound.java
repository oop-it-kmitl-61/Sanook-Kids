/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sounds;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

/**
 *
 * @author Husna
 */
public class Sound {
    public static void main(String[] args){
        Sound("D:\\IT-KMITL\\OOP Project -61\\img\\Sounds/mario-s-way.mp3");
  
        
        
 }
   public static void Sound(String filepath){
        try {
            AudioData data = new AudioStream(new FileInputStream(filepath)).getData();
            ContinuousAudioDataStream sound = new ContinuousAudioDataStream(data);
            AudioPlayer.player.start(sound);
        } catch (IOException ex) {
            Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
        }
        }     
        
    
    
    
    
}
