package br.gov.sp.fatec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.model.Categoria;
import br.gov.sp.fatec.model.Produto;
import br.gov.sp.fatec.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public void setProdutoRepository(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	public void salvar(Produto produto) {
		produtoRepository.save(produto);
	}

	public Produto buscarPorId(Long id) {
		return produtoRepository.findOne(id);
	}

	public List<Produto> buscarTodos() {
		return (List<Produto>) produtoRepository.findAll();
	}

	public void excluir(Produto produto) {
		produtoRepository.delete(produto);
	}

	public List<Produto> buscarPorCategoriaEFornecedor(Categoria categoria, String nome) {
		return (List<Produto>) produtoRepository.findByCategoriaAndFornecedorNomeEquals(categoria, nome);
	}

	public List<Produto> buscarPrecoMaiorQue(Double valor) {
		return (List<Produto>) produtoRepository.findByPrecoGreaterThan(valor);
	}

	public List<Produto> buscarPrecoMenorQue(Double valor) {
		return (List<Produto>) produtoRepository.findByPrecoLessThan(valor);
	}

	public List<Produto> buscarPorSequenciaDeCaractere(String nome) {
		return (List<Produto>) produtoRepository.findByNomeContaining(nome);
	}

}
