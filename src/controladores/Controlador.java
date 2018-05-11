package controladores;

import exceptions.CampoVazioException;

/**
 *
 * @author Guilherme
 */
abstract class Controlador {
    public void verificaCampoVazio(String campo, String nomeCampo) throws CampoVazioException{
        if (campo == null || campo.isEmpty())
            throw new exceptions.CampoVazioException("Erro: não é permitido campo vazio (" + nomeCampo + ")");
    }   
}
