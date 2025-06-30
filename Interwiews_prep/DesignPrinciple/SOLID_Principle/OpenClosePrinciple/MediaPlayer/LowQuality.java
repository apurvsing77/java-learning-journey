package Interwiews_prep.DesignPrinciple.SOLID_Principle.OpenClosePrinciple.MediaPlayer;

public class LowQuality implements VideoPlayer {

    @Override
    public void playVideo(String quality) {
        System.out.println("Playing LowQuality video at quality: " + quality);
    }
}
