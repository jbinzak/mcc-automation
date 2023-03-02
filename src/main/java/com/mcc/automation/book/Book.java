package com.mcc.automation.book;

import com.mcc.automation.author.Author;

public class Book {

    private String title;
    private Author author;

    public Book(String title, String authorName){
        this.title = title;
        this.author = new Author(authorName);
    }
}
