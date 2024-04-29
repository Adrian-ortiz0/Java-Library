/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thelibrary;

/**
 *
 * @author Danie
 */
public class Book extends LibraryItem{
    
    private String category;
    
    public Book(String title, String author, String code, int date, String category) {
        super(title, author, code, date);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", " + "Category: " + this.getCategory();
    }
    
    public void increaseStock(){
        super.setStock(super.getStock() + 1);
        super.setAvailable(true);
    }
    
    public void decreaseStock(){
        if(super.getStock() > 1){
            super.setStock(super.getStock() - 1);
        } else {
            super.setStock(0);
            super.setAvailable(false);
        }
    }

    
}
