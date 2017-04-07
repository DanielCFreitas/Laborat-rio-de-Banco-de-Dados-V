package br.gov.sp.fatec.service;

import java.util.List;

import br.gov.sp.fatec.model.Cliente;

public interface ClienteService {

	public void salvar(Cliente cliente);

	public Cliente buscarPorId(Long id);

	public List<Cliente> buscarTodos();

	public void excluir(Cliente cliente);
}
