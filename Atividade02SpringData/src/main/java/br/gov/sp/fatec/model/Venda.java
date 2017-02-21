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
	 * Método que retorna uma lista de produtos vendidos
	 * 
	 * @return Lista de Produtos Vendidos
	 */
	public List<Produto> getProduto() {
		return produtos;
	}

	/**
	 * Método que seta a lista de Produtos Vendidos
	 * 
	 * @param produtos
	 *            Produtos Vendidos
	 */
	public void setProduto(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("=== Venda ===");
		sb.append("Data da Venda: ");
		sb.append(this.dataVenda.toString());
		sb.append("Produtos: ");
		for (Produto produtoIndividual : this.produtos) {
			sb.append("\n");
			sb.append(produtoIndividual.getNome());
		}

		return sb.toString();

	}

}
