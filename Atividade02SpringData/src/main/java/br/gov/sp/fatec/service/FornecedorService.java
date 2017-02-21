package br.gov.sp.fatec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Fornecedor;
import br.gov.sp.fatec.repository.FornecedorRepository;

@Service("fornecedorService")
public class FornecedorService {

	@Autowired
	private FornecedorRepository fornecedorRepository;

	@Transactional
	public void salvarFornecedor(Fornecedor fornecedor) {
		fornecedorRepository.save(fornecedor);
	}

	@Transactional
	public void deletarFornecedor(Fornecedor fornecedor) {
		fornecedorRepository.delete(fornecedor);
	}

}
