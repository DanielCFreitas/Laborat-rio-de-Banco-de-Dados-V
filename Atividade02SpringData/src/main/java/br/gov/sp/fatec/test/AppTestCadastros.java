package br.gov.sp.fatec.test;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.gov.sp.fatec.context.SpringContext;
import br.gov.sp.fatec.model.Categoria;
import br.gov.sp.fatec.model.Cliente;
import br.gov.sp.fatec.model.Fornecedor;
import br.gov.sp.fatec.model.Produto;
import br.gov.sp.fatec.model.Venda;
import br.gov.sp.fatec.service.ClienteService;
import br.gov.sp.fatec.service.ClienteServiceImpl;
import br.gov.sp.fatec.service.FornecedorService;
import br.gov.sp.fatec.service.FornecedorServiceImpl;
import br.gov.sp.fatec.service.ProdutoService;
import br.gov.sp.fatec.service.ProdutoServiceImpl;
import br.gov.sp.fatec.service.VendaService;
import br.gov.sp.fatec.service.VendaServiceImpl;

public class AppTestCadastros {

	public static void main(String[] args) {

		// Instancia Contexto
		ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext) SpringContext.getApplicationContext();

		// Instancia dos Repository Bean
		ProdutoService produtoService = context.getBean("produtoServiceImpl", ProdutoServiceImpl.class);
		VendaService vendaService = context.getBean("vendaServiceImpl", VendaServiceImpl.class);
		FornecedorService fornecedorService = context.getBean("fornecedorServiceImpl", FornecedorServiceImpl.class);
		ClienteService clienteService = context.getBean("clienteServiceImpl", ClienteServiceImpl.class);

		// Instancia dos Service Bean

		// ==== TESTE CADASTRO FORNECEDOR ====
		Fornecedor fornecedor = new Fornecedor();

		fornecedor.setNome("LG");
		fornecedor.setCnpj("96581441");
		fornecedor.setEndereco("Rua Gomide Santos");
		fornecedor.setTelefone("(12) 1713-6713");

		fornecedorService.salvar(fornecedor);

		// ==== TESTE CADASTRO PRODUTO ====
		Produto produto = new Produto();
		produto.setNome("Computador Dual Core");
		produto.setFornecedor(fornecedor);
		produto.setPreco(1251.00);
		produto.setCategoria(Categoria.ELETRONICOS);

		produtoService.salvar(produto);

		// ==== TESTE CADASTRO CLIENTE ====
		Cliente cliente = new Cliente();
		cliente.setNome("Joao");
		cliente.setSobrenome("Rafael");
		cliente.setTelefone("(12) 3977-7788");

		clienteService.salvar(cliente);

		// ==== TESTE CADASTRO VENDA ====
		Venda venda = new Venda();
		venda.setCliente(cliente);
		venda.setDataVenda(new Date());
		List<Produto> produtos = (List<Produto>) produtoService.buscarTodos();
		venda.setProdutos(produtos);

		vendaService.salvar(venda);

		context.close();

	}

}
