/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thelibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Danie
 */
public class UI {
    
    private Scanner scan;
    private LibraryManager manager;
    private User user;
    
    public UI(){
        this.scan = new Scanner(System.in);
        this.manager = new LibraryManager();
        this.user = new User();
    }
    
    public void start(){
        
        
        while(true){
            
        System.out.println("Bienvenido al sistema de gestión de la biblioteca Adrián Ortiz II, que deseas hacer hoy? ");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("1 - Agregar un libro");
        System.out.println("2 - Eliminar un libro");
        System.out.println("3 - Mostrar todos los libros");
        System.out.println("4 - Agregar un ensayo");
        System.out.println("5 - Eliminar un ensayo");
        System.out.println("6 - Mostrar todos los ensayos");
        System.out.println("7 - Mas opciones con los libros");
        System.out.println("8 - Mas opciones con los ensayos");
        System.out.println("9 - Registrar usuarios");
        System.out.println("10 - Prestar libro un usuario");
        System.out.println("11 - Devolución de libro");
        System.out.println("0 - Salir");
        
        String input = scan.nextLine();
            if(input.equals("1")){
                System.out.println("Titulo: ");
                String title = scan.nextLine();
                System.out.println("Autor: ");
                String author = scan.nextLine();
                System.out.println("Codigo: ");
                String code = scan.nextLine();
                System.out.println("Fecha: ");
                int date = Integer.parseInt(scan.nextLine());
                System.out.println("Categoria: ");
                String category = scan.nextLine();
                Book book = new Book(title, author, code, date, category);
                manager.addBooks(book);
                System.out.println("Libro agregado con exito!");
                
            } else if(input.equals("2")){
                System.out.println("Nombre del libro que deseas eliminar");
                String removeName = scan.nextLine();
                manager.removeBooks(removeName);
            } else if(input.equals("3")){
                manager.printBooks();
            } else if(input.equals("4")){
                System.out.println("Titulo: ");
                String title = scan.nextLine();
                System.out.println("Autor: ");
                String author = scan.nextLine();
                System.out.println("Codigo: ");
                String code = scan.nextLine();
                System.out.println("Fecha: ");
                int date = Integer.parseInt(scan.nextLine());
                System.out.println("Materia: ");
                String subject = scan.nextLine();
                ScientificEssays essay = new ScientificEssays(title, author, code, date, subject);
                manager.addEssays(essay);
            } else if(input.equals("5")){
                System.out.println("Nombre del ensayo a eliminar");
                String removeName = scan.nextLine();
                manager.removeEssays(removeName);
            } else if(input.equals("6")){
                manager.printEssays();
            } else if(input.equals("7")){
                System.out.println("1 - Busqueda por categorias");
                System.out.println("2 - Busqueda por caracter");
                String anotherInput = scan.nextLine();
                if(anotherInput.equals("1")){
                    System.out.println("Escribe la categoria: ");
                    String category = scan.nextLine();
                    manager.printBooksByCategory(category);
                } else if(anotherInput.equals("2")){
                    System.out.println("Pon una letra o palabra: ");
                    String word = scan.nextLine();
                    manager.printBooksByCharacter(word);
                }
                scan.next();
            } else if(input.equals("8")){
                System.out.println("1 - Busqueda por materias");
                System.out.println("2 - Busqueda por años");
                String anotherInput = scan.nextLine();
                if(anotherInput.equals("1")){
                    System.out.println("Materia de la que deseas ver ensayos: ");
                    String subject = scan.nextLine();
                    manager.printEssaysBySubject(subject);
                } else if(anotherInput.equals("2")){
                    System.out.println("De que año quieres ver ensayos cientificos?: ");
                    int year = Integer.parseInt(scan.nextLine());
                    manager.printEssaysByYears(year);
                }
                scan.next();
            } else if(input.equals("0")){
                System.out.println("Hasta la proxima!");
                break;
            } else if(input.equals("9")){
                System.out.println("Nombre: ");
                String name = scan.nextLine();
                System.out.println("ID: ");
                String id = scan.nextLine();
                User user = new User(name, id);
                manager.addUser(user);
                System.out.println("Usuario agregado con exito!");
            } else if(input.equals("10")){
                System.out.println("Id del usuario al que le vamos a prestar el libro");
                String id = scan.nextLine();
                System.out.println("Nombre del libro que vamos a prestar: ");
                String title = scan.nextLine();
                
                for(Book bk : manager.getBooks().values()){
                    if(bk.getTitle().equalsIgnoreCase(title)){
                     for(User u : manager.getUserList().values()){
                        if(u.getId().equalsIgnoreCase(id)){
                            manager.prestarLibro(bk, id);
                            System.out.println("Libro presatado con exito");
                        }
                    }   
                    }
                }                   
            } else if(input.equals("11")) {
                System.out.println("ID del usuario que va a devolver el libro: ");
                String id = scan.nextLine();

                ArrayList<Book> userBookList = manager.getUserBookList(id);

                if(userBookList.isEmpty()) {
                    System.out.println("El usuario no tiene libros prestados.");
                    return;
                }

                System.out.println("Libros prestados por el usuario:");
                for(Book bk : userBookList) {
                    System.out.println(bk.getTitle());
                }

                System.out.println("Escriba el título del libro que desea devolver: ");
                String title = scan.nextLine();

                boolean bookFound = false;
                for(Book bk : userBookList) {
                    if(bk.getTitle().equalsIgnoreCase(title)) {
                        manager.returnBook(bk, id); // Utiliza el método de la clase LibraryManager para devolver el libro
                        bookFound = true;
                        break; 
                    }
                }

                if(bookFound) {
                    System.out.println("Libro devuelto exitosamente.");
                } else {
                    System.out.println("El usuario no tiene un libro con ese título prestado.");
                }
                
            } else if(input.equals("12")){
                System.out.println("Id del usaurio del que quiere ver libros");
                String id = scan.nextLine();
                for(User u : manager.getUserList().values()){
                    if(u.getId().equalsIgnoreCase(id)){
                        u.printUserBooks();
                    }
                }
            }
            
        }
    }
}
