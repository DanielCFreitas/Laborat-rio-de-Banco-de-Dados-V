package br.gov.sp.fatec.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.model.Cliente;
import br.gov.sp.fatec.model.Venda;
import br.gov.sp.fatec.repository.VendaRepository;

@Service
public class VendaServiceImpl implements VendaService {

	@Autowired
	private VendaRepository vendaRepository;

	public void setVendaRepository(VendaRepository vendaRepository) {
		this.vendaRepository = vendaRepository;
	}

	public void salvar(Venda venda) {
		vendaRepository.save(venda);
	}

	public Venda buscarPorId(Long id) {
		return vendaRepository.findOne(id);
	}

	public List<Venda> buscarTodos() {
		return (List<Venda>) vendaRepository.findAll();
	}

	public void excluir(Venda venda) {
		vendaRepository.delete(venda);
	}

	public List<Venda> buscarVendasApArtirDe(Date inicio, Date fim) {
		return (List<Venda>) vendaRepository.buscarVendasAPartirDe(inicio, fim);
	}

	public List<Venda> buscarPorCliente(Cliente cliente) {
		return (List<Venda>) vendaRepository.findByClienteEquals(cliente);
	}

}
