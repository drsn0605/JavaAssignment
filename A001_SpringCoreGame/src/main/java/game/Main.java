package game;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		ApplicationContext cx = new AnnotationConfigApplicationContext("AppConfig.class");
		
		Sports cricket = cx.getBean("cricket",Sports.class);
		Sports hockey = cx.getBean("hockey",Sports.class);
		
		cricket.play();
		hockey.play();
	}
}
