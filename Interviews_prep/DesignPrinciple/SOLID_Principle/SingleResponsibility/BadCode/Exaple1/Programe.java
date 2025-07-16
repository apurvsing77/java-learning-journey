package Interviews_prep.DesignPrinciple.SOLID_Principle.SingleResponsibility.BadCode.Exaple1;

public class Programe {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        String fileName = "myfile.txt";
        fileManager.saveFile(fileName);
        fileManager.openFile(fileName);
        fileManager.convertToPdf(fileName);
        fileManager.convertToPdf(fileName);
        fileManager.generateThumbnail(fileName);
    }
}
