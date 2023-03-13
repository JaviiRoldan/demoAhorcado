package com.example.demoAhorcado.service;

import com.example.demoAhorcado.domain.GameAhorcado;
import com.example.demoAhorcado.domain.GeneraPalabraAhorcado;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService{
    private GameAhorcado gameAhorcado;
    private Integer cuentaFallos;
    public GameServiceImpl() {}
    public GameServiceImpl(GameAhorcado gameAhorcado) {
        this.gameAhorcado = gameAhorcado;
        this.cuentaFallos = 8;
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
    public void setCuentaFallos(Integer cuentaFallos) {
        this.cuentaFallos = cuentaFallos;
    }
    public Integer setOneLessOportunity(){
        this.cuentaFallos = cuentaFallos--;
        return cuentaFallos;
    }


    public GameAhorcado IniJuego(){
        GeneraPalabraAhorcado generaPalabraAhorcado = new GeneraPalabraAhorcado();
        String palabraJuego = generaPalabraAhorcado.generaPalabraRandom();

        GameAhorcado gameAhorcado1 = new GameAhorcado(palabraJuego);
        setCuentaFallos(8);
        return gameAhorcado1;
    }
    public void imprimePalabra(GameAhorcado gameAhorcado) {
        String nuevaPalabra = " " + gameAhorcado.getPalabraAcertar().charAt(0) + " ";
        for (int i = 1; i < gameAhorcado.getTamañoPalabra(); i++) {
            if (gameAhorcado.getListaIndices().contains(i)) {
                nuevaPalabra+=" " + gameAhorcado.getPalabraAcertar().charAt(i) + " ";
            } else {
                nuevaPalabra+=" - ";
            }
        }

        System.out.println(nuevaPalabra);
    }

    public GameAhorcado añadeNuevoIndice(GameAhorcado gameAhorcado, String letraEscaneada) {
        if (gameAhorcado.getPalabraAcertar().contains(letraEscaneada)) {
            for (int i = 1; i < gameAhorcado.getPalabraAcertar().length(); i++) {
                if (letraEscaneada.equals(gameAhorcado.getPalabraAcertar().charAt(i))) {
                    //gameAhorcado.getListaIndices().add(i);
                    gameAhorcado.setLetraNueva(i);                }
            }
        }else{
            System.out.println("Mala suerte, te quedan " + getCuentaFallos());
        }
        //GameAhorcado gameAhorcado1 = gameAhorcado;
        return gameAhorcado;
    }

}
