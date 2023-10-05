package org.example;

import java.util.ArrayList;
import java.util.List;

public class Library implements IManageable{
    private List<Item> items;
    private List<Patron> patrons;
    public Library(){
        this.items = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }
    public void registerPatron(Patron patron){
        patrons.add(patron);
    }
    public void lendItem(Patron patron, Item item){
        if(patrons.contains(patron) && !item.getIsBorrowed()){
            patron.borrowItem(item);
            item.borrowItem();
        }
    }
    public void returnItem(Patron patron, Item item){
        if(patron.getBorrowedItems().contains(item)){
            patron.returnItem(item);
            item.returnItem();
        }
    }
    @Override
    public void addItem(Item item){
        items.add(item);
    }
    @Override
    public void removeItem(Item item){
        items.remove(item);
    }
    @Override
    public void listAvailable(){
        System.out.println("Available items: ");
        for(Item item : items){
            if(!item.getIsBorrowed()){
                System.out.println(item.getTitle());
            }
        }
    }
    @Override
    public void listBorrowed(){
        System.out.println("Borrowed items: ");
        for(Patron patron : patrons){
            for(Item item : patron.getBorrowedItems()){
                System.out.println(patron.getName() + ": " + item.getTitle());
            }
        }
    }
}
