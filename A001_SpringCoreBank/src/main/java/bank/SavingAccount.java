package bank;

import org.springframework.stereotype.Component;

@Component
public class SavingAccount implements Account{

	@Override
	public void deposite() {
		System.out.println("saving calling..");
		
	}

}
