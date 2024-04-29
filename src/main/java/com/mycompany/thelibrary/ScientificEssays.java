/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thelibrary;

/**
 *
 * @author Danie
 */
public class ScientificEssays extends LibraryItem{
    
    private String subject;
    
    public ScientificEssays(String title, String author, String code, int date, String subject) {
        super(title, author, code, date);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", " + "Subject: " + this.getSubject();
    }
    
}
