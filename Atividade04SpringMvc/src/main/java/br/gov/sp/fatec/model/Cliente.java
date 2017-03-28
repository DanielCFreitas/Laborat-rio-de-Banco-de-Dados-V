package br.gov.sp.fatec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.view.View;

/**
 * Classe que representa um cliente na aplicacao
 * 
 * @author Aluno
 *
 */
@Entity
@Table(name = "CLI_CLIENTE")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CLI_ID", nullable = false)
	@JsonView(View.Main.class)
	private Long id;

	@Column(name = "CLI_NOME", nullable = false, length = 50)
	@JsonView(View.Main.class)
	private String nome;

	@Column(name = "CLI_SOBRENOME", nullable = false, length = 50)
	@JsonView(View.Main.class)
	private String sobrenome;

	@Column(name = "CLI_TELEFONE", nullable = false, length = 14)
	@JsonView(View.Main.class)
	private String telefone;

	public Cliente() {

	}

	/**
	 * Método que retorna o id de um Cliente
	 * 
	 * @return Retorna o Id do Cliente
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Método que seta o id de um Cliente
	 * 
	 * @param id
	 *            Id do Cliente
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Método que retorna o nome de um Cliente
	 * 
	 * @return Retorna o Nome do Cliente
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método que seta o nome de um Cliente
	 * 
	 * @param id
	 *            Nome do Cliente
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Método que retorna o sobrenome de um Cliente
	 * 
	 * @return Retorna o Sobrenome do Cliente
	 */
	public String getSobrenome() {
		return sobrenome;
	}

	/**
	 * Método que seta o sobrenome de um Cliente
	 * 
	 * @param id
	 *            Sobrenome do Cliente
	 */
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	/**
	 * Método que retorna o telefone de um Cliente
	 * 
	 * @return Retorna o Telefone do Cliente
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * Método que seta o telefone de um Cliente
	 * 
	 * @param id
	 *            Telefone do Cliente
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * Método para retornar uma String com as informações de um cliente
	 * 
	 * @return Retorna informações de um Objeto cliente
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("\n==== CLIENTE ====\n");
		sb.append("\nNome: ");
		sb.append(this.nome);
		sb.append("\nSobrenome: ");
		sb.append(this.sobrenome);
		sb.append("\nTelefone: ");
		sb.append(this.telefone);

		return sb.toString();
	}
}
