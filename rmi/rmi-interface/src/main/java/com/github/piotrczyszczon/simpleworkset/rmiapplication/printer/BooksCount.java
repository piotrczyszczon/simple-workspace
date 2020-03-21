package com.github.piotrczyszczon.simpleworkset.rmiapplication.printer;

import java.io.Serializable;

public class BooksCount implements Serializable
{
    private String bookName;
    private int count;

    public BooksCount(String bookName, int count)
    {
        this.bookName = bookName;
        this.count = count;
    }

    @Override
    public String toString()
    {
        return "BooksCount{" + "bookName='" + bookName + '\'' + ", count=" + count + '}';
    }
}
