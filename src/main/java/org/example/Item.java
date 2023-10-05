package org.example;

public abstract class Item {
    private String title;
    private String uniqueId;
    private boolean isBorrowed;
    public Item(String title, String uniqueId){
        this.title = title;
        this.uniqueId = uniqueId;
        this.isBorrowed = false;
    }
    public String getTitle(){
        return title;
    }
    public String getUniqueId(){
        return uniqueId;
    }
    public boolean getIsBorrowed(){
        return isBorrowed;
    }
    public void setIsBorrowed(boolean borrowed){
        isBorrowed = borrowed;
    }

    public abstract void borrowItem();
    public abstract void returnItem();

}
