import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
            new Book("El Quijote", "Cervantes", 39.99),
            new Book("Cien años de soledad", "Gabriel García Márquez", 45.50),
            new Book("Clean Code", "Robert C. Martin", 55.00),
            new Book("Effective Java", "Joshua Bloch", 70.00),
            new Book("The Pragmatic Programmer", "Andy Hunt", 65.00),
            new Book("1984", "George Orwell", 35.00),
            new Book("Brave New World", "Aldous Huxley", 40.00),
            new Book("Java Concurrency", "Brian Goetz", 60.00),
            new Book("Refactoring", "Martin Fowler", 68.00),
            new Book("Harry Potter", "J.K. Rowling", 25.00),
            new Book("Crónicas de una muerte anunciada", "Gabriel García Márquez", 30.00),
            new Book("El amor en los tiempos del cólera", "Gabriel García Márquez", 48.00),
            new Book("Programación Estructurada", "Carlos Pérez", 20.00),
            new Book("Estructuras de Datos", "Laura Gómez", 33.00),
            new Book("Aprendiendo Java", "Pedro Díaz", 45.00),
            new Book("Cálculo I", "Eduardo López", 55.00),
            new Book("Física Universitaria", "Tipler", 62.00),
            new Book("Los Miserables", "Victor Hugo", 38.00),
            new Book("Hamlet", "Shakespeare", 42.00),
            new Book("Macbeth", "Shakespeare", 39.00),
            new Book("Romeo y Julieta", "Shakespeare", 35.00),
            new Book("Don Juan Tenorio", "Zorrilla", 29.00),
            new Book("Software Engineering", "Ian Sommerville", 58.00),
            new Book("Modern Operating Systems", "Andrew Tanenbaum", 70.00),
            new Book("Artificial Intelligence", "Stuart Russell", 80.00),
            new Book("Compilers", "Aho & Ullman", 73.00),
            new Book("Design Patterns", "GoF", 65.00),
            new Book("Java para principiantes", "Luis Martínez", 27.00),
            new Book("El Señor de los Anillos", "J.R.R. Tolkien", 66.00),
            new Book("El Hobbit", "J.R.R. Tolkien", 44.00),
            new Book("La Odisea", "Homero", 32.00),
            new Book("La Ilíada", "Homero", 33.00),
            new Book("El Código Da Vinci", "Dan Brown", 39.00),
            new Book("Ángeles y Demonios", "Dan Brown", 41.00),
            new Book("Inferno", "Dan Brown", 42.00),
            new Book("Origen", "Dan Brown", 40.00),
            new Book("Sapiens", "Yuval Noah Harari", 50.00),
            new Book("Homo Deus", "Yuval Noah Harari", 55.00),
            new Book("21 lecciones", "Yuval Noah Harari", 53.00),
            new Book("Steve Jobs", "Walter Isaacson", 60.00)
        );

        // 1. Mostrar todos los libros
        System.out.println("1. Todos los libros:");
        books.stream().forEach(System.out::println);

        // 2. Libros que cuesten más de $50
        System.out.println("\n2. Libros con precio > $50:");
        books.stream()
             .filter(book -> book.getPrice() > 50)
             .forEach(System.out::println);

        // 3. Títulos en mayúsculas
        System.out.println("\n3. Títulos en mayúsculas:");
        books.stream()
             .map(book -> book.getTitle().toUpperCase())
             .forEach(System.out::println);

        // 4. Recopilar libros baratos (< $50)
        System.out.println("\n4. Libros baratos (< $50):");
        List<Book> cheapBooks = books.stream()
            .filter(book -> book.getPrice() < 50)
            .collect(Collectors.toList());
        cheapBooks.forEach(System.out::println);

        // 5. Precio total
        System.out.println("\n5. Precio total:");
        double totalPrice = books.stream()
            .map(Book::getPrice)
            .reduce(0.0, Double::sum);
        System.out.println("Total: $" + totalPrice);

        // 6. ¿Hay libro de Robert C. Martin?
        System.out.println("\n6. ¿Hay libro de Robert C. Martin?");
        boolean hasMartin = books.stream()
            .anyMatch(book -> book.getAuthor().equals("Robert C. Martin"));
        System.out.println("¿Hay? " + hasMartin);

        // 7. Títulos únicos
        System.out.println("\n7. Títulos únicos:");
        books.stream()
             .map(Book::getTitle)
             .distinct()
             .forEach(System.out::println);

        // 8. Limitar y omitir
        System.out.println("\n8. Primeros 2 libros:");
        books.stream()
             .limit(2)
             .forEach(System.out::println);

        System.out.println("\n8. Libros omitidos (primeros 2):");
        books.stream()
             .skip(2)
             .forEach(System.out::println);

        // 9. Ordenar por precio ascendente
        System.out.println("\n9. Libros ordenados por precio:");
        books.stream()
             .sorted(Comparator.comparing(Book::getPrice))
             .forEach(System.out::println);

        // 10. Recomendaciones (< $60 ordenados desc por precio)
        System.out.println("\n10. Recomendaciones (< $60):");
        List<String> recomendaciones = books.stream()
            .filter(book -> book.getPrice() < 60)
            .sorted(Comparator.comparing(Book::getPrice).reversed())
            .map(Book::getTitle)
            .collect(Collectors.toList());
        recomendaciones.forEach(System.out::println);
}
}