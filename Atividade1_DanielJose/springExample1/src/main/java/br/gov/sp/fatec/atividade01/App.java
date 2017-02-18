package br.gov.sp.fatec.atividade01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		ContaCorrente contaCorrente = (ContaCorrente) context.getBean("contacorrente");
		Setor setor = (Setor) context.getBean("setor");
		Transferencia transferencia = (Transferencia) context.getBean("transferencia");

		System.out.println(contaCorrente.imprimeCliente());
		System.out.println(setor.lerSetor());
		System.out.println(transferencia.imprimeTransferencia());

		context.close();
	}
}
