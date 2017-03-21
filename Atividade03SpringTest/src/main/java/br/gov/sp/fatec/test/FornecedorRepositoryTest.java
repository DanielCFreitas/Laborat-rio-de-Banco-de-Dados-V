package br.gov.sp.fatec.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Fornecedor;
import br.gov.sp.fatec.repository.FornecedorRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
@Transactional
public class FornecedorRepositoryTest {

	@Autowired
	private FornecedorRepository fornecedorRepository;

	public void setFornecedorRepository(FornecedorRepository fornecedorRepository) {
		this.fornecedorRepository = fornecedorRepository;
	}

	@Test
	public void testCadastrar() {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome("Apple");
		fornecedor.setEndereco("Avenida Brasil");
		fornecedor.setCnpj("652365623");
		fornecedor.setTelefone("36556592");
		fornecedorRepository.save(fornecedor);
		assertTrue(fornecedor.getId() != null);
	}
	
	@Test
	public void testConsultar(){
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome("Apple");
		fornecedor.setEndereco("Avenida Brasil");
		fornecedor.setCnpj("652365623");
		fornecedor.setTelefone("36556592");
		fornecedorRepository.save(fornecedor);
		Fornecedor fornecedorTest = fornecedorRepository.findOne(1L);
		assertTrue(fornecedorTest != null);
	}
	
	@Test
	public void testAlterar(){
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome("Apple");
		fornecedor.setEndereco("Avenida Brasil");
		fornecedor.setCnpj("652365623");
		fornecedor.setTelefone("36556592");
		fornecedorRepository.save(fornecedor);
		Fornecedor fornecedorTest = fornecedorRepository.findOne(1L);
		fornecedorTest.setNome("Samsung");
		fornecedorRepository.save(fornecedorTest);
		
		
		Fornecedor fornecedorAlteradoTest = fornecedorRepository.findOne(1L);
		assertTrue(fornecedorAlteradoTest.getNome().equals("Samsung"));
	}
	
	@Test
	public void testDeleta(){
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome("Apple");
		fornecedor.setEndereco("Avenida Brasil");
		fornecedor.setCnpj("652365623");
		fornecedor.setTelefone("36556592");
		fornecedorRepository.save(fornecedor);
		
		Fornecedor fornecedorTest = fornecedorRepository.findOne(1L);
		fornecedorRepository.delete(fornecedorTest);
		
		Fornecedor fornecedorDeletaTest = fornecedorRepository.findOne(1L);
		assertTrue(fornecedorDeletaTest == null);
	}
}
