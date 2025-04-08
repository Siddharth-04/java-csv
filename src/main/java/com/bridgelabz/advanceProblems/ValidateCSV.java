package com.bridgelabz.advanceProblems;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.regex.Pattern;

public class ValidateCSV {
    public static void validateCSV(String csvFile) throws Exception {
        try(CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            String regexForEmail = "^[a-zA-Z]{1,}@[a-z]{3,}\\.[a-z]{2,3}$";
            String regexForPhone = "^[6-9]{1}[0-9]{9}$";
            String [] line;
            boolean isHeader = true;

            while((line = reader.readNext()) != null){
                if(isHeader){
                    isHeader = false;
                    continue;
                }

                String name = line[0];
                String email = line[1];
                String phoneNo = line[2];

                boolean isValidEmail = Pattern.matches(regexForEmail, email);
                boolean isValidPhone = Pattern.matches(regexForPhone, phoneNo);

                if(!isValidPhone && !isValidEmail){
                    System.out.println("Invalid email and phone number :" + name);
                } else if (!isValidEmail) {
                    System.out.println("Invalid email : " + name);

                }else if(!isValidPhone){
                    System.out.println("Invalid phone number : "+name);
                }
            }
        }
    }
    public static void main(String[] args) {
        String path = "D:\\8th sem\\bridgelabz.workspace\\java-csv\\src\\main\\java\\com\\bridgelabz\\advanceProblems\\students.csv";
        try{
            validateCSV(path);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
//Invalid email and phone number :Nikhil
//Invalid phone number : Pranav
//Invalid email : Vipul