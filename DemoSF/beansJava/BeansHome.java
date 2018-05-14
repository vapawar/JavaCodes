package beansJava;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansHome 
{

	@Bean
	public MessageMaker getMessageMaker()
	{
		return new MessageMaker();
	}
}
