package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.customer=customer;
            this.contact=contact;
        }

        @Override
        public String getCountryCode() {
            String kode=null;
            for (Map.Entry<String, String> entry : countries.entrySet()) {

                if (entry.getValue().equals(customer.getCountryName())){
                    kode=entry.getKey();
                }
            }
            return kode;

        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String[] name =contact.getName().split(" ");
            return name[1];
        }

        @Override
        public String getContactLastName() {
            String[] name =contact.getName().split(" ");
            return name[0].replace(",","");
        }

        @Override
        public String getDialString() {
            String sti =contact.getPhoneNumber();

            sti=sti.replace("(","");
            sti=sti.replace(")","");
            sti=sti.replaceAll("-","");


            return "callto://"+sti;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}