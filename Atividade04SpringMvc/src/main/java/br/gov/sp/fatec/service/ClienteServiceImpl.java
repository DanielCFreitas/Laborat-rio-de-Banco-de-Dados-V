package br.gov.sp.fatec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.model.Cliente;
import br.gov.sp.fatec.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements CrudService<Cliente> {

	@Autowired
	private ClienteRepository clienteRepository;

	public void setClienteRepository(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public void salvar(Cliente entity) {
		clienteRepository.save(entity);
	}

	public Cliente buscarPorId(Long id) {
		return clienteRepository.findOne(id);
	}

	public void deletar(Long id) {
		clienteRepository.delete(id);
	}

	public List<Cliente> buscarTodos() {
		return (List<Cliente>) clienteRepository.findAll();
	}

}
