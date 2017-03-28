package br.gov.sp.fatec.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.gov.sp.fatec.model.Produto;
import br.gov.sp.fatec.service.CalculosCompraImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
public class CalculosCompraImplTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private CalculosCompraImpl calculosCompraImpl;

	public void setCalculosCompraImpl(CalculosCompraImpl calculosCompraImpl) {
		this.calculosCompraImpl = calculosCompraImpl;
	}

	/**
	 * Testa valor total dos Produtos comprados
	 */
	@Test
	public void testValorTotalDeProdutos() {
		Produto produto = new Produto();
		produto.setNome("Computador");
		produto.setPreco(2500.00);

		Produto produto2 = new Produto();
		produto2.setNome("Camisa Apple");
		produto2.setPreco(25.00);

		List<Produto> produtosComprados = new ArrayList<Produto>();
		produtosComprados.add(produto);
		produtosComprados.add(produto2);

		Double valorTotalDosProdutos = calculosCompraImpl.valorTotalDosProdutos(produtosComprados);

		if (valorTotalDosProdutos != 2525.00) {
			Assert.fail();
		}
	}

	/**
	 * Testa o valor do frete
	 */
	@Test
	public void testCalcularFrete() {
		Double frete = calculosCompraImpl.calcularFrete(5.0);

		if (frete != 5.99) {
			Assert.fail();
		}

		frete = calculosCompraImpl.calcularFrete(25.0);

		if (frete != 10.99) {
			Assert.fail();
		}

		frete = calculosCompraImpl.calcularFrete(55.0);

		if (frete != 19.99) {
			Assert.fail();
		}
	}

	/**
	 * Faz o calculo do valor total da compra, somando todos os produtos e o
	 * valor do frete
	 */
	@Test
	public void testValorTotalCompra() {
		Produto produto = new Produto();
		produto.setNome("Computador");
		produto.setPreco(2500.00);

		Produto produto2 = new Produto();
		produto2.setNome("Camisa Apple");
		produto2.setPreco(25.00);

		List<Produto> produtosComprados = new ArrayList<Produto>();
		produtosComprados.add(produto);
		produtosComprados.add(produto2);

		Double valorTotal = calculosCompraImpl.valorTotal(produtosComprados, 55.0);

		if (valorTotal != 2544.99) {
			Assert.fail();
		}
	}
}
