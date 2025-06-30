package Interwiews_prep.DesignPrinciple.SOLID_Principle.SingleResponsibility.GoodCode;

import java.util.Random;

class ThumbnailService{

    private Logger logger;
    private NotificationService notificationService;

    public ThumbnailService(Logger logger, NotificationService notificationService) {
        this.logger = logger;
        this.notificationService = notificationService;
    }

    public void generateThumbnail(String fileName) {
            System.out.println("convert file to PDF " + fileName);
            logger.logAction("Time Taken to Thumbnail: " + new Random().nextInt(1,10)+" seconds",fileName);
            notificationService.sendNotification("generated thumbnail for: " + fileName);
        }
    }