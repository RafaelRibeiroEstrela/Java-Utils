package rafaelribeiroestrela.com.github.utilidades.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class Email implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "TO is required.")
	private Set<String> to = new HashSet<>();
	
	@NotBlank(message = "FROM is required.")
	private String from;
	
	@NotBlank(message = "PASSWORD is required.")
	private String password;
	
	private Set<String> cc = new HashSet<>();
	private String subject;
	private String text;
	private String html;
	private Set<String> attachments = new HashSet<>();

	public Set<String> getTo() {
		return to;
	}

	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<String> getCc() {
		return cc;
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	public Set<String> getAttachments() {
		return attachments;
	}

}
