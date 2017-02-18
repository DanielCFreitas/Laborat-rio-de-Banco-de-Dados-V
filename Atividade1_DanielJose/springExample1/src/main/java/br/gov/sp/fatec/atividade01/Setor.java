package br.gov.sp.fatec.atividade01;

import java.util.List;

public class Setor {

	private String nome;
	private List<Funcionario> funcionarios;

	public Setor() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	/**
	 * Imprimir informações sobre o setor
	 * 
	 * @return
	 */
	public String lerSetor() {
		StringBuilder sb = new StringBuilder();

		sb.append("\n=== INFORMAÇÕES DO SETOR ===\n");
		sb.append("Nome do setor: ");
		sb.append(nome);

		for (Funcionario funcionarioIndividual : funcionarios) {
			sb.append("\n\nNome do funcionario: ");
			sb.append(funcionarioIndividual.getNome());
			sb.append("\nCpf: ");
			sb.append(funcionarioIndividual.getCpf());
			sb.append("\nRG: ");
			sb.append(funcionarioIndividual.getRg());
			sb.append("\nIdade: ");
			sb.append(funcionarioIndividual.getIdade());
		}

		return sb.toString();
	}

}
