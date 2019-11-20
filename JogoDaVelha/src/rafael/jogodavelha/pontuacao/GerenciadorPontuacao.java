package rafael.jogodavelha.pontuacao;

/**
 * Interface utilizada para gerenciar a pontua��o. Classes que implementam essa interface
 * devem implementar a l�gica de como gravar e ler a pontua��o. 
 * @author Rafael Barboza
 *
 */
public interface GerenciadorPontuacao{
	
	/**
	 * Obt�m a pontua��o de determinado jogador.
	 * @param nome Nome do jogador para procurar a pontua��o.
	 * @return A pontua��o do jogador ou null caso a pontua��o n�o seja encontrada.
	 */
	public Integer getPontuacao(String nome);
	
	/**
	 * Imcrementa em um a pontua��o do jogador.
	 * @param nome Nome do jogador para procurar a pontua��o.
	 * @throws PontuacaoException lan�ada caso ocorra algum problema ao gravar a pontua��o.
	 */
	public void gravarPontuacao(String nome) throws PontuacaoException;
	
}
