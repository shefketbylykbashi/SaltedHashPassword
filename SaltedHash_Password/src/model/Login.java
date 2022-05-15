package model;

public class Login {
	private int id;
	private String emri;
	private String mbiemri;
	private String email;
	private String saltedHash;
	private String salted;
	
	public static Login createFromValues(int id,String emri, 
			String mbiemri, String email, String saltedHash, String salted) {
		return new Login(id, emri, mbiemri, email, saltedHash, salted);
	}
	
	private Login(int id,String emri, 
			String mbiemri, String email, String saltedHash, String salted) {
		this.id = id;
		this.emri = emri;
		this.mbiemri = mbiemri;
		this.email = email;
		this.saltedHash = saltedHash;
		this.salted = salted;
	}

	public int getId() {
		return id;
	}
	
	public String getEmri() {
		return emri;
	}
	public String getMbiemri() {
		return mbiemri;
	}
	
	public String getEmail() {
		return this.email;
	}

	public String getSaltedHash() {
		return saltedHash;
	}

	public String getSalted() {
		return salted;
	}
}


//public class Login {
//	private int id;
//	private String username;
//	private String saltedHash;
//	private String salted;
//	
//	public static Login createFromValues(int id, String username, String saltedHash, String salted) {
//		return new Login(id, username, saltedHash, salted);
//	}
//	
//	private Login(int id, String username, String saltedHash, String salted) {
//		this.id = id;
//		this.username = username;
//		this.saltedHash = saltedHash;
//		this.salted = salted;
//	}
//
//	public int getId() {
//		return id;
//	}
//	
//	public String getUsername() {
//		return this.username;
//	}
//
//	public String getSaltedHash() {
//		return saltedHash;
//	}
//
//	public String getSalted() {
//		return salted;
//	}
//}