package com.practica.funcional;

import com.practica.funcional.v10_optional.Descripcion;
import com.practica.funcional.v10_optional.Flujo;
import com.practica.funcional.v10_optional.NumbersUtils;

import java.util.Comparator;
import java.util.Random;

public class Main {

    Random random = new Random();
    public Main(){

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
                );//primer argumento si esta presente lo trata, segundo(Runnable) trata el caso de null
    //            .reducir(0, Integer::sum);
      //  double maximoDouble = total.orElse(0).doubleValue(); caso de sustituir por un valor si el Optional esta vacio
       // double maximoDouble = total.orElseThrow(); lanza la excepcion en el caso e que Sea null
       // double maximoDouble = total.orElseGet(()-> getValorSiNoHayMaximo()); ejecutar un metodo en caso de null
        //double maximoDouble = total//recibe un consumidor del valor
        //System.out.println("Máximo: " + maximoDouble);
    }

    private Integer getValorSiNoHayMaximo() {
        return 0;
    }

    public static void main(String[] args) {new Main();}

    private int randomInt(){ return random.nextInt(10);}
}