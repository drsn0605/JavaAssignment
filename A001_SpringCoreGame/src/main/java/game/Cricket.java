package game;


import org.springframework.stereotype.Component;

@Component("cricket")
public class Cricket implements Sports{
	
//	@Autowired
//	@Qualifier("regular")
//	Player player;
	
	public void play() {
		System.out.println("Playing Cricket..");
//		player.detail();
	}
}
