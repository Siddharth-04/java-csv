package com.bridgelabz.advanceProblems;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;

class Employee{
    int id;
    String name;
    String department;
    int salary;

    public Employee(int id, String name, String department, int salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}
public class ConvertCsvIntoObjects {
    public static void convertCsvIntoObjects(String path) throws Exception {
        ArrayList<Employee> employees = new ArrayList<Employee>();

        try(CSVReader reader = new CSVReader(new FileReader(path))) {
            String [] line;
            boolean isHeader = true;
            while ((line = reader.readNext()) != null) {
                if(isHeader){
                    isHeader = false;
                    continue;
                }

                int id = Integer.parseInt(line[0]);
                String name = line[1];
                String department = line[2];
                int marks = Integer.parseInt(line[3]);

                Employee student = new Employee(id, name, department, marks);
                employees.add(student);
            }
        }

        for(Employee employee : employees){
            System.out.print(employee + " ");
        }
    }
    public static void main(String[] args) {
        String path = "D:\\8th sem\\bridgelabz.workspace\\java-csv\\src\\main\\java\\com\\bridgelabz\\advanceProblems\\employee.csv";
        try{
            convertCsvIntoObjects(path);
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
