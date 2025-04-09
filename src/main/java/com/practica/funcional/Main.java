package com.practica.funcional;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Main {

    Random random = new Random();
    public Main(){
      /*  List<String> nombres = Stream.of("Manolo", "espartaco", "Sandra", "Amanda", "Marian")
                .filter(nombre -> nombre.contains("o"))
                .limit(1)
                .toList();
        System.out.println(nombres);*/
/*
        List<Integer> resultado = Stream.generate(() -> {
            int next = random.nextInt(10);
            System.out.printf("Se ha generado el %d\n", next);
            return next;
                }).limit(20)//Ejecucion lazy, llama las veces que se le limite si no, infinito
                .toList();
        System.out.println(resultado);

        //valor inicial y una funcion unaria que determina como va a operar el sigiente, se agrega una condicion (valor, predicado, funcion unaria)
        List<Integer> resultadoIterado = Stream.iterate(1, valor -> valor <1000,valor -> valor * 2)
                .toList();
        System.out.println(resultadoIterado);

        List<Integer> resultadoIterado1 = random.ints(10,0,10)
                .boxed()//transformacion al wraper correspondiente, adecuado.
                .toList();
        System.out.println(resultadoIterado1);

        //todos los valores de inicio a  fin 
        List<Integer> resultadoIterado2 = IntStream.rangeClosed(0,10)
                .boxed()
                .toList();
        System.out.println(resultadoIterado2);
        */

        //.forEach(System.out::println)
        //.map(this::getRandomNumbers)
        //.forEach(integerStream -> integerStream.forEach(System.out::println))
        List<Integer> resultado1 = Stream.of(2, 4, 6)
                .flatMap(this::getRandomNumbers)//aplana los 3 stream generados en uno, asi puedo recorrer con foreach e introducirlo en Collections
                .toList();

        System.out.println(resultado1);
    }

    private Stream<Integer> getRandomNumbers(Integer size) {
        return random.ints(size, 0, 10).boxed();
    }


    public static void main(String[] args) {new Main();}

}