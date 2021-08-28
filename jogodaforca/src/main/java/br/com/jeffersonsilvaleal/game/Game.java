package br.com.jeffersonsilvaleal.game;

import br.com.jeffersonsilvaleal.core.Word;

public class Game {

	// Método para iniciar o jogo
	public void start() {
	
		Word word = new Word("casa");
		// Entrada de dados deve ser em Letra maiuscula
		word.hasChar('A');
		word.hasChar('C');
		
		// Jogo acabou
		System.out.println(word.discovered());
		
		System.out.println(word);
	}
}
