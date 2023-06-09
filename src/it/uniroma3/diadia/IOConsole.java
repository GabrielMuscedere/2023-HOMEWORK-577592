package it.uniroma3.diadia;

import java.util.Scanner;

/**
 * Classe IOConsole che si occupa di gestire l'interazione IO con l'utente
 * tramite tastiera e schermo.
 *
 * @author Muscedere Gabriel
 * @see DiaDia
 * @version 1
 * 
 */

public class IOConsole implements IO{
	
	Scanner scannerDiLinee;
	
	public IOConsole(Scanner scanner) {
		this.scannerDiLinee = scanner;
	}
	
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}
	
	public String leggiRiga() {
		String riga = scannerDiLinee.nextLine();
		//scannerDiLinee.close();
		return riga;
	}
}
