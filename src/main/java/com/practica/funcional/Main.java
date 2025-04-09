package com.practica.funcional;

import com.practica.funcional.v10_optional.Descripcion;

import java.util.Random;
import java.util.stream.Stream;


public class Main {

    Random random = new Random();
    public Main(){
      random.ints(10, 1,11)
              .boxed()
              .filter(valor -> valor >= 5)
              .sorted(Integer::compareTo)
              .map(valor -> valor * valor)
              .map(Descripcion::new)
//              .peek(System.out::println)
              .map(Descripcion::getValue)
              .forEach(valor -> System.out.print(valor + "  "));
//              .reduce(0, Integer::sum);



    }

    private Stream<Integer> getRandomNumbers(Integer size) {
        return random.ints(size, 0, 10).boxed();
    }


    public static void main(String[] args) {new Main();}

}