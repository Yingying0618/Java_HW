package com.flexon.file_reader;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//1. Write a program to read a file from a location
// 2. Find all the words that appeared more than 5 times
// and are more than 3 characters in length.
// 3. Populate a arraylist with all those words after reversing the words
// 4. Iterate the arraylist and print.



public class FileReaderDemo {

    public static int threadshold_freq=5;
    public static int threadshold_len=3;


    public static void main(String[] args) throws IOException {
        //Read user input file
        FileReaderDemo fileDemo = new FileReaderDemo();
        FileReader fileReader = new FileReader("src/com/flexon/file_reader/file.txt");
        //store strings in Arraylist
        ArrayList<String> line = new ArrayList<>();
        Map<String, Integer> counts = new HashMap<>();

        //execute all method
        fileDemo.count(fileReader, counts);
        fileDemo.select(line,counts);
        fileDemo.printResult(line);
    }

    private void count(FileReader fileReader, Map<String, Integer> counts) {
            try {
                Scanner scanner = new Scanner(fileReader);
                while(scanner.hasNextLine()){
                    String lines = scanner.nextLine();
                    //System.out.println(lines);
                    String [] s = lines.split("[ ,.]");
                    for(String a : s ){
                        //  if(a.equals(""))continue;
                        counts.put(a, counts.getOrDefault(a,0)+1);
                        // System.out.println(a+" "+counts.get(a));
                    }
                }
                scanner.close();
            } catch (Exception e) {
                System.out.println("File is missing");
                throw e;
            }

    }

    private void select(ArrayList<String> line, Map<String, Integer> counts ) {
        for (String key : counts.keySet()) {
            if (counts.get(key) > threadshold_freq) {
                if (key.length() > threadshold_len) {
                    StringBuilder reverseWord = new StringBuilder();
                    reverseWord.append(key);
                    reverseWord = reverseWord.reverse();
                    // System.out.println(reverseWord.toString());
                    line.add(reverseWord.toString());
                }

            }
        }
    }


    private void printResult(ArrayList<String> line) {
         for (String word : line){
              System.out.println(word);
         }
    }



}
