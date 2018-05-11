package enums;

/**
 *
 * @author Guilherme
 */
public enum Turno {
    PRIMEIRO, SEGUNDO;
    
    public static Turno getTurno(int turno){
    	if (turno == 1)
            return Turno.PRIMEIRO;
        else if(turno == 2)
            return Turno.SEGUNDO;  
        else 
        	return null;
    }
}
