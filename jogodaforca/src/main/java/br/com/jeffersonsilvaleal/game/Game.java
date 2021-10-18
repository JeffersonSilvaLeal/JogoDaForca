package br.com.jeffersonsilvaleal.game;

import java.util.HashSet;
import java.util.Set;

import br.com.jeffersonsilvaleal.core.Dictionary;
import br.com.jeffersonsilvaleal.core.InvalidCharacterException;
import br.com.jeffersonsilvaleal.core.Word;
import br.com.jeffersonsilvaleal.ui.UI;

public class Game {

	private static final int MAX_ERRORS = 5;

	// Método para iniciar o jogo
	public void start() {
		// Boas vindas ao jogo
		UI.print("Bem vindo ao jogo da Forca!!");

		// Sorteia uma palavra e retorna a mesma
		Dictionary dictionary = Dictionary.getInstance();
		// Retorna a palavra que o usúario tera que descobrir
		Word word = dictionary.nextWord();

		// Mostra quantas letras tem a palavra
		UI.print("A palavra tem  " + word.size() + " letras!");

		// Guarda as letras que o usúario já digitou
		Set<Character> usedchars = new HashSet<>();

		// Controla o número de erros
		int errorcount = 0;

		// Começa o jogo
		while (true) {
			UI.print(word);
			UI.printNewLine();

			char c;
			try {
				c = UI.readChar("Digite uma letra!!");
				UI.print("A palavra tem  " + word.size() + " letras!");

				if (usedchars.contains(c)) {
					throw new InvalidCharacterException("Esta letra já foi ultiizada");
				}

				usedchars.add(c);

				if (word.hasChar(c)) {
					UI.print("Voçê acertou uma letra");

				} else {
					errorcount++;

					if (errorcount < MAX_ERRORS) {
						UI.print("Voçê errou!! Voçê ainda pode errar " + (MAX_ERRORS - errorcount) + " vezes");
					}
				}

				UI.printNewLine();
				
				// Descobriu a palavra
				if (word.discovered()) {
					UI.print("Parabéns voçê acertou a palavra: " + word.getOriginalWord());
					UI.print("Fim de jogo");
					break;
				}
				
				// Quantidade de tentativa foi excedeu
				if (errorcount == MAX_ERRORS) {
					UI.print("Voçê perdeu o jogo: a palavra correta era: " + word.getOriginalWord());
					UI.print("Fim de jogo");
					break;
				}
				
				
				
				
			} catch (InvalidCharacterException e) {
				UI.print("Erro: " + e.getMessage());
				UI.printNewLine();
			}
		}

	}
}
