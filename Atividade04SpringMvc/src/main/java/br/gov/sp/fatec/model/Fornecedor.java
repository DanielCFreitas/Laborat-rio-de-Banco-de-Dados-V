package br.gov.sp.fatec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe que representa um fornecedor de produtos na aplicacao
 * 
 * @author Daniel
 *
 */

@Entity
@Table(name = "FORN_FORNECEDOR")
public class Fornecedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FORN_ID", nullable = false)
	private Long id;

	@Column(name = "FORN_NOME", length = 50, nullable = false)
	private String nome;

	@Column(name = "FORN_CNPJ", length = 18, nullable = false, unique = true)
	private String cnpj;

	@Column(name = "FORN_ENDERECO", length = 100, nullable = false)
	private String endereco;

	@Column(name = "FORN_TELEFONE", length = 14, nullable = false)
	private String telefone;

	public Fornecedor() {

	}

	/**
	 * Método que retorna o id de um Fornecedor
	 * 
	 * @return Retorna o Id do Fornecedor
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Método que seta o id de um Fornecedor
	 * 
	 * @param id
	 *            Id do Fornecedor
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Método que retorna o nome de um Fornecedor
	 * 
	 * @return Retorna o nome de um Fornecedor
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método que seta o nome de um Fornecedor
	 * 
	 * @param nome
	 *            Nome do Fornecedor
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Método que retorna o cnpj de um Fornecedor
	 * 
	 * @return Retorna o Cnpj do Fornecedor
	 */
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * Método que seta o Cnpj de um Fornecedor
	 * 
	 * @param cnpj
	 *            Cnpj do Fornecedor
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * Método que retorna o Endereco de um Fornecedor
	 * 
	 * @return Retorna o Endereco do Fornecedor
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * Método que seta o Endereco de um Fornecedor
	 * 
	 * @param endereco
	 *            Endereco do Fornecedor
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * Método que retorna o Telefone de um Fornecedor
	 * 
	 * @return Retorna o Telefone de um Fornecedor
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * Método que seta o Telefone de um Fornecedor
	 * 
	 * @param telefone
	 *            Telefone de um Fornecedor
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * Método para retornar uma String com as informações de um fornecedor
	 * 
	 * @return Retorna informações de um Objeto Fornecedor
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("\n=== FORNECEDOR ===\n");
		sb.append("\nNome: ");
		sb.append(this.nome);
		sb.append("\nCNPJ: ");
		sb.append(this.cnpj);
		sb.append("\nEndereco: ");
		sb.append(this.endereco);
		sb.append("\nTelefone: ");
		sb.append(this.telefone);

		return sb.toString();
	}

}
