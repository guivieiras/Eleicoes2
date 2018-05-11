package controladores;

import exceptions.*;
import java.util.*;
import modelo.*;

public class ControladorCidade extends Controlador{
    public ArrayList<Cidade> cidades = new ArrayList<>();
    
    private static ControladorCidade instance;
    public static ControladorCidade getInstance(){
        if (instance == null)
            instance = new ControladorCidade();
        return instance;
    }
    
    public void cadastra(String nomeCidade) throws CampoVazioException, CadastroRepetidoException{
        //verificações
        verificaCampoVazio(nomeCidade, "Nome cidade");
        
        if (getCidadeByName(nomeCidade) != null)
            throw new CadastroRepetidoException("Erro: cidade com nome '" + nomeCidade +"' já existe.");
        
        Cidade cidade = new Cidade(nomeCidade);
        cidades.add(cidade);
    }
    
    public void remove(Cidade cidade){
        cidades.remove(cidade);
    }

    public Cidade getCidadeByName(String nomeCidade) {
        return cidades.stream()
            .filter((cidade) -> cidade.nome.equalsIgnoreCase(nomeCidade))
            .findFirst()
            .orElse(null);
    }
}
