package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Считаем слово
*/

public class Solution {

    public static void main(String[] args) throws IOException {

        String fileName;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = bufferedReader.readLine();
        }

        ArrayList<String> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        try (FileReader reader = new FileReader(fileName)) {

            while (reader.ready()) {
                char current = (char) reader.read();

                if (Character.isLetter(current)) {
                    builder.append(current);
                } else {
                    list.add(builder.toString());
                    builder.delete(0, builder.length());
                }
            }
        }
        System.out.println(Collections.frequency(list, "world"));
    }
}
