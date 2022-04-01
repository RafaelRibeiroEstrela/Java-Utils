package rafaelribeiroestrela.com.github.utilidades.utils;

import java.util.InputMismatchException;

public class DocumentUtil {

	public static String removeMaskCpf(String cpf) {
		cpf = cpf.replace(".", "");
		cpf = cpf.replace("-", "");
		return cpf;
	}

	public static String putMaskCpf(String cpf) {
		StringBuilder st = new StringBuilder(cpf);
		st.insert(3, ".");
		st.insert(7, ".");
		st.insert(11, "-");
		return st.toString();
	}
	
	public static String removeMaskRg(String rg) {
		rg = rg.replace("-", "");
		return rg;
	}
	
	public static String putMaskRg(String rg) {
		StringBuilder st = new StringBuilder(rg);
		st.insert(rg.length() - 2, "-");
		return st.toString();
	}
	
	public static String removeMaskCnpj(String cnpj) {
		cnpj = cnpj.replace(".", "");
		cnpj = cnpj.replace("-", "");
		return cnpj;
	}
	
	public static String putMaskCnpj(String cnpj) {
		StringBuilder st = new StringBuilder(cnpj);
		st.insert(2, ".");
		st.insert(6, ".");
		st.insert(10, "/");
		st.insert(15, "-");
		return st.toString();
	}

	public static boolean validationCpf(String CPF) {
		if (CPF.contains(".") || CPF.contains("-")) {
			CPF = removeMaskCpf(CPF);
		}
		if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222")
				|| CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555")
				|| CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888")
				|| CPF.equals("99999999999") || (CPF.length() != 11))
			return (false);

		char dig10, dig11;
		int sm, i, r, num, peso;

		// "try" - protege o codigo para eventuais erros de conversao de tipo (int)
		try {
			// Calculo do 1o. Digito Verificador
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				// converte o i-esimo caractere do CPF em um numero:
				// por exemplo, transforma o caractere '0' no inteiro 0
				// (48 eh a posicao de '0' na tabela ASCII)
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48); // converte no respectivo caractere numerico

			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			// Verifica se os digitos calculados conferem com os digitos informados.
			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}
	}

}
