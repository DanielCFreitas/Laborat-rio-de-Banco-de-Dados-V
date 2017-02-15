package br.gov.sp.fatec.atividade01;

public class ContaCorrente {

	private Cliente cliente;

	public ContaCorrente() {

	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * Imprime os dados do cliente
	 * 
	 * @return retorna uma string contendo os dados do cliente
	 */
	public String imprimeCliente() {
		StringBuilder sb = new StringBuilder();

		sb.append("Nome: ");
		sb.append(cliente.getNome());
		sb.append("\nCPF: ");
		sb.append(cliente.getCpf());
		sb.append("\nRG: ");
		sb.append(cliente.getRg());
		sb.append("\nIdade: ");
		sb.append(cliente.getIdade());

		return sb.toString();
	}
}
