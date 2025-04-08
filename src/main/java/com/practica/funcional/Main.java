package com.practica.funcional;

import com.practica.funcional.v10_optional.Flujo;
import com.practica.funcional.v10_optional.NumbersUtils;

import java.util.Random;

import static com.practica.funcional.v10_optional.NumbersUtils.elevarAlCuadrado;
import static com.practica.funcional.v10_optional.NumbersUtils.esPrimo;

public class Main {

    Random random = new Random();
    public Main(){

        Integer total = Flujo.proveer(10, this::randomInt)
                .filtrar(NumbersUtils::esPrimo)
                .transformar(NumbersUtils::elevarAlCuadrado)
                .actuar(System.out::println)
                .reducir(0, Integer::sum);
        System.out.println("Reducción: " + total);

    }

    public static void main(String[] args) {new Main();}

    private int randomInt(){ return random.nextInt(10);}
}