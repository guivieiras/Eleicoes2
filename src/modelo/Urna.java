package modelo;

import controladores.*;
import enums.*;
import exceptions.*;
import java.util.*;

public class Urna {
    public int secao;
    public int zona;
    public Turno turno;
    public Cidade cidade;
    public ArrayList<Candidato> votos = new ArrayList<>();
    
    private int votosEmBrancoGovernador;
    private int votosNuloGovernador;
    private int votosEmBrancoDeputado;
    private int votosNuloDeputado;

    public Urna(int secao, int zona, Turno turno, Cidade cidade) {
        this.secao = secao;
        this.zona = zona;
        this.turno = turno;
        this.cidade = cidade;
    }

    public void votarEmGovernador(int numeroGovernador, Candidato governador) {
        //Se eleitor votou em branco
        if (numeroGovernador == 0){
            votosEmBrancoGovernador++;
        }
        else{
            //Se eleitor votou nulo
            if (governador == null){
                votosNuloGovernador++;
            }else{
                votos.add(governador);
            }
        }    
    }
    
    public void votarEmDeputado(int numeroDeputado, Candidato deputado){
        //Se eleitor votou em branco
        if (numeroDeputado == 0){
            votosEmBrancoDeputado++;
        }
        else{
            //Se eleitor votou nulo
            if (deputado == null){
                votosNuloDeputado++;
            }else{
                votos.add(deputado);
            }
        }
    }
    
    public void apuraResultados(){
        System.out.println("Cidade: " + cidade.nome);
        System.out.println("Zona: " + zona);
        System.out.println("Seção: " + secao);
        
        for (Candidato candidato : votos){
            candidato.votos++;
        }
        
        HashSet<Candidato> hs = new HashSet();
        hs.addAll(votos);
        
        for (Candidato candidato : hs){
            System.out.println("Candidato: " + candidato.nome +", votos: " + candidato.votos);
        }
    }
}
