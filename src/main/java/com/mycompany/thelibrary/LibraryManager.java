/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thelibrary;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.stream.Collector;

/**
 *
 * @author Danie
 */
public class LibraryManager {
    
    private TreeMap<String, Book> books;
    private HashMap<String, ScientificEssays> essays;
    private HashMap<String, User> userList;
    
    public LibraryManager(){
        this.books = new TreeMap();
        this.essays = new HashMap();
        this.userList = new HashMap();
    }
    
    public void addBooks(Book book){
        
        Book existingBook = books.get(book.getTitle());
    if (existingBook != null && existingBook.getAuthor().equalsIgnoreCase(book.getAuthor())) {
        // Si el libro ya existe, incrementar el stock
        existingBook.increaseStock();
    } else {
        // Si el libro no existe, agregarlo al TreeMap
        books.put(book.getTitle(), book);
    }
        
    }

    public TreeMap<String, Book> getBooks() {
        return books;
    }

    public HashMap<String, User> getUserList() {
    return userList;
}
    
    
    public void addEssays(ScientificEssays essay){
        
        essays.putIfAbsent(essay.getTitle(), essay);
        
    }
    
    public void removeBooks(String title){
        
        if(books.isEmpty()){
            throw new IllegalStateException("La libreria esta vacia");
        } else {
            for(String str : books.keySet()){
                if(title.equalsIgnoreCase(str)){
                    books.remove(str);
                }
            }
        }       
    }
    
    public void removeEssays(String title){
        if(essays.isEmpty()){
            throw new IllegalStateException("la seccion de ensayos esta vacia");
        } else {
            for(String str : essays.keySet()){
                if(title.equalsIgnoreCase(str)){
                    essays.remove(str);
                }
            }
        }
    }    
    
    public void printBooks(){
        System.out.println("Libros: ");
        books.values().forEach(System.out::println); // Imprimir los detalles de los libros
    }
    public void printEssays(){
        System.out.println("Ensayos: ");
        essays.values().forEach(System.out::println);
    }
    
    public void printBooksByCharacter(String letter){
        
        books.values().stream()
                .filter(book -> book.getTitle().toLowerCase().contains(letter.toLowerCase())).forEach(s -> System.out.println(s));        
    }
    
    public void printBooksByCategory(String category){
        
        for(Book bk : books.values()){
            if(!bk.getCategory().equals(category)){
                throw new IllegalStateException("No hay libros de esa categoria");
            }
        }
        
        books.values().stream()
                .filter(books -> books.getCategory().toLowerCase().equals(category.toLowerCase())).forEach(System.out::println);        
    }
    
    public void printEssaysBySubject(String subject){
        
        for(ScientificEssays sf : essays.values()){
            if(!sf.getSubject().equals(subject)){
                throw new IllegalStateException("No hay ensayos de esa materia");
            }
        }
        essays.values().stream()
                .filter(e -> e.getSubject().toLowerCase().equalsIgnoreCase(subject.toLowerCase())).forEach(System.out::println);
        
    }
    
    public void printEssaysByYears(int year) {
    boolean found = false;

    // Establecer los límites de los años de acuerdo con el año proporcionado
    int startYear, endYear;
    if (year < 1800 || year > 2026) {
        System.out.println("No existen ensayos en ese período.");
        return;
    } else if (year < 1900) {
        startYear = 1800;
        endYear = 1900;
    } else if (year < 2000) {
        startYear = 1900;
        endYear = 2000;
    } else {
        startYear = 2000;
        endYear = 2026;
    }

    for (ScientificEssays sf : essays.values()) {
        int essayYear = sf.getDate();

        if (essayYear >= startYear && essayYear <= endYear) {
            System.out.println(sf.toString());
            found = true;
        }
    }

    if (!found) {
        System.out.println("No existen ensayos en ese período.");
    }
}
    
    public void addUser(User user){
        userList.putIfAbsent(user.getId(), user);
    }
    
    public Book getBookByTitle(String title){
        return books.get(title);
    }
    
    public void prestarLibro(Book book, String id){
        if (book.getStock() > 0) {
            User user = userList.get(id);
            if (user != null) {
                user.addBooks(book);
                book.decreaseStock();
            }
        } else {
            System.out.println("No hay suficiente stock de este libro.");
        }
    }
    
    public ArrayList<Book> getUserBookList(String id){
        User user = userList.get(id);
        if (user != null) {
            return user.getBookList();
        }
        return new ArrayList<>();
    }
    
     public void returnBook(Book book, String id){
        User user = userList.get(id);
        if (user != null) {
            user.returnBook(book);
            book.increaseStock();
        }
    }
     
    
    
}
