package com.practica.funcional;

import com.practica.funcional.v10_optional.Flujo;

import java.util.Random;

import static com.practica.funcional.v10_optional.NumbersUtils.esPrimo;

public class Main {

    Random random = new Random();
    public Main(){

        Integer total = Flujo.proveer(10, this::randomInt)
                .filtrar(valor -> esPrimo(valor))
                .transformar(valor -> valor * valor)
                .actuar(valor -> System.out.println(valor))
                .reducir(0,(valor1, valor2) -> valor1 + valor2);
        System.out.println("Reducción: " + total);

    }

    public static void main(String[] args) {new Main();}

    private int randomInt(){ return random.nextInt(10);}
}