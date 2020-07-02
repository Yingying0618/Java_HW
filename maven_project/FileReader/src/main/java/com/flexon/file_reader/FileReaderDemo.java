package com.flexon.file_reader;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileReaderDemo {

    private final static int THREADSHOLD_FREQ=5;
    private final static int THREADSHOLD_LEN =3;


    public static void main(String[] args) throws IOException {
        //Read user input file
        FileReaderDemo fileDemo = new FileReaderDemo();
        File file = new File("file.txt");

        //store strings in Arraylist
        ArrayList<String> rwords = new ArrayList<>();
        Map<String, Integer> counts = new HashMap<>();

        //execute all method
        fileDemo.count(file, counts);
        fileDemo.select(rwords, counts);
        fileDemo.printResult(rwords);

    }

    private void count(File file, Map<String, Integer> counts) throws FileNotFoundException {
            try {
                Scanner scanner = new Scanner(file);
                while(scanner.hasNextLine()){
                    String lines = scanner.nextLine();
                    String [] s = lines.split("[ ,.]");
                    for(String a : s ){
                        counts.put(a, counts.getOrDefault(a,0)+1);
                    }
                }
                scanner.close();
            } catch (Exception e) {
                System.out.println("File is missing");
                throw e;
            }
    }

    private void select(ArrayList<String> rwords, Map<String, Integer> counts ) {
        for (String key : counts.keySet()) {
            if (counts.get(key) > THREADSHOLD_FREQ) {
                if (key.length() > THREADSHOLD_LEN) {
                    StringBuilder reverseWord = new StringBuilder();
                    reverseWord.append(key);
                    reverseWord = reverseWord.reverse();
                    rwords.add(reverseWord.toString());
                }

            }
        }
    }


    private void printResult(ArrayList<String> rwords) {
         for (String word : rwords){
              System.out.println(word);
         }
    }
}
