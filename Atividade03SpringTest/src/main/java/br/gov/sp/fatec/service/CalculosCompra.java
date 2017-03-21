package br.gov.sp.fatec.service;

import java.util.List;

import br.gov.sp.fatec.model.Produto;

public interface CalculosCompra {

	public Double valorTotalDosProdutos(List<Produto> produtosComprados);

	public Double calcularFrete(Double distancia);

	public Double valorTotal(List<Produto> listaDeProdutos, Double distancia);

}
