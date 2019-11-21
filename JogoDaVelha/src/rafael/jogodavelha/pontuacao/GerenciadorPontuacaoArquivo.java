package rafael.jogodavelha.pontuacao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * Gerenciador de pontuação. Esta implementação armazena a pontuação em um arquivo.  
 */
public class GerenciadorPontuacaoArquivo implements GerenciadorPontuacao{
	
	/**
	 * Constante com o nome do arquivo onde será armazenada a pontuação.
	 */
	private static final String ARQUIVO_PONTUACAO = "pontuacao.txt";
	
	/**
	 * Mapa que armazena em memória a pontuação dos jogadores.
	 */
	private Map<String, Integer> pontuacaoMap = new HashMap<String, Integer>();
	
	/**
	 * Construtor.
	 * @throws PontuacaoException
	 */
	public GerenciadorPontuacaoArquivo() throws PontuacaoException {
		//Inicializa o gerenciador de pontuação.
		inicializar();
	}
	
	/**
	 * Inicializa o gerenciador de pontuação.
	 * @throws PontuacaoException
	 */
	@SuppressWarnings("deprecation")
	private void inicializar() throws PontuacaoException {
		//Verifica se o arquivo existe, caso não exista ele cria.
		File arquivo = new File(ARQUIVO_PONTUACAO);
		if(!arquivo.exists()) {
			try {
				arquivo.createNewFile();
			} catch (IOException e) {
				throw new PontuacaoException(e.getMessage());
			}
		}
		
		BufferedReader reader = null;
		
		try {
			//Utiliza um Bufferedreader para ler um arquivo.
			
			reader = new BufferedReader(new FileReader(arquivo));
			String line;
			
			while ((line = reader.readLine()) != null) {
				//O método split divide a linha em duas, onde cada token é separado por um '|'.
				String[] tokens = line.split("\\|");
				
				//Adiciona a pontuação lida no map.
				pontuacaoMap.put(tokens[0].toUpperCase(), new Integer(tokens[1]));
				
			}
		} catch (IOException e) {
			throw new PontuacaoException(e.getMessage());
		} finally {
			if(reader != null) {
				try {
					reader.close();
				} catch (Exception e2) {
					throw new PontuacaoException(e2.getMessage());
				}
			}
		}
	}

	@Override
	public Integer getPontuacao(String nome) {
		return pontuacaoMap.get(nome.toUpperCase());
	}

	@Override
	public void gravarPontuacao(String nome) throws PontuacaoException {
		//Lê a pontuação do jogador.
		Integer pontuacao = getPontuacao(nome);
		
		if (pontuacao == null) {
			pontuacao = 0;
		}

		// Incrementa a pontuação do jogador e recoloca no map
		pontuacaoMap.put(nome.toUpperCase(), pontuacao + 1);

		// Utiliza um BufferedWriter para armazenar as entradas do map no arquivo
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_PONTUACAO))) {
			for (Map.Entry<String, Integer> entry : pontuacaoMap.entrySet()) {
				// Escreve a linha no arquivo no formato '<nome>|<pontuação>'
				writer.write(entry.getKey() + "|" + entry.getValue());
				
				// Insere um quebra de linha
				writer.newLine();
			}
		
		} catch (IOException e) {
			throw new PontuacaoException(e.getMessage());
		}	
	}
}
