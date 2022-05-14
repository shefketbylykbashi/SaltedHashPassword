
package DTO;

public class CreateUserDTO {
	private String id;
	private String emri;
	private String mbiemri;
	private String email;
	private String password;
	private String confirmPassword; //
	
	
	private String salted;
	private String saltedHash;
	// Shtoni fushat e tjera te cilat nevojiten ne bazen 
	// e te dhenave
	
	public CreateUserDTO(
			String id,
			String emri, 
			String mbiemri,
			String email,
			String password, 
			String confirmPassword 
			) {
		this.id =id;
		this.emri = emri;
		this.mbiemri = mbiemri;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.email = email;
	}
	
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id= id;
	}
	
	public String getEmri() {
		return emri;
	}

	public void setEmri(String emri) {
		this.emri = emri;
	}
	public String getMbiemri() {
		return mbiemri;
	}
	public void setMbiemri(String mbiemri) {
		this.mbiemri = mbiemri;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getSalted() {
		return salted;
	}

	public void setSalted(String salted) {
		this.salted = salted;
	}

	public String getSaltedHash() {
		return saltedHash;
	}

	public void setSaltedHash(String saltedHash) {
		this.saltedHash = saltedHash;
	}
	
	
}
