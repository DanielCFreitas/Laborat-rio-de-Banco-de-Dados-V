import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.gov.sp.fatec.model.Categoria;
import br.gov.sp.fatec.model.Fornecedor;
import br.gov.sp.fatec.model.Produto;
import br.gov.sp.fatec.model.Venda;
import br.gov.sp.fatec.repository.FornecedorRepository;
import br.gov.sp.fatec.repository.ProdutoRepository;
import br.gov.sp.fatec.repository.VendaRepository;

public class App {

	public static void main(String[] args) {

		// Instancia Contexto
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Instancia dos Repository Bean
		ProdutoRepository produtoRepository = context.getBean("produtoRepository", ProdutoRepository.class);
		VendaRepository vendaRepository = context.getBean("vendaRepository", VendaRepository.class);
		FornecedorRepository fornecedorRepository = context.getBean("fornecedorrepository", FornecedorRepository.class);

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
		produto.setCategoria(Categoria.ELETRINICOS);

		produtoRepository.save(produto);

		// ==== TESTE CADASTRO VENDA ====
		Venda venda = new Venda();
		venda.setDataVenda(new Date());
		List<Produto> produtos = (List<Produto>) produtoRepository.findAll();
		venda.setProdutos(produtos);

		vendaRepository.save(venda);

		// ==== TESTE CONSULTAS ====

		// CONSULTA PRODUTOS DE UMA DETERMINADA CATEGORIA DE UM DETERMINADO
		// FORNECEDOR
		List<Produto> produtosDeCategoriaEFornecedor = produtoRepository
				.findByCategoriaAndFornecedorNomeEquals(Categoria.ELETRINICOS, "Positivo");

		if (produtosDeCategoriaEFornecedor.size() == 0) {
			System.out.println(
					"=========== Não foram encontrados produtos desta categoria deste fornecedor ===========");
		} else {
			for (Produto produtoIndividual : produtosDeCategoriaEFornecedor) {
				System.out.println(produtoIndividual.toString());
			}
		}

		// CONSULTA OS PRODUTOS QUE POSSUI UM PRECO MINIMO
		List<Produto> produtosComPrecoMinimo = produtoRepository.findByPrecoGreaterThan(1000d);

		if (produtosComPrecoMinimo.isEmpty()) {
			System.out.println("=========== Não foram encontrados produtos com este preco minimo ===========");
		} else {
			for (Produto produtoIndividual : produtosComPrecoMinimo) {
				System.out.println(produtoIndividual.toString());
			}
		}

		// CONSULTA OS PRODUTOS QUE POSSUI UM PRECO MAXIMO
		List<Produto> produtosComPrecoMaximo = produtoRepository.findByPrecoLessThan(1000d);
		if (produtosComPrecoMaximo.isEmpty()) {
			System.out.println("=========== Não foram encontrados produtos com este preco maximo ===========");
		} else {
			for (Produto produtoIndividual : produtosComPrecoMaximo) {
				System.out.println(produtoIndividual.toString());
			}
		}

		// CONSULTA OS PRODUTOS QUE POSSUEM UMA DETERMINADA SEQUENCIA DE
		// CARACTERES OU DETERMINADA LETRA
		List<Produto> produtoComSequenciaDeCaracteres = produtoRepository.findByNomeContaining("a");
		if (produtoComSequenciaDeCaracteres.isEmpty()) {
			System.out.println(
					"=========== Não foram encontrados produtos com esta sequencia de caracteres ===========");
		} else {
			for (Produto produtoIndividual : produtoComSequenciaDeCaracteres) {
				System.out.println(produtoIndividual.toString());
			}
		}

		// CONSULTA DE VENDA ENTRE DUAS DATAS
		Calendar inicioCalendar = Calendar.getInstance();
		inicioCalendar.set(Calendar.YEAR, 2017);
		inicioCalendar.set(Calendar.MONTH, Calendar.FEBRUARY);
		inicioCalendar.set(Calendar.DAY_OF_MONTH, 22);
		Date inicio = inicioCalendar.getTime();

		Calendar fimCalendar = Calendar.getInstance();
		inicioCalendar.set(Calendar.YEAR, 2017);
		inicioCalendar.set(Calendar.MONTH, Calendar.FEBRUARY);
		inicioCalendar.set(Calendar.DAY_OF_MONTH, 25);
		Date fim = fimCalendar.getTime();

		List<Venda> vendasEntreAsDatas = vendaRepository.buscarVendasAPartirDe(inicio, fim);

		if (vendasEntreAsDatas.isEmpty()) {
			System.out.println(
					"=========== Não foram encontrados produtos entre as duas datas especificadas ===========");
		} else {
			for (Venda vendaIndividual : vendasEntreAsDatas) {
				System.out.println(vendaIndividual.getDataVenda().toString());
			}
		}

		context.close();
	}

}
