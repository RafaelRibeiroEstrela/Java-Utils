package rafaelribeiroestrela.com.github.utilidades.utils;

import org.springframework.web.client.RestTemplate;

public class RestTemplateUtil {
	
	RestTemplate rest = new RestTemplate();
	Object obj = rest.getForObject("endereco", Object.class);
	

}
