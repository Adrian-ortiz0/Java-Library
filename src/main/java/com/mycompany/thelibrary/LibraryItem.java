/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thelibrary;

/**
 *
 * @author Danie
 */
public class LibraryItem {
    
    private String title;
    private String code;
    private boolean available;
    private int date;
    private String author;
    private int stock;
    
    public LibraryItem(String title, String author, String code, int date){
        this.author = author;
        this.code = code;
        this.date = date;
        this.title = title;
        this.stock = 1;
        this.available = true;
        
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
public String toString(){
    return "Title: " + this.title + ", " + "Author: " + this.author + ", " + "Code: " + this.code + ", " + "Release year: " + this.date + ", " + "Available: " + this.available + ", " + "Stock: " + this.stock;
}    
}
