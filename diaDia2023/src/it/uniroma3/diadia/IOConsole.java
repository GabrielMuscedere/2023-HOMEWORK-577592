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

public class IOConsole {
	
	/**
	 * 
	 * @param il messaggio da stampare su schermo per l'utente.
	 */
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}
	
	/**
	 * 
	 * @return la riga scansionata da tastiera.
	 */
	public String leggiRiga() {
		Scanner scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
		//scannerDiLinee.close();
		return riga;
	}
}
