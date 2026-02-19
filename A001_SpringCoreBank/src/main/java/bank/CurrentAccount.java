package bank;

import org.springframework.stereotype.Component;

@Component
public class CurrentAccount implements Account{

	@Override
	public void deposite() {
		System.out.println("current calling..");
		
	}

}
