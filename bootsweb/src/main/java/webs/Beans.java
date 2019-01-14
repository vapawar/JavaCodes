package webs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

	@Qualifier("test")
	@Bean
	public ParamsBean getParamsBean() {
		ParamsBean t = new ParamsBean();
		t.setId(1234);
		t.setName("testdata");
		return t;
	}
}
