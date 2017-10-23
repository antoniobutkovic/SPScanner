package com.example.toni.spscannerupdated;


import android.content.Context;
import android.os.Environment;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class POIReadExcelFile {

    private String scannedValue;
    private String sn;
    private String inv;
    private String mpp;
    private String string;


    POIReadExcelFile (String scannedValue){
        this.scannedValue = scannedValue;
    }

    public void readExcelFile(String fileName) {

        try {
            File file = new File(Environment.getExternalStorageDirectory() + "/Android/data/", fileName);
            FileInputStream fis = new FileInputStream(file);
            HSSFWorkbook workbook = new HSSFWorkbook(fis);
            HSSFCell cell;

            //1
            for (int i = 7; i < 28; i++){
                cell = workbook.getSheetAt(0).getRow(i).getCell(3);
                if(scannedValue.equals(cell.toString())){
                    sn = scannedValue;
                    inv = workbook.getSheetAt(0).getRow(3).getCell(3).toString();
                    mpp = workbook.getSheetAt(0).getRow(1).getCell(9).toString();
                    string = workbook.getSheetAt(0).getRow(5).getCell(4).toString();
                }
            }
            //2
            for (int i = 7; i < 28; i++){
                cell = workbook.getSheetAt(0).getRow(i).getCell(8);
                if(scannedValue.equals(cell.toString())){
                    sn = scannedValue;
                    inv = workbook.getSheetAt(0).getRow(3).getCell(3).toString();
                    mpp = workbook.getSheetAt(0).getRow(1).getCell(9).toString();
                    string = workbook.getSheetAt(0).getRow(5).getCell(9).toString();
                }
            }
            //3
            for (int i = 7; i < 28; i++){
                cell = workbook.getSheetAt(0).getRow(i).getCell(14);
                if(scannedValue.equals(cell.toString())){
                    sn = scannedValue;
                    inv = workbook.getSheetAt(0).getRow(3).getCell(14).toString();
                    mpp = workbook.getSheetAt(0).getRow(1).getCell(20).toString();
                    string = workbook.getSheetAt(0).getRow(5).getCell(15).toString();
                }
            }
            //4
            for (int i = 7; i < 28; i++){
                cell = workbook.getSheetAt(0).getRow(i).getCell(19);
                if(scannedValue.equals(cell.toString())){
                    sn = scannedValue;
                    inv = workbook.getSheetAt(0).getRow(3).getCell(14).toString();
                    mpp = workbook.getSheetAt(0).getRow(1).getCell(20).toString();
                    string = workbook.getSheetAt(0).getRow(5).getCell(20).toString();
                }
            }
            //5
            for (int i = 7; i < 28; i++){
                cell = workbook.getSheetAt(0).getRow(i).getCell(25);
                if(scannedValue.equals(cell.toString())){
                    sn = scannedValue;
                    inv = workbook.getSheetAt(0).getRow(3).getCell(25).toString();
                    mpp = workbook.getSheetAt(0).getRow(1).getCell(31).toString();
                    string = workbook.getSheetAt(0).getRow(5).getCell(26).toString();
                }
            }
            //6
            for (int i = 7; i < 28; i++){
                cell = workbook.getSheetAt(0).getRow(i).getCell(30);
                if(scannedValue.equals(cell.toString())){
                    sn = scannedValue;
                    inv = workbook.getSheetAt(0).getRow(3).getCell(25).toString();
                    mpp = workbook.getSheetAt(0).getRow(1).getCell(31).toString();
                    string = workbook.getSheetAt(0).getRow(5).getCell(31).toString();
                }
            }
            //1
            for (int i = 41; i < 62; i++){
                cell = workbook.getSheetAt(0).getRow(i).getCell(3);
                if(scannedValue.equals(cell.toString())){
                    sn = scannedValue;
                    inv = workbook.getSheetAt(0).getRow(37).getCell(3).toString();
                    mpp = workbook.getSheetAt(0).getRow(35).getCell(9).toString();
                    string = workbook.getSheetAt(0).getRow(39).getCell(4).toString();
                }
            }
            //2
            for (int i = 41; i < 62; i++){
                cell = workbook.getSheetAt(0).getRow(i).getCell(8);
                if(scannedValue.equals(cell.toString())){
                    sn = scannedValue;
                    inv = workbook.getSheetAt(0).getRow(37).getCell(3).toString();
                    mpp = workbook.getSheetAt(0).getRow(35).getCell(9).toString();
                    string = workbook.getSheetAt(0).getRow(39).getCell(9).toString();
                }
            }
            //3
            for (int i = 41; i < 62; i++){
                cell = workbook.getSheetAt(0).getRow(i).getCell(14);
                if(scannedValue.equals(cell.toString())){
                    sn = scannedValue;
                    inv = workbook.getSheetAt(0).getRow(37).getCell(14).toString();
                    mpp = workbook.getSheetAt(0).getRow(35).getCell(20).toString();
                    string = workbook.getSheetAt(0).getRow(39).getCell(15).toString();
                }
            }
            //4
            for (int i = 41; i < 62; i++){
                cell = workbook.getSheetAt(0).getRow(i).getCell(19);
                if(scannedValue.equals(cell.toString())){
                    sn = scannedValue;
                    inv = workbook.getSheetAt(0).getRow(37).getCell(14).toString();
                    mpp = workbook.getSheetAt(0).getRow(35).getCell(20).toString();
                    string = workbook.getSheetAt(0).getRow(39).getCell(20).toString();
                }
            }
            //5
            for (int i = 41; i < 62; i++){
                cell = workbook.getSheetAt(0).getRow(i).getCell(25);
                if(scannedValue.equals(cell.toString())){
                    sn = scannedValue;
                    inv = workbook.getSheetAt(0).getRow(37).getCell(25).toString();
                    mpp = workbook.getSheetAt(0).getRow(35).getCell(31).toString();
                    string = workbook.getSheetAt(0).getRow(39).getCell(26).toString();
                }
            }
            //6
            for (int i = 41; i < 62; i++){
                cell = workbook.getSheetAt(0).getRow(i).getCell(30);
                if(scannedValue.equals(cell.toString())){
                    sn = scannedValue;
                    inv = workbook.getSheetAt(0).getRow(37).getCell(25).toString();
                    mpp = workbook.getSheetAt(0).getRow(35).getCell(31).toString();
                    string = workbook.getSheetAt(0).getRow(39).getCell(31).toString();
                }
            }
            //1
            for (int i = 75; i < 96; i++){
                cell = workbook.getSheetAt(0).getRow(i).getCell(3);
                if(scannedValue.equals(cell.toString())){
                    sn = scannedValue;
                    inv = workbook.getSheetAt(0).getRow(71).getCell(3).toString();
                    mpp = workbook.getSheetAt(0).getRow(69).getCell(9).toString();
                    string = workbook.getSheetAt(0).getRow(73).getCell(4).toString();
                }
            }
            //2
            for (int i = 75; i < 96; i++){
                cell = workbook.getSheetAt(0).getRow(i).getCell(8);
                if(scannedValue.equals(cell.toString())){
                    sn = scannedValue;
                    inv = workbook.getSheetAt(0).getRow(71).getCell(3).toString();
                    mpp = workbook.getSheetAt(0).getRow(69).getCell(9).toString();
                    string = workbook.getSheetAt(0).getRow(73).getCell(9).toString();
                }
            }
            //3
            for (int i = 75; i < 96; i++){
                cell = workbook.getSheetAt(0).getRow(i).getCell(14);
                if(scannedValue.equals(cell.toString())){
                    sn = scannedValue;
                    inv = workbook.getSheetAt(0).getRow(71).getCell(14).toString();
                    mpp = workbook.getSheetAt(0).getRow(69).getCell(20).toString();
                    string = workbook.getSheetAt(0).getRow(73).getCell(15).toString();
                }
            }
            //4
            for (int i = 75; i < 96; i++){
                cell = workbook.getSheetAt(0).getRow(i).getCell(19);
                if(scannedValue.equals(cell.toString())){
                    sn = scannedValue;
                    inv = workbook.getSheetAt(0).getRow(71).getCell(14).toString();
                    mpp = workbook.getSheetAt(0).getRow(69).getCell(20).toString();
                    string = workbook.getSheetAt(0).getRow(73).getCell(20).toString();
                }
            }
            //5
            for (int i = 75; i < 96; i++){
                cell = workbook.getSheetAt(0).getRow(i).getCell(25);
                if(scannedValue.equals(cell.toString())){
                    sn = scannedValue;
                    inv = workbook.getSheetAt(0).getRow(71).getCell(25).toString();
                    mpp = workbook.getSheetAt(0).getRow(69).getCell(31).toString();
                    string = workbook.getSheetAt(0).getRow(73).getCell(26).toString();
                }
            }
            //6
            for (int i = 109; i < 130; i++){
                cell = workbook.getSheetAt(0).getRow(i).getCell(30);
                if(scannedValue.equals(cell.toString())){
                    sn = scannedValue;
                    inv = workbook.getSheetAt(0).getRow(105).getCell(25).toString();
                    mpp = workbook.getSheetAt(0).getRow(103).getCell(31).toString();
                    string = workbook.getSheetAt(0).getRow(107).getCell(31).toString();
                }
            }
            //1
            for (int i = 109; i < 130; i++){
                cell = workbook.getSheetAt(0).getRow(i).getCell(3);
                if(scannedValue.equals(cell.toString())){
                    sn = scannedValue;
                    inv = workbook.getSheetAt(0).getRow(105).getCell(3).toString();
                    mpp = workbook.getSheetAt(0).getRow(103).getCell(9).toString();
                    string = workbook.getSheetAt(0).getRow(107).getCell(4).toString();
                }
            }
            //2
            for (int i = 109; i < 130; i++){
                cell = workbook.getSheetAt(0).getRow(i).getCell(8);
                if(scannedValue.equals(cell.toString())){
                    sn = scannedValue;
                    inv = workbook.getSheetAt(0).getRow(105).getCell(3).toString();
                    mpp = workbook.getSheetAt(0).getRow(103).getCell(9).toString();
                    string = workbook.getSheetAt(0).getRow(107).getCell(9).toString();
                }
            }
            //3
            for (int i = 109; i < 130; i++){
                cell = workbook.getSheetAt(0).getRow(i).getCell(14);
                if(scannedValue.equals(cell.toString())){
                    sn = scannedValue;
                    inv = workbook.getSheetAt(0).getRow(105).getCell(14).toString();
                    mpp = workbook.getSheetAt(0).getRow(103).getCell(20).toString();
                    string = workbook.getSheetAt(0).getRow(107).getCell(15).toString();
                }
            }
            //4
            for (int i = 109; i < 130; i++){
                cell = workbook.getSheetAt(0).getRow(i).getCell(19);
                if(scannedValue.equals(cell.toString())){
                    sn = scannedValue;
                    inv = workbook.getSheetAt(0).getRow(105).getCell(14).toString();
                    mpp = workbook.getSheetAt(0).getRow(103).getCell(20).toString();
                    string = workbook.getSheetAt(0).getRow(107).getCell(20).toString();
                }
            }
            //5
            for (int i = 109; i < 130; i++){
                cell = workbook.getSheetAt(0).getRow(i).getCell(25);
                if(scannedValue.equals(cell.toString())){
                    sn = scannedValue;
                    inv = workbook.getSheetAt(0).getRow(105).getCell(25).toString();
                    mpp = workbook.getSheetAt(0).getRow(103).getCell(31).toString();
                    string = workbook.getSheetAt(0).getRow(107).getCell(26).toString();
                }
            }
            //6
            for (int i = 109; i < 130; i++){
                cell = workbook.getSheetAt(0).getRow(i).getCell(30);
                if(scannedValue.equals(cell.toString())){
                    sn = scannedValue;
                    inv = workbook.getSheetAt(0).getRow(105).getCell(25).toString();
                    mpp = workbook.getSheetAt(0).getRow(103).getCell(31).toString();
                    string = workbook.getSheetAt(0).getRow(107).getCell(31).toString();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    public String getSn() {
        return sn;
    }

    public String getInv() {
        return inv;
    }

    public String getMpp() {
        return mpp;
    }

    public String getString() {
        return string;
    }

}
