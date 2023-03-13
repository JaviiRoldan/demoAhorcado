package com.example.demoAhorcado.service;

import com.example.demoAhorcado.domain.GameAhorcado;

public interface GameService {

    public GameAhorcado IniJuego();
    public GameAhorcado getGameAhorcado();
    public void setGameAhorcado(GameAhorcado gameAhorcado);
    public Integer getCuentaFallos();
    public void imprimePalabra(GameAhorcado gameAhorcado);
    public GameAhorcado añadeNuevoIndice(GameAhorcado gameAhorcado, String letraEscaneada);
    public Integer setOneLessOportunity();
}
