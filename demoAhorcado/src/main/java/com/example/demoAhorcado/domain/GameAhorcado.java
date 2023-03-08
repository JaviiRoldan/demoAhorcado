package com.example.demoAhorcado.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class GameAhorcado {
    private String palabraAcertar;



    private List<Integer> listaIndices;


    public GameAhorcado(String palabraAcertar) {

        this.palabraAcertar = palabraAcertar;
        this.listaIndices = new ArrayList<>();
    }
    public String getPalabraAcertar() {
        return palabraAcertar;
    }

    public void setPalabraAcertar(String palabraAcertar) {
        this.palabraAcertar = palabraAcertar;
    }
    public List<Integer> getListaIndices() {
        return listaIndices;
    }

    public void setListaIndices(List<Integer> listaIndices) {
        this.listaIndices = listaIndices;
    }
    public Integer getTamañoPalabra(){
        return palabraAcertar.length();
    }


}
