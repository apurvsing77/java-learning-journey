package Interviews_prep.DesignPrinciple.SOLID_Principle.SingleResponsibility.GoodCode;

import java.util.Random;

class ConversionService{

    private Logger logger;
    private NotificationService notificationService;

    public ConversionService(Logger logger, NotificationService notificationService) {
        this.logger = logger;
        this.notificationService = notificationService;
    }

    public void convertToPdf(String fileName){
            System.out.println("Converting File to PDF: " + fileName);
            logger.logAction("Time Taken to convert to PDF: " + new Random().nextInt(1,10)+" seconds",fileName);
            notificationService.sendNotification("Converted to PDF: " + fileName);
        }
    }