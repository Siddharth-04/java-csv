package com.bridgelabz.intermediateProblems;

import com.opencsv.CSVReader;
import java.io.FileReader;

public class FilterMarks {
    public static void printStudents(String path) throws Exception {
        try(CSVReader csvReader = new CSVReader(new FileReader(path))){
            String [] line;
            boolean isHeader = true;

            while((line=csvReader.readNext())!=null){
                if(isHeader){
                    isHeader = false;
                    continue;
                }
                String name = line[0];
                int marks = Integer.parseInt(line[1]);

                if(marks > 80){
                    System.out.println("Name : "+name+" Marks : "+marks);
                }
            }
        }
    }
    public static void main(String[] args) {
        String path = "D:\\8th sem\\bridgelabz.workspace\\java-csv\\src\\main\\java\\com\\bridgelabz\\intermediateProblems\\students.csv";
        try{
            printStudents(path);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
//Name : Siddharth Marks : 98
//Name : Ishaan Marks : 98