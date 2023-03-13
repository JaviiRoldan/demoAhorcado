package com.example.demoAhorcado.consola;

import com.example.demoAhorcado.domain.GameAhorcado;
import com.example.demoAhorcado.domain.GeneraPalabraAhorcado;
import com.example.demoAhorcado.service.GameService;
import com.example.demoAhorcado.service.GameServiceImpl;
import org.springframework.stereotype.Controller;
import javax.annotation.PostConstruct;
import java.util.Scanner;

@Controller
public class ConsolaReader {
    private GameService gameService;
    public ConsolaReader(GameService gameService) {
        this.gameService = gameService;
    }

    public GameService getGameService() {
        return gameService;
    }
    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }

    @PostConstruct
    public void init() {

        GameAhorcado gameAhorcado = gameService.IniJuego();

        String letraEscaneada;
        Scanner sc = new Scanner(System.in);
        String entradaConsola;

        int opcion = 1;
        while (opcion != 0) {
            System.out.println("Menu por consola");
            System.out.println("1. Iniciar");
            System.out.println("2. Salir");

            entradaConsola = sc.next();

            try {
                opcion = Integer.parseInt(entradaConsola);
            } catch (Exception e) {
                System.out.println("Opcion no válida, ingresa un número");
            }
            switch (opcion) {
                case 0:
                    System.out.println("Hasta luego");
                    break;
                case 1:
                    while(gameService.getCuentaFallos()>0) {
                        gameService.imprimePalabra(gameAhorcado);
                        System.out.println("Ingrese nueva letra: ");
                        letraEscaneada = sc.next();
                        gameService.añadeNuevoIndice(gameAhorcado,letraEscaneada);

                        if (gameAhorcado.getListaIndices().size() == gameAhorcado.getTamañoPalabra()) {
                            System.out.println("GANASTE! la palabra correcta es " + gameAhorcado.getPalabraAcertar());
                            gameService.imprimePalabra(gameAhorcado);
                        }

                        if (!gameAhorcado.getPalabraAcertar().contains(letraEscaneada)) {
                            gameService.setOneLessOportunity();
                        }
                    }
                    System.out.println("PERDISTE, deberías replantearte algunas cosas eh..");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }

}