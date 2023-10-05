package org.example;

public class Book extends Item{
    private String author;
    public Book(String title, String uniqueId, String author){
        super(title, uniqueId);
        this.author = author;
    }
    public String getAuthor(){
        return author;
    }
    @Override
    public void borrowItem(){
        setIsBorrowed(true);
    }
    @Override
    public void returnItem(){
        setIsBorrowed(false);
    }
}
