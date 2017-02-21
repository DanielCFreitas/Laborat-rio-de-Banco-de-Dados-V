package br.gov.sp.fatec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Produto;
import br.gov.sp.fatec.repository.ProdutoRepository;

@Service("produtoService")
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Transactional
	public void salvarProduto(Produto produto) {
		produtoRepository.save(produto);
	}

	@Transactional
	public void deletarProduto(Produto produto) {
		produtoRepository.delete(produto);
	}
}
