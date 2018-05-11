package enums;

public enum Cargo {
    GOVERNADOR, DEPUTADO;
	
	public static Cargo getCargo(String letra) {
		if (letra.equalsIgnoreCase("G"))
            return Cargo.GOVERNADOR;
        else if (letra.equalsIgnoreCase("D"))
            return Cargo.DEPUTADO;
        else 
        	return null;
	}
}
