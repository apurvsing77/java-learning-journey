package Interviews_prep.DesignPrinciple.SOLID_Principle.SingleResponsibility.GoodCode;

public class Main {
    public static void main(String[] args) {

        Logger logger = new Logger();
        NotificationService notificationService = new NotificationService();

        FileManager fileManager = new FileManager(logger,notificationService);
        String fileName = "myfile.txt";
        fileManager.saveFile(fileName);
        fileManager.openFile(fileName);
        ConversionService conversionService = new ConversionService(logger, notificationService);
        conversionService.convertToPdf(fileName);
        ThumbnailService thumbnailService = new ThumbnailService(logger, notificationService);

        thumbnailService.generateThumbnail(fileName);
    }
}
