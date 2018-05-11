import modelo.*;
import controladores.*;
import enums.*;
import exceptions.*;
import java.util.*;
import java.util.logging.*;
import tela.TelaPrincipal;

public class Main {
    public static void main(String[] args){
        
        try {
            ControladorCidade.getInstance().cadastra("Sao Jose");
            ControladorCidade.getInstance().cadastra("Florianópolis");
            
            ControladorPartido.getInstance().cadastra("Partido dos trabalhadores", "PT");
            ControladorPartido.getInstance().cadastra("Psdasda", "PSDB");
            
            ControladorCandidato.getInstance().cadastra("Pedro", Cargo.GOVERNADOR, 1, "PT").votos = 10;
            ControladorCandidato.getInstance().cadastra("Maria", Cargo.GOVERNADOR, 3, "PSDB").votos = 15;
            ControladorCandidato.getInstance().cadastra("José", Cargo.DEPUTADO, 2, "PT").votos = 3;
            ControladorCandidato.getInstance().cadastra("Deus", Cargo.DEPUTADO, 4, "PSDB").votos = 6;
            ControladorCandidato.getInstance().cadastra("A", Cargo.DEPUTADO, 5, "PSDB").votos = 10;
            ControladorCandidato.getInstance().cadastra("B", Cargo.DEPUTADO, 6, "PSDB").votos = 0;
            ControladorCandidato.getInstance().cadastra("C", Cargo.DEPUTADO, 7, "PSDB").votos = 50;
            
            ControladorUrna.getInstance().cadastra(1, 1, Turno.SEGUNDO, "Sao Jose");
            ControladorUrna.getInstance().cadastra(1, 2, Turno.SEGUNDO, "Sao Jose");
            
            ControladorUrna.getInstance().cadastra(1, 1, Turno.SEGUNDO, "Florianópolis");
            ControladorUrna.getInstance().cadastra(1, 2, Turno.SEGUNDO, "Florianópolis");
        } catch (NumeroInvalidoException | CampoVazioException | CadastroRepetidoException | EntidadeNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        
        new TelaPrincipal().exibe();
        
        
        if (true)
            return;
        
    }
}
