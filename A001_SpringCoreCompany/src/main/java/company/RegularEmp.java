package company;

import org.springframework.stereotype.Component;

@Component("regular")
public class RegularEmp implements Employee{

	@Override
	public void empDetails() {
		System.out.println("Regular Employee..");
		
	}

}
