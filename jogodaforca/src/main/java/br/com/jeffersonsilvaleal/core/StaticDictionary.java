package br.com.jeffersonsilvaleal.core;

import java.util.List;

public class StaticDictionary extends Dictionary{
	
	private List<String> words = List.of("Game","Pc","PS3","Ps4");
	private int currentIndex = -1;
	
	@Override 
	public Word nextWord() { 
		currentIndex = (currentIndex + 1) % words.size();
        return new Word(words.get(currentIndex));
	}

	@Override
	public String getName() {
		return "Estático";
	}

}
