package Interwiews_prep.DesignPrinciple.SOLID_Principle.SingleResponsibility.GoodCode;

import java.util.ArrayList;
import java.util.List;

public class FileManager {

    public FileManager(Logger logger, NotificationService notificationService) {
        this.logger = logger;
        this.notificationService = notificationService;
    }

    private List<String> files = new ArrayList<>();

    private Logger logger;
    private NotificationService notificationService;

    public void openFile(String fileName) {
        if (files.contains(fileName)) {
            System.out.println("Opnening file: " + fileName);
            logger.logAction("Opened file: " , fileName);
            notificationService.sendNotification("File opened: " + fileName);
        }
        else {
           notificationService.sendNotification("File not found: " + fileName);
        }
    }
    public void saveFile(String fileName) {
        System.out.println("Saving file: " + fileName);
        files.add(fileName);
        logger.logAction("Saved file: " , fileName);
        notificationService.sendNotification("File saved: " + fileName);
    }












}
















