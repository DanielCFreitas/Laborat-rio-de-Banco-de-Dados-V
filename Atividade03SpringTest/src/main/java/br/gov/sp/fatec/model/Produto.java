package br.gov.sp.fatec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe que representa um produto na aplicacao
 * 
 * @author Daniel
 *
 */
@Entity
@Table(name = "PROD_PRODUTO")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROD_ID", nullable = false)
	private Long id;

	@Column(name = "PROD_NOME", length = 50, nullable = false)
	private String nome;

	@Column(name = "PROD_PRECO", nullable = false)
	private Double preco;

	@Enumerated(EnumType.STRING)
	@Column(name = "PROD_CATEGORIA", length = 11, nullable = false)
	private Categoria categoria;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FORN_ID", nullable = false)
	private Fornecedor fornecedor;

	public Produto() {

	}

	/**
	 * Método que retorna o Id do Produto
	 * 
	 * @return Id do Produto
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Método que seta o Id do Produto
	 * 
	 * @param id
	 *            Id do Produto
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Método que retorna o Nome do Produto
	 * 
	 * @return Nome do Produto
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método que seta o Nome do Produto
	 * 
	 * @param nome
	 *            Nome do Produto
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Método que retorna o Fornecedor do Produto
	 * 
	 * @return Fornecedor do Produto
	 */
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	/**
	 * Método que seta o Fornecedor do Produto
	 * 
	 * @param fornecedor
	 *            Fornecedor do Produto
	 */
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	/**
	 * Método que retorna o Preco do Produto
	 * 
	 * @return Preco do Produto
	 */
	public Double getPreco() {
		return preco;
	}

	/**
	 * Método que seta o Preco do Produto
	 * 
	 * @param preco
	 *            Preco do Produto
	 */
	public void setPreco(Double preco) {
		this.preco = preco;
	}

	/**
	 * Método que retorna a Categoria do Produto
	 * 
	 * @return Categoria do Produto
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * Método que seta a Categoria do Produto
	 * 
	 * @param categoria
	 *            Categoria do Produto
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	/**
	 * Método para retornar uma String com as informações de um Produto
	 * 
	 * @return Retorna informações de um Objeto Produto
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("\n=== PRODUTO ===\n");
		sb.append("\nNome: ");
		sb.append(this.nome);
		sb.append("\nFornecedor: ");
		sb.append(this.fornecedor.getNome());
		sb.append("\nPreco: R$ ");
		sb.append(this.preco);
		sb.append("\nCategoria: ");
		sb.append(this.categoria);

		return sb.toString();
	}

}
