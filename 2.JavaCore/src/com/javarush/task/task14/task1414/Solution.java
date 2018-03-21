package com.javarush.task.task14.task1414;

/* 
MovieFactory
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = reader.readLine();
            if ("cartoon".equals(str)) { Movie movie=MovieFactory.getMovie(str);
                System.out.println(movie.getClass().getSimpleName());
            } else if ("thriller".equals(str)) {
                Movie movie=MovieFactory.getMovie(str);
                System.out.println(movie.getClass().getSimpleName());
            } else if ("soapOpera".equals(str)) {
                Movie movie=MovieFactory.getMovie(str);
                System.out.println(movie.getClass().getSimpleName());
            } else {
                Movie movie = MovieFactory.getMovie(str);
                break;

            }

        }

        /*
8 Создать переменную movie класса Movie и для каждой введенной строки(ключа):
8.1 получить объект используя MovieFactory.getMovie и присвоить его переменной movie
8.2 вывести на экран movie.getClass().getSimpleName()
        */

    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;


            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            }
            if ("cartoon".equals(key)) {
                movie = new Cartoon();
            }
            if ("thriller".equals(key)) {
                movie = new Thriller();
            }


            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    static class Cartoon extends Movie {
    }

    static class Thriller extends Movie {
    }
}
