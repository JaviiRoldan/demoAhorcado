package com.example.demoAhorcado.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneraPalabraAhorcado {
    public List<String> GeneraPalabraAhorcadoLista() {
        List<String> listaPalabras = new ArrayList<>();
        listaPalabras.add("Permuta");
        listaPalabras.add("Accion");
        listaPalabras.add("Monitor");
        listaPalabras.add("Estructura");
        listaPalabras.add("Pelicula");
        listaPalabras.add("Actor");
        listaPalabras.add("Zizaya");
        listaPalabras.add("Movimiento");
        listaPalabras.add("Equis");
        listaPalabras.add("Ursula");
        return listaPalabras;
    }
    public String generaPalabraRandom(){
        int n = (int)(Math.random()*10+1);
        List<String> listaPalabras = GeneraPalabraAhorcadoLista();
        return  listaPalabras.get(n);
    }
}
