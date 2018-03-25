package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            User first = new User();
            first.setFirstName("Vasy");
            first.setLastName("Pupkin");
            first.setBirthDate(new Date(2015, 5, 10));
            first.setMale(true);
            first.setCountry(User.Country.RUSSIA);

            User second = new User();
            second.setFirstName("Masha");
            second.setLastName("Pupkina");
            second.setBirthDate(new Date(2017, 7, 11));
            second.setMale(false);
            second.setCountry(User.Country.RUSSIA);

            JavaRush javaRush = new JavaRush();
            javaRush.users.add(first);
            javaRush.users.add(second);


            //    JavaRush javaRush1=new JavaRush();
            //   javaRush1.users.add(second);

            javaRush.save(outputStream);
            //     javaRush1.save(outputStream);

            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

            System.out.println(javaRush.equals(loadedObject));
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            for (int i = 0; i < users.size(); i++) {
                outputStream.write(String.valueOf(users.size()).getBytes());
                outputStream.write(" ".getBytes());
                outputStream.write(users.get(i).getFirstName().getBytes());
                outputStream.write(" ".getBytes());
                outputStream.write(users.get(i).getLastName().getBytes());
                outputStream.write(" ".getBytes());
                outputStream.write(users.get(i).getBirthDate().toString().getBytes());
                outputStream.write(" ".getBytes());
                outputStream.write((users.get(i).isMale()?"yes":"no").getBytes());
                outputStream.write(" ".getBytes());
                outputStream.write((users.get(i).getCountry().getDisplayedName().getBytes()));
           }
        }

        public void load(InputStream inputStream) throws Exception {

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
