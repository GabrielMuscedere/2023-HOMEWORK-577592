package it.uniroma3.diadia.giocatore;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Set<Attrezzo> attrezzi;
	private int pesoMax;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashSet<Attrezzo>();
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		return this.attrezzi.add(attrezzo);
	}

	public int getPesoMax() {
		return pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		Iterator<Attrezzo> iterAttrezzi= this.attrezzi.iterator();
		while(iterAttrezzi.hasNext()) {
			a = iterAttrezzi.next();
			if (a.getNome().equals(nomeAttrezzo))
				return a;
		}
		return null;
	}

	public int getPeso() {
		int peso = 0;
		Iterator<Attrezzo> iterAttrezzi= this.attrezzi.iterator();
		while(iterAttrezzi.hasNext()) {
			peso += iterAttrezzi.next().getPeso();
		}
		return peso;
	}

	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		Attrezzo attrezzoDaRimuovere = null;
		Iterator<Attrezzo> iterAttrezzi = this.attrezzi.iterator();
		while(iterAttrezzi.hasNext()) {
			a = iterAttrezzi.next();
			if(a.getNome().equals(nomeAttrezzo))
				attrezzoDaRimuovere = a;
		}
		this.attrezzi.remove(attrezzoDaRimuovere);
		return attrezzoDaRimuovere;
	}

	public Set<Attrezzo> getAttrezzi() {
		return this.attrezzi;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa: " + this.getContenutoOrdinatoPerPeso().toString() + "  ...peso Max: " + this.getPesoMax() + "kg");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}

	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		ComparatorePerPeso comparatore = new ComparatorePerPeso();
		LinkedList<Attrezzo> attrezziOrdinati = new LinkedList<Attrezzo>(this.attrezzi);
		attrezziOrdinati.sort(comparatore);
		return attrezziOrdinati;
	}

	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		ComparatorePerNome comparatore = new ComparatorePerNome();
		SortedSet<Attrezzo> attrezziOrdinati = new TreeSet<Attrezzo>(comparatore); 
		attrezziOrdinati.addAll(this.attrezzi);
		return attrezziOrdinati;
	}

	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Set<Attrezzo> tmp;
		Map<Integer, Set<Attrezzo>> mappaOrdinata;
		mappaOrdinata = new HashMap<Integer, Set<Attrezzo>>();
		Attrezzo a; 

		Iterator<Attrezzo> iterAttrezzi = attrezzi.iterator();
		while(iterAttrezzi.hasNext()) {
			a = iterAttrezzi.next();
			tmp = mappaOrdinata.get(a.getPeso());
			if(tmp == null)
				tmp = new HashSet<Attrezzo>();
			tmp.add(a);
			mappaOrdinata.put(a.getPeso(), tmp);
		}
		return mappaOrdinata;
	}
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		ComparatorePerPeso comparatore = new ComparatorePerPeso();
		SortedSet<Attrezzo> attrezziOrdinati = new TreeSet<Attrezzo>(comparatore);
		attrezziOrdinati.addAll(this.getAttrezzi());
		return attrezziOrdinati;
	}

}