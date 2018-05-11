package tela;

import exceptions.*;
import controladores.*;

public class TelaPartidos extends TelaCadastro {
    @Override
    public void exibe(){
        System.out.println("--- Tela Partidos ---");
        super.exibe();
    }
    
    @Override
    public void exibeCadastro() {
        System.out.println("Insira o nome do partido: ");
        String nome = sc.nextLine();
        System.out.println("Insira a sigla do partido: ");
        String sigla = sc.nextLine();
        
        try {
            ControladorPartido.getInstance().cadastra(nome, sigla);
            System.out.println("Partido cadastrado com sucesso!");
        } catch (CampoVazioException | CadastroRepetidoException ex) {
            System.out.println(ex.getMessage());
        }
    }


    @Override
    public void exibeLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
