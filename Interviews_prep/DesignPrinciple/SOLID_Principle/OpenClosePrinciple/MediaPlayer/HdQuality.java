package Interviews_prep.DesignPrinciple.SOLID_Principle.OpenClosePrinciple.MediaPlayer;

public class HdQuality implements VideoPlayer {
    @Override
    public void playVideo(String quality) {
        System.out.println("Playing HD quality video: " + quality);
    }
}
