package Interwiews_prep.DesignPrinciple.SOLID_Principle.OpenClosePrinciple.MediaPlayer;

public class Program {
    public static void main(String[] args) {
        VideoPlayerService vps = new VideoPlayerService();
        vps.playVideo(new HdQuality(),"HD quality video");
        vps.playVideo(new UltraHighQuality(), "Ultra high quality video");
        vps.playVideo(new LowQuality(), "Low quality video");

    }
}
