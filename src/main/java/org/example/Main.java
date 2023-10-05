package org.example;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
        todo:
        Modify the library system
        1. Create an abstract class Item
        2. Create a class Book that implements Item
        3. Create a class DVD that implements Item
        4. Create a class Patron that represents a customer
        5. Create an interface IManageable
        6. Create a class Library that implements IManageable
        7. Create a class TestLibrary to test functionality
        * */
        Library library = new Library();

        Book book1 = new Book("Winnie-the-Pooh", "B00001", "Alan Milne");
        Book book2 = new Book("Alice in Wonderland", "B00002", "Lewis Carroll");
        DVD dvd = new DVD("Lilo & Stitch", "D00001", 85);

        library.addItem(book1);
        library.addItem(book2);
        library.addItem(dvd);

        Patron patron1 = new Patron("Chris White", "P00001");
        Patron patron2 = new Patron("Luisa Smith", "P00002");

        library.registerPatron(patron1);
        library.registerPatron(patron2);

        System.out.println(library.listAvailable());

        library.lendItem(patron1, book2);
        library.lendItem(patron2, dvd);

        System.out.println("Available: ");
        for(Item item : library.listAvailable()){
            System.out.println(item.getTitle());
        }

        System.out.println("Borrowed: ");
        for(Patron patron : library.getPatrons()){
            for(Item item : patron.getBorrowedItems()){
                System.out.println(patron.getName() + ": " + item.getTitle());
            }
        }
    }
}