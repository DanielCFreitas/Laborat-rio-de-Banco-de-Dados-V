package br.gov.sp.fatec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.model.Venda;
import br.gov.sp.fatec.repository.VendaRepository;

@Service
public class VendaServiceImpl implements CrudService<Venda> {

	@Autowired
	private VendaRepository vendaRepository;

	public void setVendaRepository(VendaRepository vendaRepository) {
		this.vendaRepository = vendaRepository;
	}

	public void salvar(Venda entity) {
		vendaRepository.save(entity);
	}

	public Venda buscarPorId(Long id) {
		return vendaRepository.findOne(id);
	}

	public void deletar(Long id) {
		vendaRepository.delete(id);
	}

	public List<Venda> buscarTodos() {
		return (List<Venda>) vendaRepository.findAll();
	}

}
