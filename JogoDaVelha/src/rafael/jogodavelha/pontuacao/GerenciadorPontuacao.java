package rafael.jogodavelha.pontuacao;

/**
 * Interface utilizada para gerenciar a pontuação. Classes que implementam essa interface
 * devem implementar a lógica de como gravar e ler a pontuação. 
 * @author Rafael Barboza
 *
 */
public interface GerenciadorPontuacao{
	
	/**
	 * Obtém a pontuação de determinado jogador.
	 * @param nome Nome do jogador para procurar a pontuação.
	 * @return A pontuação do jogador ou null caso a pontuação não seja encontrada.
	 */
	public Integer getPontuacao(String nome);
	
	/**
	 * Imcrementa em um a pontuação do jogador.
	 * @param nome Nome do jogador para procurar a pontuação.
	 * @throws PontuacaoException lançada caso ocorra algum problema ao gravar a pontuação.
	 */
	public void gravarPontuacao(String nome) throws PontuacaoException;
	
}
