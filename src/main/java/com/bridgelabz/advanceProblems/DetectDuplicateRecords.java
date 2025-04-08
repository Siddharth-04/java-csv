package com.bridgelabz.advanceProblems;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.HashSet;

public class DetectDuplicateRecords {
    public static void detectDuplicateRecords(String filePath) throws Exception {
        try(CSVReader csvReader = new CSVReader(new FileReader(filePath));){
            HashSet<String> s = new HashSet<>();
            String [] line;
            boolean isHeader = true;

            while((line = csvReader.readNext())!=null){
                if(isHeader){
                    isHeader = false;
                    continue;
                }

                if(s.contains(line[0])){
                    System.out.println(line[0] + "," + line[1] + "," + line[2]);
                }else{
                    s.add(line[0]);
                }
            }
        }
    }
    public static void main(String[] args) {
        String path = "D:\\8th sem\\bridgelabz.workspace\\java-csv\\src\\main\\java\\com\\bridgelabz\\advanceProblems\\duplicateRecord.csv";
        try{
            detectDuplicateRecords(path);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
//101,Siddharth,7011090137
//104,Ishaan,0987654321