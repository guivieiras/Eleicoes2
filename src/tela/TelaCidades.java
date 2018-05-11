package tela;

import exceptions.*;
import controladores.*;

public class TelaCidades extends Tela {

    @Override
    public void exibe(){
        System.out.println("--- Tela Cidades ---");
        super.exibe();
    }
    
    @Override
    public void exibeCadastro() {
        System.out.println("Insira o nome da cidade: ");
        String nome = sc.nextLine();
        
        try {
            ControladorCidade.getInstance().cadastra(nome);
            System.out.println("Cidade cadastrada com sucesso!");
        } catch (CampoVazioException | CadastroRepetidoException ex) {
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
