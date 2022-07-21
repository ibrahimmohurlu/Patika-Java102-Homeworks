package com.company.BookOrder;

import java.util.Date;

public class Book implements Comparable<Book> {
    private String name;
    private String authorName;
    private int pageNumber;
    private Date publishDate;


    public Book(String name, String authorName, int pageNumber, Date publishDate) {
        this.name = name;
        this.authorName = authorName;
        this.pageNumber = pageNumber;
        this.publishDate = publishDate;
    }

    @Override
    public int compareTo(Book o) {
        return this.getName().compareTo(o.getName());
    }

    public void printBookInfo() {
        String s = String.format("%s written by %s pageNumber:%d", this.getName(), this.getAuthorName(), this.getPageNumber());
        System.out.println(s);
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
