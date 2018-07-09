package com.example.toni.spscanner.ui.scan.helpers;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.IOException;

public interface POIHandler {

    HSSFWorkbook getWorkbook() throws IOException;

}
