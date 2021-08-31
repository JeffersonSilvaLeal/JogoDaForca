package br.com.jeffersonsilvaleal.utils;

import java.util.Random;

// Classe para sortear as palavras
public class RandomUtils {
	
	// Ramdon objeto que permite gerar n�meros randomicos
	private static Random random = new Random();
	
	// M�todo para gerar n�meros randomicos
	public static int newRandomNumber(int min, int max) {
		return random.nextInt(max - min) + min;
	}

}
