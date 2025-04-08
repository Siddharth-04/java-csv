package com.bridgelabz.advanceProblems;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MergeTwoCSVFile {
    public static void mergeCSVFiles(String path1, String path2) throws Exception {
        try (CSVReader reader1 = new CSVReader(new FileReader(path1));
             CSVReader reader2 = new CSVReader(new FileReader(path2));
             CSVWriter writer = new CSVWriter(new FileWriter("D:\\8th sem\\bridgelabz.workspace\\java-csv\\src\\main\\java\\com\\bridgelabz\\advanceProblems\\mergeTwoCSVFile.csv"))) {

            Map<String, ArrayList<String>> map = new HashMap<>();
            boolean isHeader = true;
            String[] line;

            while ((line = reader1.readNext()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                String id = line[0];
                ArrayList<String> list = new ArrayList<>();
                list.add(line[1]);
                list.add(line[2]);
                map.put(id, list);
            }

            isHeader = true;
            while ((line = reader2.readNext()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                String id = line[0];
                ArrayList<String> list = map.get(id);
                if (list != null) {
                    list.add(line[1]); // Marks
                    list.add(line[2]);
                }
            }

//            writer.writeNext(new String[]{"ID", "Name", "Age", "Marks", "Grade"});

            for (String id : map.keySet()) {
                ArrayList<String> list = map.get(id);
                if (list.size() == 4) {
                    String[] row = new String[5];
                    row[0] = id;
                    for (int i = 0; i < 4; i++) {
                        row[i + 1] = list.get(i);
                    }
                    writer.writeNext(row);
                }
            }

            System.out.println("Merged CSV written successfully.");
        }
    }

    public static void main(String[] args) {
        try{
            mergeCSVFiles("D:\\8th sem\\bridgelabz.workspace\\java-csv\\src\\main\\java\\com\\bridgelabz\\advanceProblems\\students1.csv", "D:\\8th sem\\bridgelabz.workspace\\java-csv\\src\\main\\java\\com\\bridgelabz\\advanceProblems\\students2.csv");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
