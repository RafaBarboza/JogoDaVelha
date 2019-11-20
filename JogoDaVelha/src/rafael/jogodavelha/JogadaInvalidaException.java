package rafael.jogodavelha;
/**
 * Exce��o que representa uma jogada inv�lida realizada pelo jogador 
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
