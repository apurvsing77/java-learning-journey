package Interviews_prep.DesignPattern.BehaviouralPattern.Strategy.FileCompressionTool.ConcreteStrategy;

import Interviews_prep.DesignPattern.BehaviouralPattern.Strategy.FileCompressionTool.FileCompressor;

public class ZipFile implements FileCompressor {
    @Override
    public void compressFile() {
    System.out.println(" File Size Below to 1MB, Compress to the Zip File ");
    }
}
