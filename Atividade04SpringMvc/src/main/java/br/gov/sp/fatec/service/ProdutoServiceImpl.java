package br.gov.sp.fatec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.model.Produto;
import br.gov.sp.fatec.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements CrudService<Produto> {

	@Autowired
	private ProdutoRepository produtoRepository;

	public void setProdutoRepository(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	public void salvar(Produto entity) {
		produtoRepository.save(entity);
	}

	public Produto buscarPorId(Long id) {
		return produtoRepository.findOne(id);
	}

	public void deletar(Long id) {
		produtoRepository.delete(id);
	}

	public List<Produto> buscarTodos() {
		return (List<Produto>) produtoRepository.findAll();
	}

}
