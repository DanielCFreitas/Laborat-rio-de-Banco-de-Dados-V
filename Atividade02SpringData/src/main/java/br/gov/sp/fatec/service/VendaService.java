package br.gov.sp.fatec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Venda;
import br.gov.sp.fatec.repository.VendaRepository;

@Service("vendaService")
public class VendaService {

	@Autowired
	private VendaRepository vendaRepository;

	@Transactional
	public void salvarVenda(Venda venda) {
		vendaRepository.save(venda);
	}

	@Transactional
	public void deletarVenda(Venda venda) {
		vendaRepository.delete(venda);
	}
}
