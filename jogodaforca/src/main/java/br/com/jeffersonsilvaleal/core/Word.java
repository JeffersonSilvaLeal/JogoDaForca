package br.com.jeffersonsilvaleal.core;

import java.util.HashSet;
import java.util.Set;

// Classe que irá representar uma palavra no Game
public class Word {

	// Constante
	private static final char SECRET_CHAR = '_';

	private String originalWord;

	// Caracteres Encontrados
	private Set<Character> foundChars = new HashSet<>();

	// Conjunto de letras sem duplicidade
	private Set<Character> wordChars = new HashSet<>();

	public Word(String originalWord) {
		// Converte as letras para maiuscula
		this.originalWord = originalWord.toUpperCase();

		// Garante que o conjunto não terá duplicidade
		char[] chars = this.originalWord.toCharArray();
		for (char c : chars) {
			wordChars.add(c);
		}
	}

	// Retorna o tamanho da palavra
	public int size() {
		return originalWord.length();
	}

	// Retorna o caracter
	public boolean hasChar(char c) {
		// Converte as letras para maiusculas
		Character.toUpperCase(c);
		int pos = originalWord.indexOf(c);

		// se a posição é maior que -1 indica que encontrou a letra da palavra
		if (pos > -1) {
			foundChars.add(c);
			return true;
		}
		// se a posição é -1 indica que não encontrou a letra da palavra
		return false;
	}

	@Override
	public String toString() {
		// Concatena String gerando apenas um objeto no final
		StringBuilder sB = new StringBuilder();

		// Converte uma String em um Array de Char
		char[] charArray = originalWord.toCharArray();

		for (int i = 0; i < charArray.length; i++) {
			// Letra corrente
			char c = charArray[i];

			// Se a letra estiver no conjunto pode ser mostrada ao usuário
			if (foundChars.contains(c)) {
				sB.append(c);
				// Se não estiver retonar a letra em maskara
			} else {
				sB.append(SECRET_CHAR);
			}

			// Depois de cada letra terá um espaço 'C A S A'
			sB.append(" ");
		}

		return sB.toString();
	}

	// Método que verifica se a palavra foi encontrada por inteiro ou não
	public boolean discovered() {

		return foundChars.equals(wordChars);
	}

	public String getOriginalWord() {
		return originalWord;
	}

}
