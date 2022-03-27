package com.ea.framework.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class LogUtil {

    ZonedDateTime date = ZonedDateTime.now();
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("ddMMyyyyHHMMSS");
    String fileNameFormat = date.format(dateTimeFormatter);
    //file format for the log name
    private BufferedWriter bufferedWrite=  null;

    // create log file

    public void createLogFile(String filePath){
        try{
            File dir = new File(filePath);
            if(!dir.exists()){
                dir.mkdir();
            }
            File logFile = new File(dir+File.separator+fileNameFormat+".log");
            FileWriter fileWriter = new FileWriter((logFile.getAbsoluteFile()));
            bufferedWrite = new BufferedWriter(fileWriter);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void write(String message){
        try{
            dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH_MM_SS");
            String dateFormat = date.format(dateTimeFormatter);
            bufferedWrite.write("["+dateFormat+"]"+message);
            bufferedWrite.newLine();
            bufferedWrite.flush();
        }catch(Exception e){
            e.getMessage();
        }
    }
}
