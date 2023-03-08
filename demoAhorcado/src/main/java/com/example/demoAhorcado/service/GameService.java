package com.example.demoAhorcado.service;

import com.example.demoAhorcado.domain.GameAhorcado;

public interface GameService {

    public void IniJuego();
    public GameAhorcado getGameAhorcado();
    public void setGameAhorcado(GameAhorcado gameAhorcado);
    public Integer getCuentaFallos();
    public Integer getLimiteFallos();


        public Integer setOneLessOportunity();
}
