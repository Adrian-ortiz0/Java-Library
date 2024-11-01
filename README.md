# Java Library

Este programa en java tiene la tarea de gestionar todo lo relacionado con libros y ensayos cientificos dentro de una libreario, permitiendo asi al administrador poderse encargar de tareas relacionadas con la venta de libros, prestamos
devoluciones, control de inventario, creación de usuarios, entre otras tareas importantes. Cabe recalcar que este proyecto unicamente funciona a través de la consola, debido a que fue realizado con fines de practicar mis habilidades en este lenguaje
de programacion

## Tabla de contenido 

| Indice | Titulo          |
| ------ | --------------- |
| 1      | Requisitos del Sistema      |
| 2      | Instalación     |
| 3      | Clases creadas  |
| 4      | Funcionalidades |
| 5      | Licencia        |
| 6      | Creador         |

## Requisitos del Sistema

- **JDK** (Version 8 o superior): Java Development Kit, este es escencial para poder realizar ajustes al proyecto y poder correr el programa sin complicacion alguna ocasionada por falta de funcionalidades no agregadas
- **Net Beans** (Version 2.01 o superior): Debido a que el proyecto fue creado en el entorno de NetBeans es recomendable usar este con el fin de evitar problemas a la hora de ejecucion.

## Instalación

- Abre NetBeans: Inicia la aplicación.

- Accede al menú de Git:

- Ve a Team en la barra de menú.
  Selecciona Git y luego Clone....
  Introduce la URL del repositorio: https://github.com/Adrian-ortiz0/Java-Library/new/master?filename=README.md

- En la ventana que aparece, ingresa la URL del repositorio que deseas clonar. Asegúrate de que sea una URL válida (por ejemplo, una URL de GitHub).
  Configura el directorio local:

- Elige el directorio donde deseas clonar el repositorio en tu máquina local.

- Si el repositorio es privado, es posible que debas ingresar tus credenciales de GitHub o del servicio que estés utilizando.
  Clona el repositorio:

- Haz clic en Finish para completar el proceso de clonación

## Clases creadas

- **LibrAry Item** Library item funciona como una clase padre para book y scientific essay

  public class LibraryItem {
    
    private String title;
    private String code;
    private boolean available;
    private int date;
    private String author;
    private int stock;
  }

- **Book** Clase encargada de todos los procesos referentes a los libros
  
  public class Book extends LibraryItem{
    
    private String category;
    
    public Book(String title, String author, String code, int date, String category) {
        super(title, author, code, date);
        this.category = category;
    }
  
- **Scientific Essay** Clase encargada de todos los procesos referentes a los ensayos cientificos

  public class ScientificEssays extends LibraryItem{
    
    private String subject;
    
    public ScientificEssays(String title, String author, String code, int date, String subject) {
        super(title, author, code, date);
        this.subject = subject;
    }

- **User** Clase encargada de la creación de usuarios y su gestion

  public class User {
    
    private String name;
    private String id;
    private ArrayList<Book> bookList;
    
    public User(String name, String id){
        
        this.bookList = new ArrayList();
        this.id = id;
        this.name = name;
    }

- **UI** UI es la clase encargada de la gestion de la interfaz de usuario con los diversos procesos en el App

  public class UI {
    
    private Scanner scan;
    private LibraryManager manager;
    private User user;
    
    public UI(){
        this.scan = new Scanner(System.in);
        this.manager = new LibraryManager();
        this.user = new User();
    }

- **App** Desde esta clase debe ejecutarse el programa para poder iniciar correctamente a trabajar con los diversos procesos

  public class App {

    public static void main(String[] args) {
        UI ui = new UI();
        ui.start();
    }
}

## Funcionalidades

1. Prestamos de libros y ensayos cientificos
2. Consulta de precios de libros y ensayos cientificos
3. Busqueda por año y autor de libros y ensayos cientificos
4. Ver la cantidad de libros dentro de la libreria
5. Devolucion de libros y ensayos cientificos
6. Agregar libros y ensayos
7. Eliminar libros y ensayos
8. Registrar usuarios
9. Busqueda de libros y ensayos por palabras
10. Busqueda de libros por categorias
11. Busqueda de libros por generos
12. Buscar ensayos por materia
13. Verificacion de libros prestados a usaurios

## Licencia

Este proyecto está licenciado bajo la Licencia MIT. 

[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)


## Contacto

Si tienes alguna pregunta o deseas más información, no dudes en contactarnos:

- **Nombre**: Adrian
- **Correo electrónico**: [dxniel7328@gmail.com](mailto:tu.dxniel7328@gmail.com)
- **GitHub**: [https://github.com/Adrian-ortiz0](https://github.com/Adrian-ortiz0)
