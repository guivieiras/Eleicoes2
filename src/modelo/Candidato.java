package modelo;

import enums.Cargo;

public class Candidato {
    public String nome;
    public Cargo cargo;
    public int numero;
    public int votos;
    public Partido partido;

    public Candidato(String nome, Cargo cargo, int numero, Partido partido) {
        this.nome = nome;
        this.cargo = cargo;
        this.numero = numero;
        this.partido = partido;
    }
   
}
