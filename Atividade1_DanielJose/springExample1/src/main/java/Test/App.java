package Test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Mensagem mensagem1 = (Mensagem) context.getBean("msg");

		System.out.println(mensagem1);

		mensagem1.setMensagem("Daniel2");

		Mensagem mensagem2 = (Mensagem) context.getBean("msg");

		System.out.println(mensagem2);

		context.close();

	}
}
