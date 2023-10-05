package org.example;

public abstract class Item {
    private String title;
    private String uniqueId;
    private String author;
    public Item(String title, String uniqueId, String author){
        this.title = title;
        this.uniqueId = uniqueId;
        this.author = author;
    }
    public String getTitle(){
        return title;
    }
    public String getUniqueId(){
        return uniqueId;
    }
    public String getAuthor(){
        return author;
    }

    public abstract void borrowItem();
    public abstract void returnItem();

}
