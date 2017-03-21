package br.gov.sp.fatec.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Categoria;
import br.gov.sp.fatec.model.Fornecedor;
import br.gov.sp.fatec.model.Produto;
import br.gov.sp.fatec.repository.FornecedorRepository;
import br.gov.sp.fatec.repository.ProdutoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
@Transactional
public class ProdutoRepositoryTest {

	@Autowired
	private FornecedorRepository fornecedorRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	public void setProdutoRepository(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	@Test
	public void testCadastrar() {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome("Apple");
		fornecedor.setCnpj("3261761");
		fornecedor.setEndereco("Avenida Paulista");
		fornecedor.setTelefone("36556559");
		fornecedorRepository.save(fornecedor);

		Produto produto = new Produto();
		produto.setFornecedor(fornecedor);
		produto.setNome("Computador");
		produto.setPreco(2500.00);
		produto.setCategoria(Categoria.ELETRONICOS);
		produtoRepository.save(produto);
		
		assertTrue(produto.getId() != null);
	}
}
