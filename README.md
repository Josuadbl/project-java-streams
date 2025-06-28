## Evaluacion

Preguntas: 

1 - ¿Qué operador usarías para transformar una lista de títulos a mayúsculas?
    R = Usaría map() junto con String::toUpperCase o getTitle().toUpperCase():

        java
        Copiar código
        books.stream()
            .map(book -> book.getTitle().toUpperCase())
            .forEach(System.out::println);

2 - ¿Cómo verificarías si todos los libros cuestan menos de $100?
    R = Para verificar si todos los libros cuestan menos de $100, podemos usar el método allMatch del API de Streams: 
        System.out.println("\n11. ¿Todos los libros cuestan menos de $100?");
        boolean todosMenosDe100 = books.stream()
            .allMatch(book -> book.getPrice() < 100);
        System.out.println("¿Todos cuestan menos de $100? " + todosMenosDe100);

3 - Escribe una expresión lambda que retorne true si el autor es "Gabriel García Márquez".
    R = book -> book.getAuthor().equals("Gabriel García Márquez")