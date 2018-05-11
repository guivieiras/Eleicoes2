package tela;

import enums.*;
import exceptions.*;
import controladores.*;

public class TelaCandidatos extends Tela {

    @Override
    public void exibe(){
        System.out.println("--- Tela Candidatos ---");
        super.exibe();
    }
    
    @Override
    public void exibeCadastro() {
        System.out.println("Insira o nome do candidato: ");
        String nome = sc.nextLine();
        
        System.out.println("Insira o número do candidato: ");
        int numero = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Governador (G) ou Deputado (D)?");
        String letraCargo = sc.nextLine();
        
        System.out.println("Insira a sigla do partido: ");
        String siglaPartido = sc.nextLine();
        
        Cargo cargo;
        if (letraCargo.equalsIgnoreCase("G"))
            cargo = Cargo.GOVERNADOR;
        else if (letraCargo.equalsIgnoreCase("D"))
            cargo = Cargo.DEPUTADO;
        else {
            System.out.println("Erro: letra inserida diferente de G ou D");
            exibe();
            return;
        }
        
        try {
            ControladorCandidato.getInstance().cadastra(nome, cargo, numero, siglaPartido);
            System.out.println("Candidato cadastrado com sucesso!");
        } catch (CampoVazioException | EntidadeNotFoundException | CadastroRepetidoException | NumeroInvalidoException ex) {
            System.out.println(ex.getMessage());
        }
        exibe();    
    }

    @Override
    public void exibeRemocao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exibeLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}

