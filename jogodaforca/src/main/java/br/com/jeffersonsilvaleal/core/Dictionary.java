package br.com.jeffersonsilvaleal.core;

// Dicionário genérico
public abstract class Dictionary {

	private static Dictionary instance;
	
	
	// Retorna uma instãncia do dictionary
	public static Dictionary getInstance() {
		if (instance == null) {
			instance = new StaticDictionary();
		}
		
		return instance;
	}
	
	// Método para retorna a próxima palavra
	public abstract Word nextWord();
	
	// Indentifica qual dicionário está sendo usado
	public abstract String getName();

}
