package controllers;

import java.io.IOException;

import java.security.NoSuchAlgorithmException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.DTO.CreateUserDTO;
import processor.SignUpProcessor;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class SignUpViewController {
	private SignUpProcessor signUpProcessor;
	
	public SignUpViewController() {
		signUpProcessor = new SignUpProcessor();
	}
	
	@FXML
	private TextField txtId;
	@FXML
	private TextField txtEmri;
	
	@FXML
	private TextField txtMbiemri;
	
	@FXML
	private TextField txtEmail;
	
	@FXML
	private PasswordField pwdPassword;
	
	@FXML
	private PasswordField pwdConfirmPassword;
	
	@FXML
	private void SignUpEventHandler(ActionEvent ae) throws IOException, NoSuchAlgorithmException {
		String id = txtId.getText();
		String emri = txtEmri.getText();
		String mbiemri = txtMbiemri.getText();
		String email = txtEmail.getText();
		String password = pwdPassword.getText();
		String confirmPassword = pwdConfirmPassword.getText();
		
		//valido
		if(!password.equals(confirmPassword)) {
			Alert alert = new Alert(AlertType.INFORMATION,"Password-i duhet te jete i njejte ne te dy fushat!");
			alert.show();
			return;
		}
		
		CreateUserDTO dtoObject = new CreateUserDTO(
				id,emri, mbiemri,email, password, confirmPassword);
		
		if(this.signUpProcessor.createNewUser(dtoObject)) {
			
			Alert alert = new Alert(AlertType.INFORMATION,"U regjistruat me sukses!");
			alert.show();
			this.loadLoginPage((Node) ae.getSource());
			
		}else {
			
			
			this.loadLoginPage((Node) ae.getSource());
			
		}
		
	}
	
	@FXML
	private void cancelEventHandler(ActionEvent e) throws IOException {
		this.loadLoginPage((Node) e.getSource());
	}

	
	private void loadLoginPage(Node source) throws IOException {
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("/views/LoginView.fxml")
				);
		Parent pane = loader.load();
		Scene scene = new Scene(pane, 640, 400);
		Stage primaryStage = (Stage) source.getScene().getWindow();
		primaryStage.setScene(scene);
	}
}


//public class SignUpViewController {
//	private SignUpProcessor signUpProcessor;
//	
//	public SignUpViewController() {
//		signUpProcessor = new SignUpProcessor();
//	}
//	
//	@FXML
//	private TextField txtEmri;
//	
//	@FXML
//	private TextField txtMbiemri;
//	
//	@FXML
//	private TextField txtEmail;
//	
//	@FXML
//	private PasswordField pwdPassword;
//	
//	@FXML
//	private PasswordField pwdConfirmPassword;
//	
//	@FXML
//	private void SignUpEventHandler(ActionEvent ae) throws IOException, NoSuchAlgorithmException {
//		String emri = txtEmri.getText();
//		String mbiemri = txtMbiemri.getText();
//		String email = txtEmail.getText();
//		String password = pwdPassword.getText();
//		String confirmPassword = pwdConfirmPassword.getText();
//		
//		//valido
//		if(!password.equals(confirmPassword)) {
//			Alert alert = new Alert(AlertType.INFORMATION,"Password-i duhet te jete i njejte ne te dy fushat!");
//			alert.show();
//			return;
//		}
//		
//		CreateUserDTO dtoObject = new CreateUserDTO(
//				emri, mbiemri,email, password, confirmPassword);
//		
//		if(this.signUpProcessor.createNewUser(dtoObject)) {
//			
//			Alert alert = new Alert(AlertType.INFORMATION,"U regjistruat me sukses!");
//			alert.show();
//			this.loadLoginPage((Node) ae.getSource());
//			
//		}else {
//			
//			Alert alert = new Alert(AlertType.INFORMATION,"U regjistruat me sukses!");
//			alert.show();
//			this.loadLoginPage((Node) ae.getSource());
//			
//		}
//		
//	}
//	
//	@FXML
//	private void cancelEventHandler(ActionEvent e) throws IOException {
//		this.loadLoginPage((Node) e.getSource());
//	}
//
//	
//	private void loadLoginPage(Node source) throws IOException {
//		FXMLLoader loader = new FXMLLoader(
//				getClass().getResource("/views/LoginView.fxml")
//				);
//		Parent pane = loader.load();
//		Scene scene = new Scene(pane, 640, 400);
//		Stage primaryStage = (Stage) source.getScene().getWindow();
//		primaryStage.setScene(scene);
//	}
//}