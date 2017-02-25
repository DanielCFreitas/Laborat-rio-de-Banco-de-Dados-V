import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.gov.sp.fatec.model.Produto;
import br.gov.sp.fatec.service.BuscaService;

public class AppTestService {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		BuscaService buscaService = context.getBean("buscaService", BuscaService.class);

		List<Produto> produtos = buscaService.buscarProdutosCompradosPorUmCliente(3L);

		for (Produto produtoIndividual : produtos) {
			System.out.println(produtoIndividual.toString());
		}

		context.close();
	}
}
