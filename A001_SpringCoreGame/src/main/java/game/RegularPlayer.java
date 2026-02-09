package game;

import org.springframework.stereotype.Component;

@Component("regular")
public class RegularPlayer implements Player{

	@Override
	public void detail() {
		System.out.println("Regular player.");
		
	}

}
