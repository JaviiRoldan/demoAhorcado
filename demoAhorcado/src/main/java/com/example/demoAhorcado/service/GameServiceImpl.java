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


    public void imprimePalabra(String palabraJuego) {
        String palabraActualJuego = " " + palabraJuego.charAt(0) + " ";
        for (int i = 1; i < palabraJuego.length(); i++) {
            if (getGameAhorcado().getListaIndices().contains(i)) {
                palabraActualJuego.concat(String.valueOf(" " + palabraJuego.charAt(i) + " "));

            } else {
                palabraActualJuego.concat(" - ");
            }
        }
        System.out.println(palabraActualJuego);
    }

    public void añadeNuevoIndice(String palabraJuego, String letraEscaneada) {
        if (palabraJuego.contains("" + letraEscaneada)) {
            for (int i = 1; i < palabraJuego.length(); i++) {
                if (letraEscaneada.equals(palabraJuego.charAt(i))) {
                    getGameAhorcado().getListaIndices().add(i);
                }
            }
        }
    }

}
