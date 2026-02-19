package bank;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("bank")   //ComponentScan - bank package ke sare class ke object bana dega, automatically. (We dont have to create object manually)
public class appConfig {
	
}
