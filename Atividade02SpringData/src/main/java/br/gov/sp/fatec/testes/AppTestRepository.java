package br.gov.sp.fatec.testes;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;

import br.gov.sp.fatec.context.SpringContext;
import br.gov.sp.fatec.model.Categoria;
import br.gov.sp.fatec.model.Cliente;
import br.gov.sp.fatec.model.Fornecedor;
import br.gov.sp.fatec.model.Produto;
import br.gov.sp.fatec.model.Venda;
import br.gov.sp.fatec.repository.ClienteRepository;
import br.gov.sp.fatec.repository.FornecedorRepository;
import br.gov.sp.fatec.repository.ProdutoRepository;
import br.gov.sp.fatec.repository.VendaRepository;

public class AppTestRepository {

	public static void main(String[] args) {

		// Instancia Contexto
		ApplicationContext context = SpringContext.getApplicationContext();

		// Instancia dos Repository Bean
		ProdutoRepository produtoRepository = context.getBean("produtoRepository", ProdutoRepository.class);
		VendaRepository vendaRepository = context.getBean("vendaRepository", VendaRepository.class);
		FornecedorRepository fornecedorRepository = context.getBean("fornecedorRepository", FornecedorRepository.class);
		ClienteRepository clienteRepository = context.getBean("clienteRepository", ClienteRepository.class);

		// Instancia dos Service Bean

		// ==== TESTE CADASTRO FORNECEDOR ====
		Fornecedor fornecedor = new Fornecedor();

		fornecedor.setNome("LG");
		fornecedor.setCnpj("9658441");
		fornecedor.setEndereco("Rua Gomide Santos");
		fornecedor.setTelefone("(12) 1713-6713");

		fornecedorRepository.save(fornecedor);

		// ==== TESTE CADASTRO PRODUTO ====
		Produto produto = new Produto();
		produto.setNome("Computador Dual Core");
		produto.setFornecedor(fornecedor);
		produto.setPreco(1251.00);
		produto.setCategoria(Categoria.ELETRONICOS);

		produtoRepository.save(produto);

		// ==== TESTE CADASTRO CLIENTE ====
		Cliente cliente = new Cliente();
		cliente.setNome("Joao");
		cliente.setSobrenome("Rafael");
		cliente.setTelefone("(12) 3977-7788");

		clienteRepository.save(cliente);

		// ==== TESTE CADASTRO VENDA ====
		Venda venda = new Venda();
		venda.setDataVenda(new Date());
		List<Produto> produtos = (List<Produto>) produtoRepository.findAll();
		venda.setProdutos(produtos);
		venda.setCliente(cliente);

		vendaRepository.save(venda);
	}

}
