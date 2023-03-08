package com.example.demoAhorcado.service;

import com.example.demoAhorcado.domain.GameAhorcado;
import com.example.demoAhorcado.domain.GeneraPalabraAhorcado;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService{
    private GameAhorcado gameAhorcado;
    private Integer cuentaFallos;
    private Integer limiteFallos=8;


    public GameServiceImpl() {
        this.cuentaFallos = 0;
    }

    public void IniJuego(){
        GeneraPalabraAhorcado generaPalabraAhorcado = new GeneraPalabraAhorcado();
        String palabraJuego = generaPalabraAhorcado.generaPalabraRandom();

        this.gameAhorcado = new GameAhorcado(palabraJuego);
    }

    public GameAhorcado getGameAhorcado() {
        return gameAhorcado;
    }
    public void setGameAhorcado(GameAhorcado gameAhorcado) {
        this.gameAhorcado = gameAhorcado;
    }
    public Integer getCuentaFallos() {
        return cuentaFallos;
    }
    public Integer getLimiteFallos() {
        return limiteFallos;
    }
    public Integer setOneLessOportunity(){
        this.cuentaFallos = cuentaFallos--;
        return cuentaFallos--;
    }

}
