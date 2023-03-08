package com.example.demoAhorcado.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneraPalabraAhorcado {
    private final List<String> palabrasJuego = new ArrayList<>();
    public GeneraPalabraAhorcado() {
        this.palabrasJuego.add("Permuta");
        this.palabrasJuego.add("Accion");
        this.palabrasJuego.add("Monitor");
        this.palabrasJuego.add("Estructura");
        this.palabrasJuego.add("Pelicula");
        this.palabrasJuego.add("Actor");
        this.palabrasJuego.add("Zizaya");
        this.palabrasJuego.add("Movimiento");
        this.palabrasJuego.add("Equis");
        this.palabrasJuego.add("Ursula");
    }
    public List<String> getPalabrasJuego() {
        return palabrasJuego;
    }

    public String generaPalabraRandom(){
        int n = (int)(Math.random()*10+1);
        return palabrasJuego.get(n);
    }
}
