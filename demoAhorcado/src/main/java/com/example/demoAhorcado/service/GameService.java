package com.example.demoAhorcado.service;

import com.example.demoAhorcado.domain.GameAhorcado;

public interface GameService {

    public void IniJuego();
    public GameAhorcado getGameAhorcado();
    public void setGameAhorcado(GameAhorcado gameAhorcado);
    public Integer getCuentaFallos();
    public Integer getLimiteFallos();
    public void imprimePalabra(String palabraJuego);
    public void añadeNuevoIndice(String palabraJuego, String letraEscaneada);


        public Integer setOneLessOportunity();
}
