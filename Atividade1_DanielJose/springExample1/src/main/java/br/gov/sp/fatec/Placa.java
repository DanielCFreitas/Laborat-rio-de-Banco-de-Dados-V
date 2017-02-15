package br.gov.sp.fatec;

public class Placa {

	private Mensagem mensagem;

	public Placa() {

	}

	public String ler() {
		return "[<" + mensagem.getMensagem() + ">]";
	}

	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}
}
