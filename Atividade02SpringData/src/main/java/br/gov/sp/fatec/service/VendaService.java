package br.gov.sp.fatec.service;

import java.util.Date;
import java.util.List;

import br.gov.sp.fatec.model.Cliente;
import br.gov.sp.fatec.model.Venda;

public interface VendaService {

	public void salvar(Venda venda);

	public Venda buscarPorId(Long id);

	public List<Venda> buscarTodos();

	public void excluir(Venda venda);

	public List<Venda> buscarVendasApArtirDe(Date inicio, Date fim);

	public List<Venda> buscarPorCliente(Cliente cliente);
}
