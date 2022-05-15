package processor;

import java.security.NoSuchAlgorithmException;

import model.DTO.CreateUserDTO;
import repository.SignUpRepository;

public class SignUpProcessor {
	private SignUpRepository signUpRepository;
	
	
	
	public SignUpProcessor() {
		super();
		this.signUpRepository = new SignUpRepository();
	}



	public boolean createNewUser(CreateUserDTO userDto) throws NoSuchAlgorithmException {
		String salted = GenerateHash.generateSalted();
		String saltedHash = GenerateHash.generate(
				userDto.getPassword(), salted);
		userDto.setSalted(salted);
		userDto.setSaltedHash(saltedHash);
		
		return this.signUpRepository.create(userDto);
	}
}
