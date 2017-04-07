package br.gov.sp.fatec.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Categoria;
import br.gov.sp.fatec.model.Fornecedor;
import br.gov.sp.fatec.model.Produto;
import br.gov.sp.fatec.service.FornecedorService;
import br.gov.sp.fatec.service.FornecedorServiceImpl;
import br.gov.sp.fatec.service.ProdutoService;
import br.gov.sp.fatec.service.ProdutoServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
@Transactional
public class ProdutoServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private FornecedorService fornecedorService;

	@Autowired
	private ProdutoService produtoService;

	public void setProdutoService(ProdutoServiceImpl produtoService) {
		this.produtoService = produtoService;
	}

	public void setFornecedorService(FornecedorServiceImpl fornecedorService) {
		this.fornecedorService = fornecedorService;
	}

	/**
	 * Testa o cadastro de Produto no Banco de Dados
	 */
	@Test
	public void testCadastrar() {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome("Apple");
		fornecedor.setCnpj("3261761");
		fornecedor.setEndereco("Avenida Paulista");
		fornecedor.setTelefone("36556559");
		fornecedorService.salvar(fornecedor);

		Produto produto = new Produto();
		produto.setFornecedor(fornecedor);
		produto.setNome("Computador");
		produto.setPreco(2500.00);
		produto.setCategoria(Categoria.ELETRONICOS);
		produtoService.salvar(produto);

		assertTrue(produto.getId() != null);
	}

	/**
	 * Testa a consulta de Produto no Banco de Dados
	 */
	@Test
	public void testConsulta() {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome("Apple");
		fornecedor.setCnpj("3261761");
		fornecedor.setEndereco("Avenida Paulista");
		fornecedor.setTelefone("36556559");
		fornecedorService.salvar(fornecedor);

		Produto produto = new Produto();
		produto.setFornecedor(fornecedor);
		produto.setNome("Computador");
		produto.setPreco(2500.00);
		produto.setCategoria(Categoria.ELETRONICOS);
		produtoService.salvar(produto);

		Produto produtoTest = new Produto();
		produtoTest = produtoService.buscarPorId(1L);

		assertTrue(produtoTest != null);
	}

	/**
	 * Testa a alteracao de um Produto no Banco de Dados
	 */
	@Test
	public void testAlterar() {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome("Apple");
		fornecedor.setCnpj("3261761");
		fornecedor.setEndereco("Avenida Paulista");
		fornecedor.setTelefone("36556559");
		fornecedorService.salvar(fornecedor);

		Produto produto = new Produto();
		produto.setFornecedor(fornecedor);
		produto.setNome("Computador");
		produto.setPreco(2500.00);
		produto.setCategoria(Categoria.ELETRONICOS);
		produtoService.salvar(produto);

		Produto produtoTest = produtoService.buscarPorId(1L);
		produtoTest.setPreco(3000.00);
		produtoService.salvar(produtoTest);

		Produto produtoAlterarTest = produtoService.buscarPorId(1L);

		assertTrue(produtoAlterarTest.getPreco() == 3000.00);
	}

	/**
	 * Testa a exclusao de um Produto no Banco de Dados
	 */
	@Test
	public void testDeletar() {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome("Apple");
		fornecedor.setCnpj("3261761");
		fornecedor.setEndereco("Avenida Paulista");
		fornecedor.setTelefone("36556559");
		fornecedorService.salvar(fornecedor);

		Produto produto = new Produto();
		produto.setFornecedor(fornecedor);
		produto.setNome("Computador");
		produto.setPreco(2500.00);
		produto.setCategoria(Categoria.ELETRONICOS);
		produtoService.salvar(produto);

		produtoService.excluir(produto);

		Produto produtoTest = produtoService.buscarPorId(produto.getId());
		assertTrue(produtoTest == null);
	}

	/**
	 * Busca todos os produtos de uma Categoria especifica que sejam fabricadas
	 * por um determinado fornecedor
	 */
	@Test
	public void testBuscaProdutosPorCategoriaDeUmDeterminadoFornecedor() {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome("Apple");
		fornecedor.setCnpj("3261761");
		fornecedor.setEndereco("Avenida Paulista");
		fornecedor.setTelefone("36556559");
		fornecedorService.salvar(fornecedor);

		Produto produto = new Produto();
		produto.setFornecedor(fornecedor);
		produto.setNome("Computador");
		produto.setPreco(2500.00);
		produto.setCategoria(Categoria.ELETRONICOS);
		produtoService.salvar(produto);

		Produto produto2 = new Produto();
		produto2.setFornecedor(fornecedor);
		produto2.setNome("Camisa Apple");
		produto2.setPreco(25.00);
		produto2.setCategoria(Categoria.VESTIMENTAS);
		produtoService.salvar(produto2);

		// Busca os produtos que sao da categoria Eletronicos do Fornecedor
		// Apple
		List<Produto> listaDeProdutos = produtoService.buscarPorCategoriaEFornecedor(Categoria.ELETRONICOS, "Apple");

		for (Produto produtoCorrente : listaDeProdutos) {
			if (!produtoCorrente.getCategoria().equals(Categoria.ELETRONICOS)) {
				Assert.fail();
			}
		}
	}

	/**
	 * Teste para buscar produtos que tenham um preco minimo que sera passado
	 * como parametro
	 */
	@Test
	public void testBuscaProdutoAcimaDeUmPrecoMinimo() {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome("Apple");
		fornecedor.setCnpj("3261761");
		fornecedor.setEndereco("Avenida Paulista");
		fornecedor.setTelefone("36556559");
		fornecedorService.salvar(fornecedor);

		Produto produto = new Produto();
		produto.setFornecedor(fornecedor);
		produto.setNome("Computador");
		produto.setPreco(2500.00);
		produto.setCategoria(Categoria.ELETRONICOS);
		produtoService.salvar(produto);

		Produto produto2 = new Produto();
		produto2.setFornecedor(fornecedor);
		produto2.setNome("Camisa Apple");
		produto2.setPreco(25.00);
		produto2.setCategoria(Categoria.VESTIMENTAS);
		produtoService.salvar(produto2);

		// Busca produtos que tenham o preco acima de 1000.00
		List<Produto> listaDeProdutos = produtoService.buscarPrecoMaiorQue(1000.00);
		for (Produto produtoCorrente : listaDeProdutos) {
			if (produtoCorrente.getPreco() < 1000.00) {
				Assert.fail();
			}
		}
	}

	/**
	 * Teste para buscar produtos que tenham um preco maximo que sera passado
	 * como parametro
	 */
	@Test
	public void testBuscaProdutoAbaixoDeUmPrecoMaximo() {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome("Apple");
		fornecedor.setCnpj("3261761");
		fornecedor.setEndereco("Avenida Paulista");
		fornecedor.setTelefone("36556559");
		fornecedorService.salvar(fornecedor);

		Produto produto = new Produto();
		produto.setFornecedor(fornecedor);
		produto.setNome("Computador");
		produto.setPreco(2500.00);
		produto.setCategoria(Categoria.ELETRONICOS);
		produtoService.salvar(produto);

		Produto produto2 = new Produto();
		produto2.setFornecedor(fornecedor);
		produto2.setNome("Camisa Apple");
		produto2.setPreco(25.00);
		produto2.setCategoria(Categoria.VESTIMENTAS);
		produtoService.salvar(produto2);

		// Busca produtos que tenham o preco acima de 1000.00
		List<Produto> listaDeProdutos = produtoService.buscarPrecoMenorQue(1000.00);
		for (Produto produtoCorrente : listaDeProdutos) {
			if (produtoCorrente.getPreco() > 1000.00) {
				Assert.fail();
			}
		}
	}

	/**
	 * Teste busca produto por sequencia de caracteres
	 */
	@Test
	public void testBuscaPorSequenciaDeCaracteres() {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome("Apple");
		fornecedor.setCnpj("3261761");
		fornecedor.setEndereco("Avenida Paulista");
		fornecedor.setTelefone("36556559");
		fornecedorService.salvar(fornecedor);

		Produto produto = new Produto();
		produto.setFornecedor(fornecedor);
		produto.setNome("Computador");
		produto.setPreco(2500.00);
		produto.setCategoria(Categoria.ELETRONICOS);
		produtoService.salvar(produto);

		// Busca nome do produto por sequencia de caracteres
		List<Produto> listaDeProdutos = produtoService.buscarPorSequenciaDeCaractere("Comp");

		for (Produto produtoCorrente : listaDeProdutos) {
			if (!produtoCorrente.getNome().contains("Comp")) {
				Assert.fail();
			}
		}

	}

}
