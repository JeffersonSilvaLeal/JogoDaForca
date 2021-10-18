package br.com.jeffersonsilvaleal.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.jeffersonsilvaleal.game.GameException;
import br.com.jeffersonsilvaleal.utils.RandomUtils;

// Arquivo de palavras
public class FileDictionary  extends Dictionary{

	private static final String FILE_NAME = "dicionario.txt";
	
	// Lista para guardar as palavras
	private List<String> words = new ArrayList<>();
	
	// Construtor que ao criar o objeto carrega a lista de palavras atrav�z do 'LOAD'
	public FileDictionary() {
		load();
	}
	
	
	// M�todo para ler e carregar o arquivo txt em uma lista de palavras

	private void load() {
		
		// Modo para ler um arquivo localizado dentro do projeto, ultilizamos o try para fechar automaticamente o scanner 'Closed'
		try (Scanner scanner = new Scanner(getClass().getResourceAsStream("/" + FILE_NAME))) {
			
			// 'hasNextLine' Retorna true se tem uma pr�xima linha para ler ou false se n�o
			// Enquanto ouver linhas no arquivo
			while (scanner.hasNextLine()) {
				// Pega a pr�xima linha e adiciona na lista de palavra
				String word = scanner.nextLine().trim(); // 'Trim gera uma nova String sem os espa��s em branco'
				// Insere na lista a palavra
				words.add(word);
			
			}
			
			// se o tamanho do array for igual a 0 seguinifica que a lista esta vazia, lan�aremos uma exce��o
			if (words.size() == 0) {
				throw new GameException("A lista de palavras n�o pode ser vazia!");
			}
		}
	}
	
	// M�todo para retorna a pr�xima palavra
	@Override
	public Word nextWord() {
		// Sortea a palavra atravez do indice
		int posRandomica = RandomUtils.newRandomNumber(0, words.size());
		// pega a palavra e passa para o construtor do m�todo Word
		return new Word(words.get(posRandomica));
	}


	@Override
	public String getName() {
		return "Arquivo " + FILE_NAME;
	}
}
