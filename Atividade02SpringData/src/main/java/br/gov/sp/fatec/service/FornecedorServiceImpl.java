package br.gov.sp.fatec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.model.Fornecedor;
import br.gov.sp.fatec.repository.FornecedorRepository;

@Service
public class FornecedorServiceImpl implements FornecedorService {

	@Autowired
	private FornecedorRepository fornecedorRepository;

	public void setFornecedorRepository(FornecedorRepository fornecedorRepository) {
		this.fornecedorRepository = fornecedorRepository;
	}

	public void salvar(Fornecedor fornecedor) {
		fornecedorRepository.save(fornecedor);
	}

	public Fornecedor buscarPorId(Long id) {
		return fornecedorRepository.findOne(id);
	}

	public List<Fornecedor> buscarTodos() {
		return (List<Fornecedor>) fornecedorRepository.findAll();
	}

	public void excluir(Fornecedor fornecedor) {
		fornecedorRepository.delete(fornecedor);
	}

}
