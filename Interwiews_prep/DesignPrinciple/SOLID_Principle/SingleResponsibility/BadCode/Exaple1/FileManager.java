package Interwiews_prep.DesignPrinciple.SOLID_Principle.SingleResponsibility.BadCode.Exaple1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FileManager {
    private List<String> files = new ArrayList<>();

    public void openFile(String fileName) {
        if (files.contains(fileName)) {
            System.out.println("Opnening file: " + fileName);
            logAction("Opened file: " , fileName);
            sendNotification("File opened: " + fileName);
        }
        else {
            sendNotification("File not found: " + fileName);
        }
    }
    public void saveFile(String fileName) {
        System.out.println("Saving file: " + fileName);
        files.add(fileName);
        logAction("Saved file: " , fileName);
        sendNotification("File saved: " + fileName);
    }
    public void generateThumbnail(String fileName) {
        System.out.println("convert file to PDF " + fileName);
        logAction("Time Taken to Thumbnail: " + new Random().nextInt(1,10)+" seconds",fileName);
        sendNotification("generated thumbnail for: " + fileName);
    }
    public void convertToPdf(String fileName){
        System.out.println("Converting File Yo PDF: " + fileName);
        logAction("Time Taken to convert to PDF: " + new Random().nextInt(1,10)+" seconds",fileName);
        sendNotification("Converted to PDF: " + fileName);
    }

    private void logAction(String action , String fileName) {
        System.out.println("Logging action: " + action+"  -  "+fileName);

    }
    private  void sendNotification(String message) {
        System.out.println("Sending notification: " + message);
    }

}
















