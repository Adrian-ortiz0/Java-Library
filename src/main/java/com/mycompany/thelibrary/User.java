/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thelibrary;

import java.util.ArrayList;

/**
 *
 * @author Danie
 */
public class User {
    
    private String name;
    private String id;
    private ArrayList<Book> bookList;
    
    public User(String name, String id){
        
        this.bookList = new ArrayList();
        this.id = id;
        this.name = name;
    }
    public User(){
        
    }
    
    public void addBooks(Book book){
        
        bookList.add(book);
    }
    
    public void removeBook(Book book){
        bookList.remove(book);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }
    
    public void printUserBooks(){
        
        for(Book bk : bookList){
            System.out.println(bk.getTitle());
        }
    }
    public void returnBook(Book book){
    if (bookList.contains(book)) {
        bookList.remove(book);
        
    } else {
        System.out.println("El usuario no tiene este libro prestado.");
    }
}
    
    public String toString(){
        return "ID: " + this.id + ", " + "Nombre: " + this.name + ", " + this.getBookList().toString();
    }
    
    
}
