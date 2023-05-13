package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaProtected extends StanzaProtected{

	protected static final int SOGLIA_MAGICA_DEFULT = 3;

	protected int sogliaMagica;

	public StanzaMagicaProtected(String nome, int sogliaMagica) {
		super(nome);
		this.sogliaMagica = sogliaMagica;
	}

	public StanzaMagicaProtected(String nome) {
		super(nome);
		this.sogliaMagica = SOGLIA_MAGICA_DEFULT;
	}

	protected Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso()*2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();

		attrezzo = new Attrezzo(nomeInvertito.toString(), pesoX2);

		return attrezzo;
	}

	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(this.attrezzi.size() > this.sogliaMagica)
			attrezzo = modificaAttrezzo(attrezzo);

		return this.attrezzi.add(attrezzo);
	}
	
}
