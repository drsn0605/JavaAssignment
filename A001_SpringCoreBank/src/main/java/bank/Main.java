package bank;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		
//		SavingAccount saving = new SavingAccount();
//		CurrentAccount current = new CurrentAccount();
		
		//upcasting (we can write Account at the place of SavingAccount and CurrentAccount - this is called upcasting)
//		Account saving = new SavingAccount();
//		Account current = new CurrentAccount();
		
		//now we want to remove class dependencies(SavingAccount and CurrentAccount). So, for that....
		//now we create object from spring. Spring will create object for us. We dont need to create object manually. 
		//So, we gonna create one class, named - appConfig
		
		ApplicationContext cx = new AnnotationConfigApplicationContext(appConfig.class);  //appConfig load hoga. 
		
		Account saving = cx.getBean("savingAccount", Account.class);
		Account current = cx.getBean("currentAccount", Account.class);
		
		
		//Error - 
		//Exception in thread "main" org.springframework.beans.factory.NoSuchBeanDefinitionException: 
		//No bean named 'savingAccount' available
		
		//solution - add annotation @Component in SavingAccount and CurrentAccount. 
		
		//by this way we can remove class dependencies. 
		
		saving.deposite();
		current.deposite();
		
		//if we want to give object name- in SavingAccount (@Component("saving")) but we have to change, 
		//Account saving = cx.getBean("savingAccount", Account.class); - [savingAccount to saving]
	}
}
