package br.gov.sp.fatec.service;

import java.util.List;

import br.gov.sp.fatec.model.Categoria;
import br.gov.sp.fatec.model.Produto;

public interface ProdutoService {

	public void salvar(Produto produto);

	public Produto buscarPorId(Long id);

	public List<Produto> buscarTodos();

	public void excluir(Produto produto);

	public List<Produto> buscarPorCategoriaEFornecedor(Categoria categoria, String nome);

	public List<Produto> buscarPrecoMaiorQue(Double valor);

	public List<Produto> buscarPrecoMenorQue(Double valor);

	public List<Produto> buscarPorSequenciaDeCaractere(String nome);
}
