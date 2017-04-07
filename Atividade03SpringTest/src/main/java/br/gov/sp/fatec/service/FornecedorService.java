package br.gov.sp.fatec.service;

import java.util.List;

import br.gov.sp.fatec.model.Fornecedor;

public interface FornecedorService {

	public void salvar(Fornecedor fornecedor);

	public Fornecedor buscarPorId(Long id);

	public List<Fornecedor> buscarTodos();

	public void excluir(Fornecedor fornecedor);
}
