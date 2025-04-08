package com.practica.funcional;

import com.practica.funcional.v10_optional.Descripcion;
import com.practica.funcional.v10_optional.Flujo;
import com.practica.funcional.v10_optional.NumbersUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Main {

    Random random = new Random();
    public Main(){
        ArrayList<String> nombres = new ArrayList<>(List.of("Manolo", "espartaco", "Sandra", "Amanda", "Marian"));
       // nombres.forEach(System.out::println); // como un for normal.

        //1. Funcion generadora de stream.
        nombres.stream()
                //2. 0 o mas operacione intermedias
                .filter(nombre -> nombre.contains("o"))
               // .map(nombre -> nombre.length())
                //3. operacion terminal
                .forEach(System.out::println);

        //Resumen: Producir, procesar y consumir.
/*
        Flujo.proveer(10, this::randomInt)
                .filtrar(valor -> valor >= 0)//NoSuchElementException, lista vacia, si se filtra por un numero superior al generado por random (10)
                .ordenar(Integer::compareTo)
                .transformar(NumbersUtils::elevarAlCuadrado)
                .transformar(Descripcion::new)
                .actuar(System.out::println)
                .transformar(Descripcion::getValue)
                .max(Comparator.naturalOrder())
                .ifPresentOrElse(
                        valor -> System.out.println("Maximo: " + valor.doubleValue()),
                        ()-> System.out.println("No hay maximo porque el flujo esta vacio")
                );
                */

    }


    public static void main(String[] args) {new Main();}

    private int randomInt(){ return random.nextInt(10);}
}