package tela;

import controladores.*;
import enums.*;
import exceptions.*;

public class TelaUrnas extends TelaCadastro{
    @Override
    public void exibe(){
        System.out.println("--- Tela Urnas ---");
        super.exibe();
    }
    
    @Override
    public void exibeCadastro() {
        System.out.println("Insira a seção da urna:");
        int secao = getInt();
        
        System.out.println("Insira a zona da urna:");
        int zona = getInt();
        
        System.out.println("Insira a cidade:");
        String cidade = sc.nextLine();
        
        System.out.println("Primeiro (1) ou segundo (2) turno?");
        Turno turno = Turno.getTurno(getInt());
        
        if (turno == null) {
            System.out.println("Erro: numero do turno tem que ser 1 ou 2");
            return;
        }
        
        try {
            ControladorUrna.getInstance().cadastra(secao, zona, turno, cidade);
        } catch (CampoVazioException | EntidadeNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    @Override
    public void exibeLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 
}
