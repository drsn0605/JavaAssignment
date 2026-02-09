package company;

import org.springframework.stereotype.Component;

@Component
public class ContractEmp implements Employee{

	@Override
	public void empDetails() {
		System.out.println("Contract Employee..");
		
	}

}
