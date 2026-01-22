package Interviews_prep.DesignPattern.BehaviouralPattern.Strategy.FileCompressionTool.ConcreteStrategy;

import Interviews_prep.DesignPattern.BehaviouralPattern.Strategy.FileCompressionTool.FileCompressor;

public class RarFile implements FileCompressor {

    @Override
    public void compressFile() {
    System.out.println("File Size > 1GB, Compress to the Rar file ");
    }
}
