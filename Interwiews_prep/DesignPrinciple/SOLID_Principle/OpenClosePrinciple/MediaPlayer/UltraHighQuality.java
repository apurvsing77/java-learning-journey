package Interwiews_prep.DesignPrinciple.SOLID_Principle.OpenClosePrinciple.MediaPlayer;

public class UltraHighQuality implements VideoPlayer{
    @Override
    public void playVideo(String quality) {
        System.out.println("Playing Ultra High Quality Video at " + quality );
    }
}
