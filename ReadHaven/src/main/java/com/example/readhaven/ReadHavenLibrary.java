package com.example.readhaven;

import com.example.readhaven.model.Member;
import com.example.readhaven.service.BookService;
import com.example.readhaven.service.BookServiceImpl;
import com.example.readhaven.service.MemberService;
import com.example.readhaven.service.MemberServiceImpl;

import java.util.List;
import java.util.Scanner;

public class ReadHavenLibrary {

    // Dependency Injection
    private BookService bookService;
    private MemberService member;

    private Scanner scanner = new Scanner(System.in);

    public ReadHavenLibrary() {
        this.bookService = new BookServiceImpl();
        this.member = new MemberServiceImpl();
    }

    public void start() {
        System.out.println(
                "Welcome to ReadHaven Library\n\n" +
                "Select an option to continue...\n"
        );

        List<String> options = List.of(
                "Become a Member", "Donate a Book", "Loan a Book",
                "Return Book", "Exit");

        for (int i = 0; i < options.size(); i++) {
            System.out.println(i+1 + ". " + options.get(i));
        }

        int input = scanner.nextInt();
        switch (input) {
            case 1:
                membership();
                break;
            case 2:
                donation();
                break;
            case 3:
                loan();
                break;
            case 4:
                returnBook();
                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("Enter a number from 1 to 5");
                break;
        }
    }

    private void membership() {
        System.out.println("Fill the credentials to become a member of ReadHaven Library");

        // Make sure usernames not duplicates, add validations where required
        System.out.print("Set Username: ");
        String username = scanner.next();
        System.out.print("Set Password: ");
        String password = scanner.next();
        System.out.print("Enter you email: ");
        String email = scanner.next();
        System.out.print("Enter your current address: ");
        String address = scanner.next();
        System.out.print("Enter your phone number: ");
        String phoneNo = scanner.next();

        Member newMember = new Member(username, email, password, address, phoneNo);
        String response = this.member.register(newMember);
        System.out.println(response);
    }

    private void donation() {
        // login
        // add book info
        // donate
    }

    private void loan() {
        // show collection first
        List<String> bookLoanOptions = List.of("Enter Book Name", "See Collection");
        for (int i = 0; i < bookLoanOptions.size(); i++) {
            System.out.println(i+1 + ". " + bookLoanOptions.get(i));
        }

        int userInput = scanner.nextInt();
        switch (userInput) {
            case 1:
                // look for the book in the book repo via book service
                // if it is available, borrowed, reserved or not exists
                // if exists, call the loan function / module and start loan, or reserve it, if the user can wait for it to return
            case 2:
                // show all book
                // let the user select the book they want
                // (can also show all the books by an author)
        }
    }

    private void returnBook() {
        // login
        // return book
        // retrieve return date
    }
}
