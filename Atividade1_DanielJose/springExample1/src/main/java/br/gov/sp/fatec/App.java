package br.gov.sp.fatec;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Placa obj = (Placa) context.getBean("placa");

		System.out.println(obj.ler());

		context.close();
	}
}
