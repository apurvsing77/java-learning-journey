package Interviews_prep.DesignPattern.BehaviouralPattern.Strategy.FileCompressionTool;

import Interviews_prep.DesignPattern.BehaviouralPattern.Strategy.FileCompressionTool.Context.Compressor;

public class Main {

    public static void main(String[] args){
        Compressor zipFile = new Compressor();
        zipFile.compressFileBasedOnSize(0.1);
        zipFile.compressFileBasedOnSize(50);
    }
}
