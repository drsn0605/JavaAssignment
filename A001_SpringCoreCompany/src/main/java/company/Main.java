package company;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		ApplicationContext cx = new AnnotationConfigApplicationContext(AppConfig.class);  //it is a container - which load class file.
		
//		Employee reg = cx.getBean("regular",Employee.class);
//		reg.empDetails();
		
		Employee cont = cx.getBean("contractEmp",Employee.class);
		cont.empDetails();
	}
}
