package tela;

import controladores.ControladorUrna;
import enums.Turno;
import exceptions.CampoVazioException;
import exceptions.EntidadeNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaUrnas extends Tela{
    @Override
    public void exibe(){
        System.out.println("--- Tela Urnas ---");
        super.exibe();
    }
    
    @Override
    public void exibeCadastro() {
        System.out.println("Insira a seção da urna:");
        int secao = sc.nextInt();
        
        System.out.println("Insira a zona da urna:");
        int zona = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Insira a cidade:");
        String cidade = sc.nextLine();
        
        System.out.println("Primeiro (1) ou segundo (2) turno?");
        int numeroTurno = sc.nextInt();
        sc.nextLine();
        Turno turno;
        if (numeroTurno == 1)
            turno = Turno.PRIMEIRO;
        else if(numeroTurno == 2)
            turno = Turno.SEGUNDO;
        else {
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
    public void exibeRemocao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exibeLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
