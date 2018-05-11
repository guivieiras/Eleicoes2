package modelo;

public class Partido {
    public String nome;
    public String sigla;
	public int votos;
	public int quociente;

    public Partido(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }
}
