package repository;

import java.sql.ResultSet;

import database.DBConnect;
import database.FilterQueryBuilder;
import database.InsertQueryBuilder;
import model.Login;
import model.User;
import model.DTO.CreateUserDTO;

public class LoginRepository {
	private final String TABLE_NAME = "user1";
	private DBConnect connection;
	
	public LoginRepository() {
		this.connection = DBConnect.getInstance();
	}
	
	public Login findOne(String email) {
		try {
			FilterQueryBuilder query = (FilterQueryBuilder)
					FilterQueryBuilder.create(this.TABLE_NAME)
					.addWhere("email", email, "s");


			ResultSet res = this.connection.executeQuery(query.getQuery(), query.getTypes(), query.getValues());
		
			if(res.next()) {
				return Login.createFromValues(
						res.getInt("id"),
						res.getString("emri"),
						res.getString("mbiemri"),
						res.getString("email"),
						res.getString("salted_hash"),
						res.getString("salted")
						);
			}
			return null;
		}catch(Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

}






//import java.sql.ResultSet;
//
//import database.DBConnect;
//import database.FilterQueryBuilder;
//import database.InsertQueryBuilder;
//import model.Login;
//import model.User;
//import model.DTO.CreateUserDTO;
//
//public class LoginRepository {
//	private final String TABLE_NAME = "user";
//	private DBConnect connection;
//	
//	public LoginRepository() {
//		this.connection = DBConnect.getInstance();
//	}
//	
//	public Login findOne(String username) {
//		try {
//			FilterQueryBuilder query = (FilterQueryBuilder)
//					FilterQueryBuilder.create(this.TABLE_NAME)
//					.addWhere("username", username, "s");
//
//
//			ResultSet res = this.connection.executeQuery(query.getQuery(), query.getTypes(), query.getValues());
//		
//			if(res.next()) {
//				return Login.createFromValues(
//						res.getInt("id"),
//						res.getString("username"),
//						res.getString("salted_hash"),
//						res.getString("salted")
//						);
//			}
//			return null;
//		}catch(Exception e) {
//			System.err.println(e.getMessage());
//			return null;
//		}
//	}
//
//}