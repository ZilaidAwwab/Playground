package com.example.readhaven.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.example.readhaven.utils.LibraryUtils.generateUserId;

public class Member {
    private final UUID id;
    private String name;
    private String email;
    private String password;
    private String address;
    private String phoneNo;
    private List<Book> booksDonated;
    private List<Book> booksIssued;
    private boolean canIssueBook;

    public Member(String name, String email, String password, String address, String phoneNo) {
        this.id = generateUserId();
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phoneNo = phoneNo;
        this.booksDonated = new ArrayList<>();
        this.booksIssued = new ArrayList<>();
        this.canIssueBook = true;
    }

    public UUID getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return this.phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void getBooksDonated() {
        int n = this.booksDonated.size();
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                System.out.println("Books donated by " + this.getName());
                System.out.println(i+1 + ". " + this.booksDonated.get(i));
            }
        } else {
            System.out.println(this.getName() + " hasn't donated any book.");
        }
    }

    public void setBooksDonated(Book book) {
        this.booksDonated.add(book);
    }

    public void getBooksIssued() {
        int n = this.booksIssued.size();
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                System.out.println("Books Issued by " + this.getName());
                System.out.println(i+1 + ". " + this.booksIssued.get(i));
            }
        } else {
            System.out.println(this.getName() + " hasn't issued any book.");
        }
    }

    public void setBooksIssued(Book book) {
        this.booksIssued.add(book);
    }

    public void getCanIssueBook() {
        int n = this.booksIssued.size();
        if (n >= 2) {
            this.canIssueBook = false;
        }
    }
}
