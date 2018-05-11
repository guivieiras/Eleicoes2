package controladores;

import exceptions.NumeroInvalidoException;
import enums.*;
import exceptions.*;
import java.util.*;
import modelo.*;

public class ControladorCandidato extends Controlador{
    public final ArrayList<Candidato> candidatos = new ArrayList<>();
    
    private static ControladorCandidato instance;
    public static ControladorCandidato getInstance(){
        if (instance == null)
            instance = new ControladorCandidato();
        return instance;
    }
    
    public Candidato cadastra(String nome, Cargo cargo, int numero, String siglaPartido) throws CampoVazioException, EntidadeNotFoundException, CadastroRepetidoException, NumeroInvalidoException{
        if (numero < 1 || numero > 98)
            throw new NumeroInvalidoException();
        
        verificaCampoVazio(nome, "Nome candidato");
        verificaCampoVazio(siglaPartido, "Sigla do partido");
        
        //Pega informações necessárias
        Partido partido = ControladorPartido.getInstance().getPartidoBySigla(siglaPartido);
        
        //verificações
        if (partido == null)
            throw new EntidadeNotFoundException("Erro: não foi possivel encontrar partido com sigla '" + siglaPartido + "'.");
        if (getCandidatoByNumero(numero) != null)
            throw new CadastroRepetidoException("Erro: candidato com número '" + numero + "' já existe.");
        
        Candidato candidato = new Candidato(nome, cargo, numero, partido);
        candidatos.add(candidato);
        return candidato;
    }
    
    public void remove(Candidato candidato){
        candidatos.remove(candidato);
    }

    public Candidato getCandidatoByNumero(int numero) {
        return candidatos.stream()
            .filter(candidato -> candidato.numero == numero)
            .findFirst()
            .orElse(null);
    }

    public Candidato getCandidato(int numero, Cargo cargo) {
        return candidatos.stream()
            .filter(candidato -> candidato.numero == numero)
            .filter(candidato -> candidato.cargo == cargo)
            .findFirst()
            .orElse(null);
    }
    
    public Candidato getGovernadorEleito() {
        Candidato eleito = null;
        for (Candidato candidato : candidatos) {
        	if (candidato.cargo == Cargo.GOVERNADOR && (eleito == null || candidato.votos > eleito.votos)) {
        		eleito = candidato;
        	}
        }
        return eleito;
    }
    
    public ArrayList<Candidato> getDeputadosEleitos(){
    	Candidato c1 = null;
    	Candidato c2 = null;
    	Candidato c3 = null;
    	for (Candidato c : candidatos) {
    		if (c1 == null || c.votos > c1.votos)
    			c1 = c;
    		else if (c2 == null || c.votos > c2.votos)
    			c2 = c;
    		else if (c3 == null || c.votos > c3.votos)
    			c3 = c;
    	}
    	ArrayList<Candidato> eleitos = new ArrayList<>();
    	eleitos.add(c1);
    	eleitos.add(c2);
    	eleitos.add(c3);
    	
    	return eleitos;
    }
}
