package tela;

import interfaces.ITela;
import java.util.Scanner;

public abstract class TelaCadastro extends Tela {
    @Override
    public void exibe() {
        System.out.println("Cadastrar   (1)");
        System.out.println("Sair        (2)");

        int opcao = getInt();
        
        switch (opcao) {
            case 1:
                exibeCadastro();
                break;
            case 2:
                return;
            default:
                System.out.println("Comando não reconhecido, tente novamente.");
                break;
        }
        exibe();

    }
    
    public abstract void exibeCadastro();
    public abstract void exibeLista();
}
