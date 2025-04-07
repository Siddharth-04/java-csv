package com.bridgelabz.intermediateProblems;

import com.opencsv.CSVReader;
import java.io.FileReader;

public class SearchForEmployee {
    public static void searchForEmployee(String path,String employeeToSearch) throws Exception {
        try(CSVReader csv = new CSVReader(new FileReader(path))){
            String [] line;
            boolean isHeader = true;

            while((line = csv.readNext())!= null){

                if(isHeader){
                    isHeader = false;
                    continue;
                }

                String name = line[1];
                String department = line[2];
                int salary = Integer.parseInt(line[3]);

                if(name.equalsIgnoreCase(employeeToSearch)){
                    System.out.println(name + " " + department + " " + salary);
                }
            }
        }
    }
    public static void main(String[] args) {
        String path = "D:\\8th sem\\bridgelabz.workspace\\java-csv\\src\\main\\java\\com\\bridgelabz\\intermediateProblems\\employeeData.csv";
        try{
            searchForEmployee(path,"Siddharth");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
//Siddharth IT 1200000