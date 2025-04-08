package com.bridgelabz.intermediateProblems;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.PriorityQueue;

class Pair  {
    String name;
    int b;

    Pair(String name, int b){
        this.name = name;
        this.b = b;
    }


}
public class SortCSVFile {
    public static void printSortedSalary(String filepath) throws Exception{
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a,b)-> b.b-a.b
        );

        try(CSVReader reader  = new CSVReader(new FileReader(filepath))){
            boolean isHeader = true;
            String [] line;

            while((line = reader.readNext()) != null){
                if(isHeader){
                    isHeader = false;
                    continue;
                }
                pq.add(new Pair(line[0],Integer.parseInt(line[2])));
            }
        }

        int size = 5;

        while(size > 0){
            Pair p = pq.poll();
            System.out.println(p.name + ":" + p.b);
            size--;
        }
    }
    public static void main(String[] args) {
        String path = "D:\\8th sem\\bridgelabz.workspace\\java-csv\\src\\main\\java\\com\\bridgelabz\\intermediateProblems\\salaryRecords.csv";
        try{
            printSortedSalary(path);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
//Nikhil:1300000
//Siddharth:1200000
//Madhav:1150000
//Ishaan:1100000
//Pranav:1000000