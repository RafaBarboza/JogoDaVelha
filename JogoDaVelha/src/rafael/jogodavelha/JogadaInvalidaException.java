package rafael.jogodavelha;
/**
 * Exceção que representa uma jogada inválida realizada pelo jogador 
 * @author rafa_
 *
 */
public class JogadaInvalidaException extends JogoDaVelhaException{
	
	/**
	 * @see JogoDaVelhaException#JogoDaVelhaException(String)
	 * @param message
	 */
	public JogadaInvalidaException(String message) {
		super(message);
	}
}
