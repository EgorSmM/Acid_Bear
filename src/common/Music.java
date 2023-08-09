package common;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Music {
    private Clip musicClip;

    public Music(String fileName){
        playMusic(fileName);
    }

    public void playMusic(String fileName) {
        try {
            musicClip = AudioSystem.getClip();
            musicClip.open(AudioSystem.getAudioInputStream(new File(fileName)));
            musicClip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopMusic() {
        if (musicClip != null && musicClip.isRunning()) {
            musicClip.stop();
            musicClip.close();
        }
    }
}
