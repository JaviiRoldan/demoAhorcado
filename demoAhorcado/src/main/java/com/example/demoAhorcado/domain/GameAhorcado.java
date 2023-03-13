package com.example.demoAhorcado.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class GameAhorcado {
    private String palabraAcertar;
    private List<Integer> listaIndices = new ArrayList<>();
    public GameAhorcado() {}
    public GameAhorcado(String palabraAcertar) {this.palabraAcertar = palabraAcertar;}
    public String getPalabraAcertar() {
        return this.palabraAcertar;
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

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Integer getTamañoPalabra(){
        return palabraAcertar.length();
    }

    public void setLetraNueva(Integer indiceletraNueva){
        List<Integer> nuevaLista = getListaIndices();
        nuevaLista.add(indiceletraNueva);
        setListaIndices(nuevaLista);
    }
}
