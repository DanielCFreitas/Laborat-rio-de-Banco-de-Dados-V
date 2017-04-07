package br.gov.sp.fatec.test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.gov.sp.fatec.context.SpringContext;
import br.gov.sp.fatec.model.Categoria;
import br.gov.sp.fatec.model.Produto;
import br.gov.sp.fatec.model.Venda;
import br.gov.sp.fatec.service.ProdutoService;
import br.gov.sp.fatec.service.ProdutoServiceImpl;
import br.gov.sp.fatec.service.VendaService;
import br.gov.sp.fatec.service.VendaServiceImpl;

public class AppTestConsultas {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext) SpringContext.getApplicationContext();

		ProdutoService produtoService = context.getBean("produtoServiceImpl", ProdutoServiceImpl.class);
		VendaService vendaService = context.getBean("vendaServiceImpl", VendaServiceImpl.class);

		// ==== TESTE CONSULTAS ====

		// CONSULTA PRODUTOS DE UMA DETERMINADA CATEGORIA DE UM DETERMINADO
		// FORNECEDOR
		List<Produto> produtosDeCategoriaEFornecedor = produtoService
				.buscarPorCategoriaEFornecedor(Categoria.ELETRONICOS, "Samsung");

		if (produtosDeCategoriaEFornecedor.size() == 0) {
			System.out
					.println("=========== Não foram encontrados produtos desta categoria deste fornecedor ===========");
		} else {
			for (Produto produtoIndividual : produtosDeCategoriaEFornecedor) {
				System.out.println(produtoIndividual.toString());
			}
		}

		// CONSULTA OS PRODUTOS QUE POSSUI UM PRECO MINIMO
		List<Produto> produtosComPrecoMinimo = produtoService.buscarPrecoMaiorQue(1000d);

		if (produtosComPrecoMinimo.isEmpty()) {
			System.out.println("=========== Não foram encontrados produtos com este preco minimo ===========");
		} else {
			for (Produto produtoIndividual : produtosComPrecoMinimo) {
				System.out.println(produtoIndividual.toString());
			}
		}

		// CONSULTA OS PRODUTOS QUE POSSUI UM PRECO MAXIMO
		List<Produto> produtosComPrecoMaximo = produtoService.buscarPrecoMenorQue(1000d);
		if (produtosComPrecoMaximo.isEmpty()) {
			System.out.println("=========== Não foram encontrados produtos com este preco maximo ===========");
		} else {
			for (Produto produtoIndividual : produtosComPrecoMaximo) {
				System.out.println(produtoIndividual.toString());
			}
		}

		// CONSULTA OS PRODUTOS QUE POSSUEM UMA DETERMINADA SEQUENCIA DE
		// CARACTERES OU DETERMINADA LETRA
		List<Produto> produtoComSequenciaDeCaracteres = produtoService.buscarPorSequenciaDeCaractere("a");
		if (produtoComSequenciaDeCaracteres.isEmpty()) {
			System.out
					.println("=========== Não foram encontrados produtos com esta sequencia de caracteres ===========");
		} else {
			for (Produto produtoIndividual : produtoComSequenciaDeCaracteres) {
				System.out.println(produtoIndividual.toString());
			}
		}

		// CONSULTA DE VENDA ENTRE DUAS DATAS
		Calendar inicioCalendar = Calendar.getInstance();
		inicioCalendar.set(Calendar.YEAR, 2010);
		inicioCalendar.set(Calendar.MONTH, Calendar.JANUARY);
		inicioCalendar.set(Calendar.DAY_OF_MONTH, 01);
		Date inicio = inicioCalendar.getTime();

		Calendar fimCalendar = Calendar.getInstance();
		inicioCalendar.set(Calendar.YEAR, 2014);
		inicioCalendar.set(Calendar.MONTH, Calendar.DECEMBER);
		inicioCalendar.set(Calendar.DAY_OF_MONTH, 31);
		Date fim = fimCalendar.getTime();

		List<Venda> vendasEntreAsDatas = vendaService.buscarVendasApArtirDe(inicio, fim);

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
