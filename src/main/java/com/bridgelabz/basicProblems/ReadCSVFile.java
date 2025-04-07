package com.bridgelabz.basicProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ReadCSVFile {
    private static void readFile(String path) throws IOException {
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);

        String line;

        while((line = br.readLine()) != null){
            String [] data = line.split(",");
            System.out.println(Arrays.toString(data));
        }
    }
    public static void main(String[] args) {
        String path = "D:\\8th sem\\bridgelabz.workspace\\java-csv\\src\\main\\java\\com\\bridgelabz\\basicProblems\\StudentData.csv";
        try{
            readFile(path);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
//["ID", "Name", "Age", "Marks"]
//["101", "Siddharth", "23", "98"]
//["102", "Ishaan", "22", "98"]