package com.company.BookOrder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        ArrayList<Book> list = new ArrayList<>();

        list.add(new Book("Learning SQL", "Alan Beaulieu", 438, new Date(2005, 4, 18)));
        list.add(new Book("SQL for Data Analysis", "Cathy Tanimura", 786, new Date(2021, 9, 9)));
        list.add(new Book("The Midnight Library", "Matt Haig", 224, new Date(2013, 4, 23)));
        list.add(new Book("The Invisible Life of Addie LaRue", "V.E. Schwab", 627, new Date(2016, 11, 24)));
        list.add(new Book("Advanced SQL", "Alan Beaulieu", 887, new Date(2008, 5, 4)));

        TreeSet<Book> setByName = new TreeSet<>();
        setByName.addAll(list);
        System.out.println("Order by book title:");
        for (Book b : setByName) {
            b.printBookInfo();
        }

        TreeSet<Book> setByPageNum = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return Integer.compare(o1.getPageNumber(), o2.getPageNumber());
            }
        });

        setByPageNum.addAll(list);
        System.out.println("Order by page number:");
        for (Book b : setByPageNum) {
            b.printBookInfo();
        }


    }
}