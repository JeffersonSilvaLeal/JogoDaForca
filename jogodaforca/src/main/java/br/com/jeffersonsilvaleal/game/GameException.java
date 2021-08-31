package br.com.jeffersonsilvaleal.game;

// RuntimeException não precisa ser lançada no throws 
@SuppressWarnings("serial")
public class GameException extends RuntimeException {

	public GameException(String message) {
		super(message);
	}

}
