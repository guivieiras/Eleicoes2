package tela;

import interfaces.*;
import java.util.*;

public class TelaPrincipal extends Tela {
    
    public void exibe() {
        System.out.println(" ---- Tela Principal ----");
        System.out.println("Cadastrar eleitores   (1)");
        System.out.println("Cadastrar cidades     (2)");
        System.out.println("Cadastrar partidos    (3)");
        System.out.println("Cadastrar candidatos  (4)");
        System.out.println("Cadastrar urnas       (5)");
        System.out.println("Iniciar votação       (6)");
        System.out.println("Sair                  (7)");

        int opcao = getInt();

        switch (opcao) {
            case 1:
                new TelaEleitores().exibe();
                break;
            case 2:
                new TelaCidades().exibe();
                break;
            case 3:
                new TelaPartidos().exibe();
                break;
            case 4:
                new TelaCandidatos().exibe();
                break;
            case 5:
                new TelaUrnas().exibe();
                break;
            case 6:
                new TelaVotacao().exibe();
                break;
            case 7:
                return;
            default:
                System.out.println("Comando não reconhecido, tente novamente.");
                break;
        }
        exibe();        
    }

}
