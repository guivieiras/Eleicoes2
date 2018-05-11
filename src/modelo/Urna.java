package modelo;

import enums.*;
import java.util.*;

public class Urna {
	public int secao;
	public int zona;
	public Turno turno;
	public Cidade cidade;
	public ArrayList<Candidato> votos = new ArrayList<>();

	public int votosEmBrancoGovernador;
	public int votosNuloGovernador;
	public int votosEmBrancoDeputado;
	public int votosNuloDeputado;

	public Urna(int secao, int zona, Turno turno, Cidade cidade) {
		this.secao = secao;
		this.zona = zona;
		this.turno = turno;
		this.cidade = cidade;
	}

	public void votarEmGovernador(int numeroGovernador, Candidato governador) {
		// Se eleitor votou em branco
		if (numeroGovernador == 0) {
			votosEmBrancoGovernador++;
			return;
		}
		
		// Se eleitor votou em um candidato
		if (governador != null) {
			votos.add(governador);
		} else {
			votosNuloGovernador++;
		}

	}

	public void votarEmDeputado(int numeroDeputado, Candidato deputado) {
		// Se eleitor votou em branco
		if (numeroDeputado == 0) {
			votosEmBrancoDeputado++;
		} else {
			// Se eleitor votou nulo
			if (deputado == null) {
				votosNuloDeputado++;
			} else {
				votos.add(deputado);
			}
		}
	}

	public void apuraResultados() {
		for (Candidato candidato : votos) {
			candidato.votos++;

			if (candidato.cargo == Cargo.DEPUTADO)
				candidato.partido.votos++;
		}
	}
}
