package tela;

import exceptions.*;
import controladores.*;

public class TelaEleitores extends TelaCadastro {
    @Override
    public void exibe(){
        System.out.println("--- Tela Eleitores ---");
        super.exibe();
    }
    
    @Override
    public void exibeCadastro() {
        System.out.println("Insira o nome do eleitor:");
        String nome = sc.nextLine();
        System.out.println("Insira o titulo do eleitor: ");
        String titulo = sc.nextLine();
        
        try {
            ControladorEleitor.getInstance().cadastra(nome, titulo);
            System.out.println("Eleitor cadastrado com sucesso!");
        } catch (CampoVazioException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void exibeLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
