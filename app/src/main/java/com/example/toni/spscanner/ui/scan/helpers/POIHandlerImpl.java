package com.example.toni.spscanner.ui.scan.helpers;

import android.os.Environment;

import com.example.toni.spscanner.Constants;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class POIHandlerImpl implements POIHandler{

    String filePath;

    public POIHandlerImpl(String filePath){
        this.filePath = filePath;
    }

    @Override
    public HSSFWorkbook getWorkbook() throws IOException {
        return new HSSFWorkbook(getFis());
    }

    File getFile(){
        return new File(filePath);
    }

    FileInputStream getFis() throws FileNotFoundException {
        return new FileInputStream(getFile());
    }

}


//  + "/Android/data/"