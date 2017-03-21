package br.gov.sp.fatec.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Cliente;
import br.gov.sp.fatec.repository.ClienteRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
@Transactional
public class ClienteRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private ClienteRepository clienteRepository;

	public void setClienteRepository(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	/**
	 * Teste para Cadastrar um Cliente
	 */
	@Test
	public void testCadastrar() {
		Cliente cliente = new Cliente();
		cliente.setNome("Daniel");
		cliente.setSobrenome("Freitas");
		cliente.setTelefone("26662656");
		clienteRepository.save(cliente);
		assertTrue(cliente.getId() != null);
	}

	/**
	 * Teste para Consultar um Cliente
	 */
	@Test
	public void testConsultar() {
		Cliente cliente = new Cliente();
		cliente.setNome("Daniel");
		cliente.setSobrenome("Freitas");
		cliente.setTelefone("26662656");
		clienteRepository.save(cliente);
		
		Cliente clienteTest = clienteRepository.findOne(1L);
		assertTrue(clienteTest != null);
	}

	/**
	 * Teste para Alterar um Cliente
	 */
	@Test
	public void testAlterar() {
		Cliente cliente = new Cliente();
		cliente.setNome("Daniel");
		cliente.setSobrenome("Freitas");
		cliente.setTelefone("26662656");
		clienteRepository.save(cliente);
		
		Cliente clienteTest = clienteRepository.findOne(1L);
		clienteTest.setNome("João");
		clienteRepository.save(cliente);

		Cliente clienteAlterarTest = clienteRepository.findOne(1L);
		assertTrue(clienteAlterarTest.getNome().equals("João"));
	}

	/**
	 * Teste para Deletar um Cliente
	 */
	@Test
	public void testDeletar() {
		Cliente cliente = new Cliente();
		cliente.setNome("Daniel");
		cliente.setSobrenome("Freitas");
		cliente.setTelefone("26662656");
		clienteRepository.save(cliente);
		
		Cliente clienteTest = clienteRepository.findOne(1L);
		clienteRepository.delete(clienteTest);
		
		Cliente clienteDeletarTest = clienteRepository.findOne(1L);
		assertTrue(clienteDeletarTest == null);
	}
}