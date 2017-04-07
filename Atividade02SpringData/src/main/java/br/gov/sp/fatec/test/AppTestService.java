package br.gov.sp.fatec.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.gov.sp.fatec.context.SpringContext;
import br.gov.sp.fatec.model.Produto;
import br.gov.sp.fatec.service.BuscaService;

public class AppTestService {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext) SpringContext.getApplicationContext();

		BuscaService buscaService = context.getBean("buscaService", BuscaService.class);

		List<Produto> produtos = buscaService.buscarProdutosCompradosPorUmCliente(3L);

		for (Produto produtoIndividual : produtos) {
			System.out.println(produtoIndividual.toString());
		}

		context.close();
	}
}
