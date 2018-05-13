package tela;

import exceptions.*;

import java.util.ArrayList;

import controladores.*;
import modelo.*;

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
    	ArrayList<Eleitor> eleitores = ControladorEleitor.getInstance().eleitores;
    	if (eleitores.size() == 0){
            System.out.println("Não há eleitores cadastrados.");
            return;
    	}
    	
        System.out.println("Eleitores:");
        for (Eleitor eleitor : eleitores) {
        	System.out.println("Nome: " + eleitor.nome + ", Titulo: " + eleitor.titulo);
        }
    }
}
