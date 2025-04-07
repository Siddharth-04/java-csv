package com.bridgelabz.intermediateProblems;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;

public class ModifyingCSVFile {
    public static void modifyingCSVFile(String path,String outputPath,String username) throws Exception{
        try(CSVReader reader = new CSVReader(new FileReader(path));
            CSVWriter writer = new CSVWriter(new FileWriter(outputPath))){
            String[] line;
            boolean isHeader = true;

            while ((line = reader.readNext()) != null) {
                if(isHeader){
                    isHeader = false;
                    continue;
                }

                String department = line[2];
                double salary = Double.parseDouble(line[3]);

                if(department.equals("IT")){
                    salary *= (int) (salary*1.10);
                }

                writer.writeNext(line);
            }
        }

        System.out.println("File Updated");
    }
    public static void main(String[] args) {
        String path = "D:\\8th sem\\bridgelabz.workspace\\java-csv\\src\\main\\java\\com\\bridgelabz\\intermediateProblems\\employeeData.csv";
        String outputPath = "D:\\8th sem\\bridgelabz.workspace\\java-csv\\src\\main\\java\\com\\bridgelabz\\intermediateProblems\\employeeDataOutput.csv";
        try{
            modifyingCSVFile(path,outputPath,"Siddharth");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
//"101","Siddharth","IT","1200000"
//"102","Ishaan","IT","1200000"
//"103","Nikhil","Consulting","1300000"
//"104","Pranav","Sales","1100000"
//File Updated