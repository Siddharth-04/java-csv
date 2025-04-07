package com.bridgelabz.basicProblems;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteDataToCSVFile {
    public static void writeData(String path) throws IOException {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path,true))){

            String[] array = {
                    "ID,Name,Department,Salary",
                    "101,Siddharth,IT,1200000",
                    "102,Ishaan,IT,1200000",
                    "103,Nikhil,IT,1300000",
                    "104,Pranav,IT,1100000"
            };

            for(String s : array){
                bw.write(s);
                bw.newLine();
            }
        }
    }
    public static void main(String[] args) {
        String path = "D:\\8th sem\\bridgelabz.workspace\\java-csv\\src\\main\\java\\com\\bridgelabz\\basicProblems\\EmployeeDataOutput.csv";
        try{
            writeData(path);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
//ID,Name,Department,Salary
//101,Siddharth,IT,1200000
//102,Ishaan,IT,1200000
//103,Nikhil,IT,1300000
//104,Pranav,IT,1100000