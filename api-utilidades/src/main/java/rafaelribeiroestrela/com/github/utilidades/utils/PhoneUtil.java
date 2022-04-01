package rafaelribeiroestrela.com.github.utilidades.utils;

public class PhoneUtil {
	
	public static String removeMask(String phone) {
		phone = phone.replace("(", "");
		phone = phone.replace(")", "");
		phone = phone.replace("-", "");
		phone = phone.replaceAll("\\s+", "");
		return phone;
	}
	
	public static String putMask(String phone) {
		StringBuilder st = new StringBuilder(phone);
		st.insert(0, "(");
		st.insert(3, ")");
		st.insert(phone.length() - 2, "-");
		return st.toString();
	}

}
