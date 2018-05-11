package controladores;

import enums.Turno;
import exceptions.CampoVazioException;
import exceptions.EntidadeNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import modelo.*;

public class ControladorUrna extends Controlador{
    public ArrayList<Urna> urnas = new ArrayList<>();
    
    private static ControladorUrna instance;
    public static ControladorUrna getInstance(){
        if (instance == null)
            instance = new ControladorUrna();
        return instance;
    }
    
    public Urna cadastra(int secao, int zona, Turno turno, String nomeCidade) throws CampoVazioException, EntidadeNotFoundException {
        verificaCampoVazio(nomeCidade, "Nome da cidade");
        
        Cidade cidade = ControladorCidade.getInstance().getCidadeByName(nomeCidade);
        if (cidade == null)
            throw new EntidadeNotFoundException("Erro: cidade de nome '" + nomeCidade+"' não encontrada." );
        
        Urna superMegaUrna = new Urna(secao, zona, turno, cidade);
        urnas.add(superMegaUrna);
        return superMegaUrna;
    }
    
    public void remove(Urna urna){
        urnas.remove(urna);
    }
    
    public Urna getUrna(Cidade cidade, int zona, int secao){
        return urnas.stream()
            .filter(urna -> urna.cidade == cidade)
            .filter(urna -> urna.secao == secao)
            .filter(urna -> urna.zona == zona)
            .findFirst()
            .orElse(null);
    }
    
    public ArrayList<Urna> getUrnasByCidade(Cidade cidade){
        return urnas.stream()
            .filter(urna -> urna.cidade == cidade)
            .collect(Collectors.toCollection(ArrayList::new));
    }
    
    public void resultadoEleicoes(){
        for(Candidato c : ControladorCandidato.getInstance().candidatos){
            System.out.println("Candidato " + c.nome + " recebeu " + c.votos + " votos");
        }
    }
}
