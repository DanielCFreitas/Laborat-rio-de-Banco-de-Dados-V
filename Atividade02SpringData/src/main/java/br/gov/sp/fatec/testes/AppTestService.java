package br.gov.sp.fatec.testes;
import java.util.List;

import org.springframework.context.ApplicationContext;

import br.gov.sp.fatec.context.SpringContext;
import br.gov.sp.fatec.model.Produto;
import br.gov.sp.fatec.service.BuscaService;

public class AppTestService {

	public static void main(String[] args) {

		ApplicationContext context = SpringContext.getApplicationContext();

		BuscaService buscaService = context.getBean("buscaService", BuscaService.class);

		List<Produto> produtos = buscaService.buscarProdutosCompradosPorUmCliente(3L);

		for (Produto produtoIndividual : produtos) {
			System.out.println(produtoIndividual.toString());
		}
	}
}
