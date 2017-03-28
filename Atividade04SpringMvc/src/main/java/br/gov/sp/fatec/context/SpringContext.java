package br.gov.sp.fatec.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContext {

	private static ApplicationContext applicationContext = null;

	public static ApplicationContext getApplicationContext() {
		if (applicationContext == null) {
			applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		}
		return applicationContext;
	}
}
