package com.example.demoAhorcado.consola;

import com.example.demoAhorcado.domain.GameAhorcado;
import com.example.demoAhorcado.domain.GeneraPalabraAhorcado;
import com.example.demoAhorcado.service.GameService;
import com.example.demoAhorcado.service.GameServiceImpl;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Controller
public class ConsolaReader {
    private GameService gameService;

    public ConsolaReader(GameService gameService) {
        this.gameService = gameService;
    }

    @PostConstruct
    public void init() {

        gameService.IniJuego();

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
                    while(gameService.getLimiteFallos()<=gameService.getLimiteFallos()) {
                        imprimePalabra(gameService.getGameAhorcado().getPalabraAcertar());
                        System.out.println("Ingrese nueva letra o muere: ");
                        letraEscaneada = sc.next();
                        añadeNuevoIndice(gameService.getGameAhorcado().getPalabraAcertar(), letraEscaneada);

                        if (gameService.getGameAhorcado().getListaIndices().size() == gameService.getGameAhorcado().getTamañoPalabra()) {
                            System.out.println("GANASTE!");
                            imprimePalabra(gameService.getGameAhorcado().getPalabraAcertar());
                        }

                        if (!gameService.getGameAhorcado().getPalabraAcertar().contains("" + letraEscaneada)) {
                            gameService.setOneLessOportunity();
                            if (gameService.getCuentaFallos() == gameService.getLimiteFallos()) {
                                System.out.println("PERDISTE, deberías replantearte algunas cosas eh..");
                            }
                        }
                    }
                    break;
                case 2:

                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }

    private void imprimePalabra(String palabraJuego) {
        String palabraActualJuego = " " + palabraJuego.charAt(0) + " ";
        for (int i = 1; i < palabraJuego.length(); i++) {
            if (gameService.getGameAhorcado().getListaIndices().contains(i)) {
                palabraActualJuego.concat(String.valueOf(" " + palabraJuego.charAt(i) + " "));

            } else {
                palabraActualJuego.concat(" - ");
            }
        }
        System.out.println(palabraActualJuego);
    }

    private void añadeNuevoIndice(String palabraJuego, String letraEscaneada) {
        if (palabraJuego.contains("" + letraEscaneada)) {
            for (int i = 1; i < palabraJuego.length(); i++) {
                if (letraEscaneada.equals(palabraJuego.charAt(i))) {
                    gameService.getGameAhorcado().getListaIndices().add(i);
                }
            }
        }
    }
}