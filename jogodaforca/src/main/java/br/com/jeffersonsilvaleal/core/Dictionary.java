package br.com.jeffersonsilvaleal.core;

// Dicion�rio gen�rico
public abstract class Dictionary {

	private static Dictionary instance;
	
	
	// Retorna uma inst�ncia do dictionary
	public static Dictionary getInstance() {
		if (instance == null) {
			instance = new StaticDictionary();
		}
		
		return instance;
	}
	
	// M�todo para retorna a pr�xima palavra
	public abstract Word nextWord();
	
	// Indentifica qual dicion�rio est� sendo usado
	public abstract String getName();

}
