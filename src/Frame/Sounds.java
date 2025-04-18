
package Frame;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class Sounds {
    private boolean isMusicLoop1Playing = false;
    private boolean isMusicLoop2Playing = false;
    private boolean isMusicLoop3Playing = false;
    private boolean isMusicLoop4Playing = false;
    private boolean isMusicLoop5Playing = false;
    
    private Clip clip1;
    private Clip clip2;
    private Clip clip3;
    private Clip clip4;
    private Clip clip5;
    private Clip clip6;

    
     public void playSound(Clip clip) {
        // Play the audio clip
        
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("slide.wav"));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        if (clip != null) {
            clip.setFramePosition(0); // Rewind to the beginning
            clip.start();
        }
    }
     
     
      public void playSound2(Clip clip2) {
        // Play the audio clip
        
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Click.wav"));
            clip2 = AudioSystem.getClip();
            clip2.open(audioInputStream);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        if (clip2 != null) {
            clip2.setFramePosition(0); // Rewind to the beginning
            clip2.start();
        }
    }
      
      
      
 
 public void playSound3(Clip clip3) {
        // Play the audio clip
        
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("pop.wav"));
            clip3 = AudioSystem.getClip();
            clip3.open(audioInputStream);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        if (clip3 != null) {
            clip3.setFramePosition(0); // Rewind to the beginning
            clip3.start();
        }
    }
 
 public void playSound4(Clip clip4) {
        // Play the audio clip
        
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("error.wav"));
            clip4 = AudioSystem.getClip();
            clip4.open(audioInputStream);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        if (clip4 != null) {
            clip4.setFramePosition(0); // Rewind to the beginning
            clip4.start();
        }
    }
 
 public void playSound5(Clip clip5) {
        // Play the audio clip
        
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("minecraftlevel.wav"));
            clip5 = AudioSystem.getClip();
            clip5.open(audioInputStream);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        if (clip5 != null) {
            clip5.setFramePosition(0); // Rewind to the beginning
            clip5.start();
        }
    }
 

    public void playMusicLoop1() {
        try {
            String musicFilePath = "schaleBGM.wav";
            float volume = -18.0f;

            clip1 = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(musicFilePath));
            clip1.open(inputStream);

            // Get the GainControl object associated with the Clip
            FloatControl gainControl = (FloatControl) clip1.getControl(FloatControl.Type.MASTER_GAIN);

            // Set the volume using the specified gain value
            gainControl.setValue(volume);

            isMusicLoop1Playing = true;
            
            clip1.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
    }
    


    public void stopMusic1() {
        if (clip1 != null && clip1.isRunning()) {
            clip1.stop(); 
            isMusicLoop1Playing = false;
        }
        
    }
    
  public void startMusic1() {
    if (clip1 != null && !clip1.isRunning()) {
        if (clip1.getMicrosecondPosition() >= clip1.getMicrosecondLength()) {
            // If clip is at the end, rewind to start
            clip1.setMicrosecondPosition(0);
        }
        clip1.loop(Clip.LOOP_CONTINUOUSLY); // Ensure looping behavior is applied
        clip1.start();
    }
}
    
    
     
     //    
//    
//    public void stopMusic1() {
//        if (clip1 != null) {
//            FloatControl gainControl = (FloatControl) clip1.getControl(FloatControl.Type.MASTER_GAIN);
//            gainControl.setValue(-80.0f);
//        }
//        
//    }
//    
//     public void startMusic1() {
//       if (clip1 != null) {
//            FloatControl gainControl = (FloatControl) clip1.getControl(FloatControl.Type.MASTER_GAIN);
//            gainControl.setValue(-18.0f);
//        }
//    
//    }  
     
     
//            clip1.addLineListener(new LineListener() {
//            @Override
//            public void update(LineEvent event) {
//                if (event.getType() == LineEvent.Type.STOP) {
//                    // When the music ends, play it again (loop)
//                    playMusicLoop1();
//                }
//            }
//        }); 
     
    
     
     public void playMusicLoop2() {
        try {
            String musicFilePath = "aru terror.wav";
            float volume = -17.0f;

            clip2 = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(musicFilePath));
            clip2.open(inputStream);

            // Get the GainControl object associated with the Clip
            FloatControl gainControl = (FloatControl) clip2.getControl(FloatControl.Type.MASTER_GAIN);

            // Set the volume using the specified gain value
            gainControl.setValue(volume);
            
            isMusicLoop2Playing = true;

            clip2.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
    }
  
     
     public void stopMusic2() {
        if (clip2 != null && clip2.isRunning()) {
            clip2.stop();
            isMusicLoop2Playing = false;
        }
    }
    
     public void startMusic2() {
        if (clip2 != null && !clip2.isRunning()) {
            clip2.start();
        }
    }
     
     
     public void playMusicLoop3() {
        try {
            String musicFilePath = "schaleBGM2.wav";
            float volume = -18.0f;

            clip3 = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(musicFilePath));
            clip3.open(inputStream);

            // Get the GainControl object associated with the Clip
            FloatControl gainControl = (FloatControl) clip3.getControl(FloatControl.Type.MASTER_GAIN);

            // Set the volume using the specified gain value
            gainControl.setValue(volume);
            
            isMusicLoop3Playing = true;

            clip3.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
    }
  
     
     public void stopMusic3() {
        if (clip3 != null && clip3.isRunning()) {
            clip3.stop();
            isMusicLoop3Playing = false;
        }
    }
    
     public void startMusic3() {
        if (clip3 != null && !clip3.isRunning()) {
            clip3.start();
        }
    }
     
     public void playMusicLoop4() {
        try {
            String musicFilePath = "schaleBGM3.wav";
            float volume = -18.0f;

            clip4 = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(musicFilePath));
            clip4.open(inputStream);

            // Get the GainControl object associated with the Clip
            FloatControl gainControl = (FloatControl) clip4.getControl(FloatControl.Type.MASTER_GAIN);

            // Set the volume using the specified gain value
            gainControl.setValue(volume);
            
            isMusicLoop4Playing = true;

            clip4.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
    }
  
     
     public void stopMusic4() {
        if (clip4 != null && clip4.isRunning()) {
            clip4.stop();
            isMusicLoop4Playing = false;
        }
    }
    
     public void startMusic4() {
        if (clip4 != null && !clip4.isRunning()) {
            clip4.start();
        }
    }
     
     
     public void playMusicLoop5() {
        try {
            String musicFilePath = "schaleBGM4.wav";
            float volume = -18.0f;

            clip5 = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(musicFilePath));
            clip5.open(inputStream);

            // Get the GainControl object associated with the Clip
            FloatControl gainControl = (FloatControl) clip5.getControl(FloatControl.Type.MASTER_GAIN);

            // Set the volume using the specified gain value
            gainControl.setValue(volume);
            
            isMusicLoop5Playing = true;

            clip5.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
    }
  
     
     public void stopMusic5() {
        if (clip5 != null && clip5.isRunning()) {
            clip5.stop();
            isMusicLoop5Playing = false;
        }
    }
    
     public void startMusic5() {
        if (clip5 != null && !clip5.isRunning()) {
            clip5.start();
        }
    }
     
     
   public void deafMusic() {
   if (clip1 != null) {
       FloatControl gainControl = (FloatControl) clip1.getControl(FloatControl.Type.MASTER_GAIN);
       gainControl.setValue(-80.0f);
   }
   if (clip2 != null) {
       FloatControl gainControl = (FloatControl) clip2.getControl(FloatControl.Type.MASTER_GAIN);
       gainControl.setValue(-80.0f);
   }
   if (clip3 != null) {
       FloatControl gainControl = (FloatControl) clip3.getControl(FloatControl.Type.MASTER_GAIN);
       gainControl.setValue(-80.0f);
   }
   if (clip4 != null) {
       FloatControl gainControl = (FloatControl) clip4.getControl(FloatControl.Type.MASTER_GAIN);
       gainControl.setValue(-80.0f);
   }
   if (clip5 != null) {
       FloatControl gainControl = (FloatControl) clip5.getControl(FloatControl.Type.MASTER_GAIN);
       gainControl.setValue(-80.0f);
   }
   

}
   
   
   public void upMusic() {
   if (clip1 != null) {
       FloatControl gainControl = (FloatControl) clip1.getControl(FloatControl.Type.MASTER_GAIN);
       gainControl.setValue(6.02060f);
   }
   if (clip2 != null) {
       FloatControl gainControl = (FloatControl) clip2.getControl(FloatControl.Type.MASTER_GAIN);
       gainControl.setValue(6.02060f);
   }
   if (clip3 != null) {
       FloatControl gainControl = (FloatControl) clip3.getControl(FloatControl.Type.MASTER_GAIN);
       gainControl.setValue(6.02060f);
   }
   if (clip4 != null) {
       FloatControl gainControl = (FloatControl) clip4.getControl(FloatControl.Type.MASTER_GAIN);
       gainControl.setValue(6.02060f);
   }
   if (clip5 != null) {
       FloatControl gainControl = (FloatControl) clip5.getControl(FloatControl.Type.MASTER_GAIN);
       gainControl.setValue(6.02060f);
   }
   

}
   
   
   public void midMusic() {
   if (clip1 != null) {
       FloatControl gainControl = (FloatControl) clip1.getControl(FloatControl.Type.MASTER_GAIN);
       gainControl.setValue(-18.0f);
   }
   if (clip2 != null) {
       FloatControl gainControl = (FloatControl) clip2.getControl(FloatControl.Type.MASTER_GAIN);
       gainControl.setValue(-18.0f);
   }
   if (clip3 != null) {
       FloatControl gainControl = (FloatControl) clip3.getControl(FloatControl.Type.MASTER_GAIN);
       gainControl.setValue(-18.0f);
   }
   if (clip4 != null) {
       FloatControl gainControl = (FloatControl) clip4.getControl(FloatControl.Type.MASTER_GAIN);
       gainControl.setValue(-18.0f);
   }
   if (clip5 != null) {
       FloatControl gainControl = (FloatControl) clip5.getControl(FloatControl.Type.MASTER_GAIN);
       gainControl.setValue(-18.0f);
   }
   

}
   
   
   
     
     
     
     public void playMusicLoop6() {
        try {
            String musicFilePath = "skibidi.wav";
            float volume = 6.02060f;

            clip6 = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(musicFilePath));
            clip6.open(inputStream);

            // Get the GainControl object associated with the Clip
            FloatControl gainControl = (FloatControl) clip6.getControl(FloatControl.Type.MASTER_GAIN);

            // Set the volume using the specified gain value
            gainControl.setValue(volume);

            clip6.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
    }
  
     
     public void stopMusic6() {
        if (clip6 != null && clip6.isRunning()) {
            clip6.stop();
        }
    }
    
     public void startMusic6() {
        if (clip6 != null && !clip6.isRunning()) {
            clip6.start();
        }
    }
  
     
     
     
     
     public boolean isMusicLoop1Playing() {
    return isMusicLoop1Playing;
}
     public boolean isMusicLoop2Playing() {
    return isMusicLoop2Playing;
}
     public boolean isMusicLoop3Playing() {
    return isMusicLoop3Playing;
}
     public boolean isMusicLoop4Playing() {
    return isMusicLoop4Playing;
}
     public boolean isMusicLoop5Playing() {
    return isMusicLoop5Playing;
}
    
}
