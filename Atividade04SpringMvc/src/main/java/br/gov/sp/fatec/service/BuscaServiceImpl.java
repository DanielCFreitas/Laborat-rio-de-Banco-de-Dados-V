package br.gov.sp.fatec.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Cliente;
import br.gov.sp.fatec.model.Produto;
import br.gov.sp.fatec.model.Venda;
import br.gov.sp.fatec.repository.ClienteRepository;
import br.gov.sp.fatec.repository.VendaRepository;

@Service("buscaService")
public class BuscaServiceImpl implements BuscaService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private VendaRepository vendaRepository;

	@Transactional
	public ArrayList<Produto> buscarProdutosCompradosPorUmCliente(Long id) {

		Cliente cliente = clienteRepository.findOne(id);

		List<Venda> vendasFeitasParaDeterminadoCliente = vendaRepository.findByClienteEquals(cliente);

		ArrayList<Produto> produtosCompradosPeloCliente = new ArrayList<Produto>();

		for (Venda venda : vendasFeitasParaDeterminadoCliente) {
			for (Produto produto : venda.getProdutos()) {
				produtosCompradosPeloCliente.add(produto);
			}
		}

		return produtosCompradosPeloCliente;
	}

}
