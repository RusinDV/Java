package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {


    public static void main(String[] args) throws Exception {
        ArrayList<String> strings=new ArrayList<String>();
        int max=Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String s=reader.readLine();
            strings.add(s);

        }
        for (String string : strings) {

            if (string.length() < max)
                max = string.length();
        }
        for (String string : strings) {
            if(string.length()==max)
                System.out.println(string);
        }

    }
}

