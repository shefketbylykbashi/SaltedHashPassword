package repository;



import java.sql.ResultSet;

import database.DBConnect;
import database.FilterQueryBuilder;
import database.InsertQueryBuilder;

import model.User;
import model.DTO.CreateUserDTO;

public class SignUpRepository {
	
	private final String TABLE_NAME = "user1";
	private DBConnect connection;
	
	public SignUpRepository() {
		this.connection = DBConnect.getInstance();
	}
	
	public boolean create(CreateUserDTO userDto) {
		try {
			InsertQueryBuilder query = (InsertQueryBuilder)
					InsertQueryBuilder.create(TABLE_NAME)
					.add("id", userDto.getId(), "s")
					.add("emri", userDto.getEmri(), "s")
					.add("mbiemri", userDto.getMbiemri(), "s")
					.add("email", userDto.getEmail(), "s")
					.add("salted_hash", userDto.getSaltedHash(), "s")
					.add("salted", userDto.getSalted(), "s");
			int lastInsertedId = 
					this.connection.execute(
							query.getQuery(), query.getTypes(), query.getValues()
							);
			if (lastInsertedId > 0) {
				return true;
			}
			return false;
		}catch(Exception e) {
			return false;
		}
	}

}


//public class SignUpRepository {
//	
//	private final String TABLE_NAME = "user1";
//	private DBConnect connection;
//	
//	public SignUpRepository() {
//		this.connection = DBConnect.getInstance();
//	}
//	
//	public boolean create(CreateUserDTO userDto) {
//		try {
//			InsertQueryBuilder query = (InsertQueryBuilder)
//					InsertQueryBuilder.create(TABLE_NAME)
//					.add("emri", userDto.getEmri(), "s")
//					.add("mbiemri", userDto.getMbiemri(), "s")
//					.add("email", userDto.getEmail(), "s")
//					.add("salted_hash", userDto.getSaltedHash(), "s")
//					.add("salted", userDto.getSalted(), "s");
//			int lastInsertedId = 
//					this.connection.execute(
//							query.getQuery(), query.getTypes(), query.getValues()
//							);
//			if (lastInsertedId > 0) {
//				return true;
//			}
//			return false;
//		}catch(Exception e) {
//			return false;
//		}
//	}
//
//}