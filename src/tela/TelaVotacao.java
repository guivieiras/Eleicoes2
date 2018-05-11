package tela;

import enums.Cargo;
import java.util.*;
import modelo.*;
import controladores.*;

public class TelaVotacao {

    Scanner sc = new Scanner(System.in);

    int votosEmBrancoGovernador;
    int votosNuloGovernador;
    int votosEmBrancoDeputado;
    int votosNuloDeputado;

    void exibe() {
        System.out.println("--- Votação ---");
        System.out.println("Votar       (1)");
        System.out.println("Encerrar    (2)");

        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1:
                votar();
                break;
            case 2:
                mostrarResultados();
                return;
            default:
                System.out.println("Comando não reconhecido");
                break;
        }
        exibe();
    }

    private void votar() {
        System.out.println("Digite a cidade em que você deseja: ");
        String nomeCidade = sc.nextLine();

        Cidade cidade = ControladorCidade.getInstance().getCidadeByName(nomeCidade);

        System.out.println("Digite a zona: ");
        int zona = sc.nextInt();

        System.out.println("Digite a seção: ");
        int secao = sc.nextInt();
        sc.nextLine();

        Urna urna = ControladorUrna.getInstance().getUrna(cidade, zona, secao);

        if (urna == null) {
            System.out.println("Erro: urna não encontrada");
            return;
        }
        //Votação governador
        System.out.println("Urna encontrada! Digite o número do seu candidato para governador:");
        int numeroGovernador = sc.nextInt();
        Candidato governador = ControladorCandidato.getInstance().getCandidato(numeroGovernador, Cargo.GOVERNADOR);
        urna.votarEmGovernador(numeroGovernador, governador);

        //Votação deputado
        System.out.println("Digite o número do seu candidato para deputado:");
        int numeroDeputado = sc.nextInt();
        Candidato deputado = ControladorCandidato.getInstance().getCandidato(numeroDeputado, Cargo.DEPUTADO);
        urna.votarEmDeputado(numeroDeputado, deputado);

        sc.nextLine();
        System.out.println("Votação concluída com sucesso!");
    }

    private void mostrarResultados() {
        for (Cidade cidade : ControladorCidade.getInstance().cidades){
            for (Urna urna : ControladorUrna.getInstance().getUrnasByCidade(cidade)){
                urna.apuraResultados();
            }            
        }
        
    }

}
