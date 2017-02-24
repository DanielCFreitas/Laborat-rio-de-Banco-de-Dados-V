package br.gov.sp.fatec.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe que representa uma venda na aplicacao
 * 
 * @author Daniel
 *
 */

@Entity
@Table(name = "VEN_VENDA")
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VEN_ID", nullable = false)
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "VEN_DATA", nullable = false)
	private Date dataVenda;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "VPV_VENDA_PRODUTO", joinColumns = { @JoinColumn(name = "VEN_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "PROD_ID") })
	private List<Produto> produtos;

	@ManyToOne
	private Cliente cliente;

	public Venda() {

	}

	/**
	 * Método que retorna o Id de uma Venda
	 * 
	 * @return Id de uma Venda
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Método que seta o Id de uma Venda
	 * 
	 * @param id
	 *            Id de uma Venda
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Método que retorna a data da venda de um produto
	 * 
	 * @return Data da venda de um produto
	 */
	public Date getDataVenda() {
		return dataVenda;
	}

	/**
	 * Método que seta a data da venda de um produto
	 * 
	 * @param dataVenda
	 *            Data da venda de um produto
	 */
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	/**
	 * Método que retorna a lista de Produtos Vendidos
	 * 
	 * @return produtos Produtos Vendidos
	 */
	public List<Produto> getProdutos() {
		return produtos;
	}

	/**
	 * Método que seta a lista de produtos que um cliente comprou
	 * 
	 * @param Lista
	 *            de Produtos
	 */
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	/**
	 * Método que retorna um cliente
	 * 
	 * @return Data da venda de um produto
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * Método que seta o cliente de uma venda
	 * 
	 * @param Cliente
	 *            da venda
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * Método para retornar uma String com as informações de uma venda
	 * 
	 * @return Retorna informações de um Objeto Venda
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("=== Venda ===");
		sb.append("\nData da Venda: ");
		sb.append(this.dataVenda.toString());
		sb.append("\nCliente: ");
		sb.append(this.cliente.getNome());
		sb.append("Produtos: ");
		for (Produto produtoIndividual : this.produtos) {
			sb.append("\n");
			sb.append(produtoIndividual.getNome());
		}

		return sb.toString();

	}

}
