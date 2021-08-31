package br.com.jeffersonsilvaleal.game;

import br.com.jeffersonsilvaleal.core.Dictionary;
import br.com.jeffersonsilvaleal.core.Word;

public class Game {

	// Método para iniciar o jogo
	public void start() {
	
		Dictionary d1 = Dictionary.getInstance();
		System.err.println(d1);
		
		Word w1 = d1.nextWord();
		
		System.out.println(w1.getOriginalWord());
	
		/*
	  
		Word word = new Word("Leticia");
		// Entrada de dados deve ser em Letra maiúscula
		word.hasChar('T');
		word.hasChar('E');
		
		// Jogo acabou
		System.out.println(word.discovered());
		
		System.out.println(word);
		*/
		
		
	}
}
