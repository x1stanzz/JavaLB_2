package org.example;

public interface IManageable {
    void addItem(Item item);
    void removeItem(Item item);
    void listAvailable();
    void listBorrowed();
}
