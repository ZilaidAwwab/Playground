package com.example.readhaven.model;

import com.example.readhaven.enums.BookStatus;

import java.util.UUID;

import static com.example.readhaven.utils.LibraryUtils.generateBookId;

public class Book {
    private final UUID id;
    private String title;
    private String author;
    private String category;
    private BookStatus status;
    private Member donor;

    public Book(String title, String author, String category) {
        this.id = generateBookId();
        this.title = title;
        this.author = author;
        this.category = category;
        this.status = BookStatus.AVAILABLE;
    }

    public Book(String title, String author, String category, Member donor) {
        this(title, author, category);
        this.donor = donor;
    }

    public UUID getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BookStatus getStatus() {
        return this.status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public Member getDonor() {
        return this.donor;
    }
}
