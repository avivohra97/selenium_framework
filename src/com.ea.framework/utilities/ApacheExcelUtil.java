package com.ea.framework.utilities;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;

public class ApacheExcelUtil {
    // open excel sheet
    //read cell data

    // store in memory collection

    //get cell method

    static Sheet wrksheet;
    static Workbook workbook =null;
    static Hashtable dict= new Hashtable();
    //Create a Constructor
    public ApacheExcelUtil(String ExcelSheetPath) throws IOException
    {
        FileInputStream inputStream = new FileInputStream(new File(ExcelSheetPath));
        String fileExtensionName = ExcelSheetPath.substring(ExcelSheetPath.indexOf("."));

        //Check condition if the file is xlsx file
        if(fileExtensionName.equals(".xlsx")){

            //If it is xlsx file then create object of XSSFWorkbook class

            workbook = new XSSFWorkbook(inputStream);

        }

        //Check condition if the file is xls file

        else if(fileExtensionName.equals(".xls")){

            //If it is xls file then create object of XSSFWorkbook class

            workbook = new XSSFWorkbook(inputStream);

        }

        //For Demo purpose the excel sheet path is hardcoded, but not recommended :)
        wrksheet = workbook.getSheet("Sheet1");
        ColumnDictionary();
        // to store column name at initialization
    }

    //Returns the Number of Rows
    public static int RowCount()
    {
        return wrksheet.getLastRowNum()-wrksheet.getFirstRowNum();
    }

    //Returns the Cell value by taking row and Column values as argument
    public static String ReadCell(int column,int row)
    {
        Row sheetRow = wrksheet.getRow(row);
        return sheetRow.getCell(column).getStringCellValue();
    }

    public static String ReadCell(String column,int row)
    {
        return ReadCell(GetCell(column),row);
    }

    //Create Column Dictionary to hold all the Column Names
    public static void ColumnDictionary()
    {
        //Get the current count of rows in excel file

        int rowCount = wrksheet.getLastRowNum()-wrksheet.getFirstRowNum();

        //Get the first row from the sheet

        Row row = wrksheet.getRow(0);
        //Iterate through all the columns in the Excel sheet and store the value in Hashtable
        for(int col=0;col < row.getLastCellNum();col++)
        {
            dict.put(ReadCell(col,0), col);
        }
    }

    //Read Column Names
    public static int GetCell(String colName)
    {
        try {
            int value;
            value = ((Integer) dict.get(colName)).intValue();
            return value;
        } catch (NullPointerException e) {
            return (0);

        }
    }

}
