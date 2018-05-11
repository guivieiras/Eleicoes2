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
            
            ControladorCandidato.getInstance().cadastra("Pedro", Cargo.GOVERNADOR, 1, "PT");
            ControladorCandidato.getInstance().cadastra("Pedro", Cargo.DEPUTADO, 2, "PT");
            ControladorCandidato.getInstance().cadastra("Pedro", Cargo.GOVERNADOR, 3, "PSDB");
            ControladorCandidato.getInstance().cadastra("Pedro", Cargo.DEPUTADO, 4, "PSDB");
            
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
