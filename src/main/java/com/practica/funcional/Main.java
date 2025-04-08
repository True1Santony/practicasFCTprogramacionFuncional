package com.practica.funcional;

import com.practica.funcional.v10_optional.Descripcion;
import com.practica.funcional.v10_optional.Flujo;
import com.practica.funcional.v10_optional.NumbersUtils;

import java.util.Random;

public class Main {

    Random random = new Random();
    public Main(){

        Integer total = Flujo.proveer(10, this::randomInt)
                .filtrar(NumbersUtils::esPrimo)
                .ordenar(Integer::compareTo)
                .transformar(NumbersUtils::elevarAlCuadrado)
                .transformar(Descripcion::new)
                .actuar(System.out::println)
                .transformar(Descripcion::getValue)
                .reducir(0, Integer::sum);
        System.out.println("Reducción: " + total);

    }

    public static void main(String[] args) {new Main();}

    private int randomInt(){ return random.nextInt(10);}
}