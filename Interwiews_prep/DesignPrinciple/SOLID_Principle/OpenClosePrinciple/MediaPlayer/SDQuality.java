package Interwiews_prep.DesignPrinciple.SOLID_Principle.OpenClosePrinciple.MediaPlayer;

public class SDQuality implements VideoPlayer{
    @Override
    public void playVideo(String quality) {
        System.out.println("Playing video in SD quality at " + quality + " resolution");
    }
}
