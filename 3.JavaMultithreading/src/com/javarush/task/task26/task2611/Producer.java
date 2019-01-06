package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable {
    private ConcurrentHashMap<String,String> map;

    public Producer(ConcurrentHashMap map) {
        this.map = map;
    }

    @Override
    public void run() {
try{

         for (int i = 1; i <50 ; i++) {
            map.put(Integer.toString(i),"Some text for "+Integer.toString(i));
            Thread.sleep(500);
        }


}catch (Exception e) {
    System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
}




    }
}
