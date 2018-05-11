package controladores;

import exceptions.CampoVazioException;
import java.util.ArrayList;
import modelo.Eleitor;

public class ControladorEleitor extends Controlador{
    public ArrayList<Eleitor> eleitores = new ArrayList<>();
    
    private static ControladorEleitor instance;
    public static ControladorEleitor getInstance(){
        if (instance == null)
            instance = new ControladorEleitor();
        return instance;
    }
    
    public Eleitor cadastra(String nome, String titulo) throws CampoVazioException{
        //verificações
        verificaCampoVazio(nome, "Nome eleitor");
        verificaCampoVazio(titulo, "Titulo do eleitor");
        
        Eleitor e = new Eleitor(nome, titulo);
        eleitores.add(e);
        return e;
    }
    
    public void remove(Eleitor eleitor){
        eleitores.remove(eleitor);
    }
}
