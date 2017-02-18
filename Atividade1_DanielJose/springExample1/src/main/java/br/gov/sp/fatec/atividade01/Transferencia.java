package br.gov.sp.fatec.atividade01;

public class Transferencia {

	private Cliente clienteOrigem;
	private Cliente clienteDestino;
	private Double valorTransferido;

	public Cliente getClienteOrigem() {
		return clienteOrigem;
	}

	public void setClienteOrigem(Cliente clienteOrigem) {
		this.clienteOrigem = clienteOrigem;
	}

	public Cliente getClienteDestino() {
		return clienteDestino;
	}

	public void setClienteDestino(Cliente clienteDestino) {
		this.clienteDestino = clienteDestino;
	}

	public Double getValorTransferido() {
		return valorTransferido;
	}

	public void setValorTransferido(Double valorTransferido) {
		this.valorTransferido = valorTransferido;
	}

	/**
	 * Imprimir informações sobre transferencia
	 * 
	 * @return
	 */
	public String imprimeTransferencia() {
		StringBuilder sb = new StringBuilder();

		sb.append("\n\n=== TRANSFERENCIA ===");
		sb.append("\nTransferido DE: ");
		sb.append(clienteOrigem.getNome());
		sb.append("\nTransferido PARA: ");
		sb.append(clienteDestino.getNome());
		sb.append("\nValor: R$");
		sb.append(valorTransferido);

		return sb.toString();
	}

}
