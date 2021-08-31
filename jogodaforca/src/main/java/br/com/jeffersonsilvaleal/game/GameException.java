package br.com.jeffersonsilvaleal.game;

// RuntimeException n�o precisa ser lan�ada no throws 
@SuppressWarnings("serial")
public class GameException extends RuntimeException {

	public GameException(String message) {
		super(message);
	}

}
