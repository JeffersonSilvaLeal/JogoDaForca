package br.com.jeffersonsilvaleal.game;

import br.com.jeffersonsilvaleal.core.Word;

public class Game {

	// M�todo para iniciar o jogo
	public void start() {
	
		Word word = new Word("Leticia");
		// Entrada de dados deve ser em Letra mai�scula
		word.hasChar('T');
		word.hasChar('E');
		
		// Jogo acabou
		System.out.println(word.discovered());
		
		System.out.println(word);
	}
}
