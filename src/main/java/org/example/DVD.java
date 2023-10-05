package org.example;

public class DVD extends Item{
    private int duration;
    public DVD(String title, String uniqueId, int duration){
        super(title, uniqueId);
        this.duration = duration;
    }
    public int getDuration(){
        return duration;
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
