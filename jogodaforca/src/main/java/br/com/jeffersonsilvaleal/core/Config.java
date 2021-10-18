package br.com.jeffersonsilvaleal.core;

import java.io.IOException;
import java.util.Properties;

import javax.management.RuntimeErrorException;

public class Config {

	// Usar a classe sem criar um objeto config 
	private static Properties properties = new Properties();
	
	
	//Executa apenas uma vez que a classe for criada
	static {
		try {
			properties.load(Config.class.getResourceAsStream("/config.properties"));
		} catch (IOException e) {
			throw new  RuntimeException(e);
		}
	}
	
	public static String get(String nome) {
		return properties.getProperty(nome);
	}
}
