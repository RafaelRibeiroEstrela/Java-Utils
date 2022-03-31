package rafaelribeiroestrela.com.github.utilidades;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import rafaelribeiroestrela.com.github.utilidades.model.Email;
import rafaelribeiroestrela.com.github.utilidades.utils.DateUtil;
import rafaelribeiroestrela.com.github.utilidades.utils.EmailUtil;

@SpringBootApplication
public class ApiUtilidadesApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ApiUtilidadesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(DateUtil.convertDateToString(LocalDate.now(), "dd/MM/yyyy"));
		System.out.println(DateUtil.convertStringToDate("10/10/1990", "dd/MM/yyyy"));
		System.out.println(DateUtil.getDateInFullName(LocalDate.now()));
		
		Email email = new Email();
		email.getTo().add("rafaelestrela@seplag.mt.gov.br");
		email.setFrom("brizadeemail@gmail.com");
		email.setPassword("quake3arena");
		email.setText("Testando");
		//EmailUtil.sendEmail(email);
		
	}

}
