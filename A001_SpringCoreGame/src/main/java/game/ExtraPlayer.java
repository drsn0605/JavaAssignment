package game;

import org.springframework.stereotype.Component;

@Component("extra")
public class ExtraPlayer implements Player{

	@Override
	public void detail() {
		System.out.println("Extra player.");
		
	}

}
