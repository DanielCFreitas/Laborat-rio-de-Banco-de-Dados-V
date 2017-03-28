package br.gov.sp.fatec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.model.Fornecedor;
import br.gov.sp.fatec.repository.FornecedorRepository;

@Service
public class FornecedorServiceImpl implements CrudService<Fornecedor> {

	@Autowired
	private FornecedorRepository fornecedorRepository;

	public void setFornecedorRepository(FornecedorRepository fornecedorRepository) {
		this.fornecedorRepository = fornecedorRepository;
	}

	public void salvar(Fornecedor entity) {
		fornecedorRepository.save(entity);
	}

	public Fornecedor buscarPorId(Long id) {
		return fornecedorRepository.findOne(id);
	}

	public void deletar(Long id) {
		fornecedorRepository.delete(id);
	}

	public List<Fornecedor> buscarTodos() {
		return (List<Fornecedor>) fornecedorRepository.findAll();
	}

}
