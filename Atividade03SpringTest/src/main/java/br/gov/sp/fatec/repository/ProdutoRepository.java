package br.gov.sp.fatec.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Categoria;
import br.gov.sp.fatec.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {

	/**
	 * Busca os produtos que sejam de uma determinada categoria de um
	 * determinado fornecedor
	 * 
	 * @param categoria
	 *            Categoria do Produto
	 * @param fornecedor
	 *            Fornecedor do Produto
	 * @return Lista de Produtos com a mesma categoria e fornecedor
	 */
	public List<Produto> findByCategoriaAndFornecedorNomeEquals(Categoria categoria, String nome);

	/**
	 * Busca os produtos que os precos sejam acima de um determinado valor
	 * 
	 * @param valor
	 *            Preco minimo do produto
	 * @return Lista de Produtos com o preco acima do valor passado como o
	 *         minimo desejado
	 */
	public List<Produto> findByPrecoGreaterThan(Double valor);

	/**
	 * Busca os produtos que os precos sejam menores do que um determinado valor
	 * 
	 * @param valor
	 *            Preco maximo do produto
	 * @return Lista de Produtos com o preco abaixo do valor passado como
	 *         parametro do metodo
	 */
	public List<Produto> findByPrecoLessThan(Double valor);

	/**
	 * Busca os produtos que tenham uma determinada sequencia de caracteres em
	 * seu nome
	 * 
	 * @param nome
	 *            Sequencia de caracteres que se deseja buscar
	 * @return Lista de Produtos que tenham a sequencia de caracteres passadas
	 *         como parametro do método
	 */
	public List<Produto> findByNomeContaining(String nome);
}
