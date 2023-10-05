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
    public List<Patron> getPatrons(){
        return patrons;
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
    public List<Item> listAvailable(){
       List<Item> available = new ArrayList<>();
        for(Item item : items){
            if(!item.getIsBorrowed()){
                available.add(item);
            }
        }
        return available;
    }
    @Override
    public List<Item> listBorrowed(){
        List<Item> borrowed = new ArrayList<>();
        for(Patron patron : patrons){
            borrowed.addAll(patron.getBorrowedItems());
        }
        return borrowed;
    }
}
