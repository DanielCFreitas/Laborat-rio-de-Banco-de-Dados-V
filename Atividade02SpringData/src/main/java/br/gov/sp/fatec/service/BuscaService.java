package br.gov.sp.fatec.service;

import java.util.List;

import br.gov.sp.fatec.model.Cliente;
import br.gov.sp.fatec.model.Produto;

public interface BuscaService {

	public List<Produto> buscarProdutosCompradosPorUmCliente(Long id);
}
