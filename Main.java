package com.cts.LibraryManagement;

import java.util.Scanner;
import java.util.ArrayList;
public class Main{
    public static void main(String args[]){
        int choice;
        Library lib = new Library();
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Add Book\n" +
                           "2.Display all book details\n" +
                           "3.Search Book by author\n" +
                           "4.Count number of books - by book name\n" + 
                           "5.Exit");
        System.out.println("Enter your choice:");
        choice = sc.nextInt();
        sc.nextLine();
        switch(choice){
            case 1:{
                Book b = new Book();
                System.out.println("Enter the isbn no:");
                b.setIsbnno(sc.nextInt());
                sc.nextLine();
                System.out.println("Enter the book name:");
                b.setBookName(sc.nextLine());
                System.out.println("Enter the author name:");
                b.setAuthor(sc.nextLine());
                lib.addBook(b);
            }
            break;
            case 2:{
                for(Book b : lib.viewAllBooks()){
                    System.out.println(b.getIsbnno() + "\t" + b.getBookName() + "\t" + b.getAuthor());
                }
                break;
            }
            case 3:{
                String authorName;
                ArrayList<Book> bookByAuthor = new ArrayList<Book>();
                System.out.println("Enter the author name:");
                bookByAuthor = lib.viewBooksByAuthor(sc.nextLine());
                for(Book b : bookByAuthor){
                    System.out.printf("ISBN no: %d\nBook name: %s\nAuthor name: %s\n",b.getIsbnno(),b.getBookName(),b.getAuthor());
                }
            }
            break;
            case 4:{
                int noOfBooks;
                System.out.println(lib.countnoofbook(sc.nextLine()));
            }
            case 5: break;
            default: System.out.println("Enter a valid choice");
        }
    }
}