package tela;

import interfaces.ITela;
import java.util.Scanner;

public abstract class Tela implements ITela {
    Scanner sc = new Scanner(System.in);

    @Override
    public void exibe() {
        System.out.println("Cadastrar   (1)");
        System.out.println("Sair        (2)");

        int opcao = sc.nextInt();
        sc.nextLine();
        
        switch (opcao) {
            case 1:
                exibeCadastro();
                break;
            case 2:
                return;
            default:
                System.out.println("Comando não reconhecido, tente novamente.");
                exibe();
                break;
        }
    }
}
