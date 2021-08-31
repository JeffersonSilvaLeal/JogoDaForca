package br.com.jeffersonsilvaleal.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.jeffersonsilvaleal.game.GameException;
import br.com.jeffersonsilvaleal.utils.RandomUtils;

// Arquivo de palavras
public class Dictionary {

	private static final String FILE_NAME = "dicionario.txt";

	private static Dictionary instance;
	
	// Lista para guardar as palavras
	private List<String> words = new ArrayList<>();
	
	// Construtor que ao criar o objeto carrega a lista de palavras atravéz do 'LOAD'
	private Dictionary() {
		load();
	}
	
	// Permite que o Objeto seja criada apenas uma vez ultilizando o padrão singleton
	public static Dictionary getInstance() {
		
		if(instance == null) {
			instance = new Dictionary();
		}
		
		return instance;
	}
	
	// Método para ler e carregar o arquivo txt em uma lista de palavras

	private void load() {
		
		// Modo para ler um arquivo localizado dentro do projeto, ultilizamos o try para fechar automaticamente o scanner 'Closed'
		try (Scanner scanner = new Scanner(getClass().getResourceAsStream("/" + FILE_NAME))) {
			
			// 'hasNextLine' Retorna true se tem uma próxima linha para ler ou false se não
			// Enquanto ouver linhas no arquivo
			while (scanner.hasNextLine()) {
				// Pega a próxima linha e adiciona na lista de palavra
				String word = scanner.nextLine().trim(); // 'Trim gera uma nova String sem os espaçõs em branco'
				// Insere na lista a palavra
				words.add(word);
			
			}
			
			// se o tamanho do array for igual a 0 seguinifica que a lista esta vazia, lançaremos uma exceção
			if (words.size() == 0) {
				throw new GameException("A lista de palavras não pode ser vazia!");
			}
		}
	}
	
	// Método para retorna a próxima palavra
	public Word nextWord() {
		// Sortea a palavra atravez do indice
		int posRandomica = RandomUtils.newRandomNumber(0, words.size());
		// pega a palavra e passa para o construtor do método Word
		return new Word(words.get(posRandomica));
	}
}
