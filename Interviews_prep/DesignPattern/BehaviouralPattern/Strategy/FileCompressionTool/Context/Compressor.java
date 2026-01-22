package Interviews_prep.DesignPattern.BehaviouralPattern.Strategy.FileCompressionTool.Context;

import Interviews_prep.DesignPattern.BehaviouralPattern.Strategy.FileCompressionTool.ConcreteStrategy.RarFile;
import Interviews_prep.DesignPattern.BehaviouralPattern.Strategy.FileCompressionTool.ConcreteStrategy.ZipFile;
import Interviews_prep.DesignPattern.BehaviouralPattern.Strategy.FileCompressionTool.FileCompressor;

public class Compressor {

    FileCompressor fileCompressor;

    public void compressFileBasedOnSize(double fileSize ){
        if(fileSize <= 1){
          this.fileCompressor = new ZipFile();
          fileCompressor.compressFile();
        }else {
            this.fileCompressor = new RarFile();
            fileCompressor.compressFile();

        }    }

}
