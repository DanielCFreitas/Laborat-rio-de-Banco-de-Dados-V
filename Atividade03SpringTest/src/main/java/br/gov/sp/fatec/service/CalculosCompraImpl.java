package br.gov.sp.fatec.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.gov.sp.fatec.model.Produto;

@Service("calculosCompra")
public class CalculosCompraImpl implements CalculosCompra {

	/**
	 * Calcula o valor total da Compra
	 * 
	 * @param Lista
	 *            de produtos que serão comprados
	 * 
	 * @return Retorna o valor total dos Produtos Comprados
	 */
	public Double valorTotalDosProdutos(List<Produto> produtosComprados) {
		Double total = 0.0d;

		for (Produto produtoIndividual : produtosComprados) {
			total += produtoIndividual.getPreco();
		}

		return total;
	}

	/**
	 * Calcula frete da compra
	 * 
	 * @param Distancia
	 *            entre a loja e o local de entrega do produto
	 * 
	 * @return Retorna o valor do Frete
	 */
	public Double calcularFrete(Double distancia) {
		if (distancia < 20) {
			return 5.99;
		} else if (distancia < 50) {
			return 10.99;
		} else {
			return 19.99;
		}

	}

	/**
	 * Calcula o valor total da compra
	 * 
	 * @param produtos
	 *            Valor total dos produtos comprados
	 * @param frete
	 *            Valor do frete
	 * @return Valor total da compra
	 */
	public Double valorTotal(Double produtos, Double frete) {
		return produtos + frete;
	}

}
