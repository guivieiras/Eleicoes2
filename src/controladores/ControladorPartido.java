package controladores;

import exceptions.*;
import java.util.*;
import modelo.*;

public class ControladorPartido extends Controlador{
    public ArrayList<Partido> partidos = new ArrayList<>();
    
    private static ControladorPartido instance;
    public static ControladorPartido getInstance(){
        if (instance == null)
            instance = new ControladorPartido();
        return instance;
    }
    
    public void cadastra(String nome, String sigla) throws CadastroRepetidoException, CampoVazioException{
        verificaCampoVazio(nome, "Nome partido");
        verificaCampoVazio(sigla, "Sigla partido");
        
        if (getPartidoByNome(nome) != null)
            throw new CadastroRepetidoException("Erro: partido com nome '" + nome + "' já existe.");
        if (getPartidoBySigla(sigla) != null)
            throw new CadastroRepetidoException("Erro: partido com sigla '" + sigla + "' já existe.");

        Partido partido = new Partido(nome, sigla);
        partidos.add(partido);
    }
    
    public void remove(Partido partido){
        partidos.remove(partido);
    }

    Partido getPartidoBySigla(String sigla) {
        return partidos.stream()
            .filter((partido) -> partido.sigla.equalsIgnoreCase(sigla))
            .findFirst()
            .orElse(null);
    }
    
    Partido getPartidoByNome(String nome) {
        return partidos.stream()
            .filter((partido) -> partido.nome.equalsIgnoreCase(nome))
            .findFirst()
            .orElse(null);
    }
    
}
