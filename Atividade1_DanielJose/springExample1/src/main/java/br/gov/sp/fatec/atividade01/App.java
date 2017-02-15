package br.gov.sp.fatec.atividade01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		ContaCorrente contaCorrente = (ContaCorrente) context.getBean("contacorrente");

		System.out.println(contaCorrente.imprimeCliente());

		context.close();
	}
}
