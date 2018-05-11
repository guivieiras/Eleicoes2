package tela;

import interfaces.ITela;
import java.util.Scanner;

public abstract class Tela implements ITela {
	Scanner sc = new Scanner(System.in);

	public int getInt() {
		try {
			return Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException ex) {
			System.out.println("Erro: digite um número");
			return getInt();
		}
	}
}
