package game;

import org.springframework.stereotype.Component;

@Component("hockey")
public class Hockey implements Sports{

	@Override
	public void play() {
		System.out.println("Playing Hockey..");
		
	}
	
}
