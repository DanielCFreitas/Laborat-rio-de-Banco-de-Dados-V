package br.gov.sp.fatec.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Cliente;
import br.gov.sp.fatec.model.Venda;

public interface VendaRepository extends CrudRepository<Venda, Long> {

	/**
	 * Busca vendas que foram feitas no intervalo de duas datas diferentes
	 * 
	 * @param inicio
	 *            Data inicial
	 * @param fim
	 *            Data final
	 * @return Retorna lista de vendas realizadas entre as duas datas
	 */
	@Query("select v from Venda v where v.dataVenda between ?1 and ?2")
	public List<Venda> buscarVendasAPartirDe(Date inicio, Date fim);

	/**
	 * Busca compra que determinado cliente realizou
	 * 
	 * @param cliente
	 *            Cliente que realizou a compra
	 * @return Lista contendo Vendas que foram feitas para determinado cliente
	 */
	public List<Venda> findByClienteEquals(Cliente cliente);
}
