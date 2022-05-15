package controllers;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import processor.LoginProcessor;

public class LoginViewController {
	private LoginProcessor loginProcessor;
	
	public LoginViewController() {
		loginProcessor = new LoginProcessor();
	}
	
	@FXML
	private TextField txtEmri;
	
	@FXML
	private TextField txtMbiemri;
	
	@FXML
	private TextField txtEmail;
	
	@FXML
	private PasswordField pwfPassword;

	
	@FXML
	private void loginEventHandler(ActionEvent ae) throws IOException, NoSuchAlgorithmException {
		String email = this.txtEmail.getText();
		String password = this.pwfPassword.getText();
		if(this.loginProcessor.isUserValid(email, password)) {
			this.loadHomePage((Node) ae.getSource());
			Alert alert = new Alert(AlertType.INFORMATION,"U loguat me sukses!");
			alert.show();
		}else {
			Alert alert = new Alert(AlertType.INFORMATION,"Nuk keni llogari valide!");
			alert.show();
		}
		

	}
	
	@FXML
	private void cancelEventHandler(ActionEvent e) {
		System.out.println("Cancel Event!");
	}
	
	@FXML
	private void resetPasswordEventHandler(ActionEvent e) {
		System.out.println("Reset password event!");
	}
	
	@FXML
	private void nextEventHandler(ActionEvent e) throws IOException, NoSuchAlgorithmException {
		this.loadSignUpPage((Node) e.getSource());
	}
	
	private void loadHomePage(Node source) throws IOException {
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("/views/HomeView.fxml")
				);
		Parent pane = loader.load();
		Scene scene = new Scene(pane, 640, 400);
		Stage primaryStage = (Stage) source.getScene().getWindow();
		primaryStage.setScene(scene);
	}
	
	private void loadSignUpPage(Node source) throws IOException {
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("/views/SignUpView.fxml")
				);
		Parent pane = loader.load();
		Scene scene = new Scene(pane, 640, 400);
		Stage primaryStage = (Stage) source.getScene().getWindow();
		primaryStage.setScene(scene);
	}
}


//public class LoginViewController {
//	private LoginProcessor loginProcessor;
//	
//	public LoginViewController() {
//		loginProcessor = new LoginProcessor();
//	}
//	
//	@FXML
//	private TextField txtUsername;
//	
//	@FXML
//	private PasswordField pwfPassword;
//
//	
//	@FXML
//	private void loginEventHandler(ActionEvent ae) throws IOException, NoSuchAlgorithmException {
//		String username = this.txtUsername.getText();
//		String password = this.pwfPassword.getText();
//		if(this.loginProcessor.isUserValid(username, password)) {
//			this.loadHomePage((Node) ae.getSource());
//		}
//		// alert user
//
//	}
//	
//	@FXML
//	private void cancelEventHandler(ActionEvent e) {
//		System.out.println("Cancel Event!");
//	}
//	
//	@FXML
//	private void resetPasswordEventHandler(ActionEvent e) {
//		System.out.println("Reset password event!");
//	}
//	
//	@FXML
//	private void nextEventHandler(ActionEvent e) throws IOException, NoSuchAlgorithmException {
//		this.loadSignUpPage((Node) e.getSource());
//	}
//	
//	private void loadHomePage(Node source) throws IOException {
//		FXMLLoader loader = new FXMLLoader(
//				getClass().getResource("/views/HomeView.fxml")
//				);
//		Parent pane = loader.load();
//		Scene scene = new Scene(pane, 640, 400);
//		Stage primaryStage = (Stage) source.getScene().getWindow();
//		primaryStage.setScene(scene);
//	}
//	
//	private void loadSignUpPage(Node source) throws IOException {
//		FXMLLoader loader = new FXMLLoader(
//				getClass().getResource("/views/SignUpView.fxml")
//				);
//		Parent pane = loader.load();
//		Scene scene = new Scene(pane, 640, 400);
//		Stage primaryStage = (Stage) source.getScene().getWindow();
//		primaryStage.setScene(scene);
//	}
//}