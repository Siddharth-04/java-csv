package com.bridgelabz.basicProblems;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadAndCountRows {
    public static int countRows(String fileName) {
        int numberOfRows = 0;

        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line;
            br.readLine();

            while( (line = br.readLine()) != null){
                numberOfRows++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

       return numberOfRows;
    }
    public static void main(String[] args) {
        String path = "D:\\8th sem\\bridgelabz.workspace\\java-csv\\src\\main\\java\\com\\bridgelabz\\basicProblems\\EmployeeDataOutput.csv";
        System.out.println(countRows(path));;
    }
}
//4