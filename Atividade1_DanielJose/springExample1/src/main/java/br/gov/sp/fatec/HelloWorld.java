package br.gov.sp.fatec;

public class HelloWorld implements Mensagem {

	private String nome;

	public HelloWorld() {

	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMensagem() {
		return "Hello World! Hello " + nome + "!";
	}

}
