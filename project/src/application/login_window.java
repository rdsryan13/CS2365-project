package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class login_window extends Application {

	// primaries
	boolean signupBuf = false; // ensure signup criteria met
	// window variables
	public Stage window;
	Scene logIn, signUp, reset, success;
	// Log In variables
	Label lg_header, lg_user, lg_pass, lg_warning;
	TextField lg_userEntree, lg_passEntree;
	Button lg_signin, lg_signup;
	TextFlow lg_forgotPass;
	GridPane wall;
	// Sign Up Variables
	Label su_header, su_user, su_pass, su_qpass, su_email, su_warning;
	TextField su_userEntree, su_passEntree, su_qpassEntree, su_emailEntree;
	Button su_signup, su_login;
	GridPane wall1;
	// Reset Variables
	// Success Variables
	Label cc_successMessage;
	Button cc_back;
	VBox lane;
	// others
	LogOn log;
	market_window market;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		window = primaryStage;
		window.setTitle("Login/Signup");
		market = new market_window();

		// Login Initial
		// work-area-------------------------------------------------------------------------------

		// labels
		// passive
		lg_header = new Label("Login - Customer Login");
		lg_header.setFont(Font.font("Veradana", FontWeight.BOLD, 18));
		lg_user = new Label("Email:");
		lg_pass = new Label("Password:");
		// active
		lg_warning = new Label("*");
		lg_warning.setVisible(false);
		// textfields
		lg_userEntree = new TextField();
		lg_userEntree.setPromptText("email");
		lg_passEntree = new TextField();
		lg_passEntree.setPromptText("password");
		// buttons/links
		lg_signin = new Button("Log in");
		// implement of login
		lg_signin.setOnAction(e -> {
			try {
				log = new LogOn();
				if (!log.verify(lg_userEntree.getText(), lg_passEntree.getText())) {
					throw new IncorrectPasswordException("Password or username is incorrect");
				}
				System.out.println("Successfully logged in");
				market.start(primaryStage);
			} catch (final IncorrectPasswordException e1) {
				System.out.println(e1.toString());
				System.out.println("Log in Unsuccessful");
			} catch (final Exception e2) {
				System.out.println("error in swapping scenes");
			}
		});
		lg_signup = new Button("Signup");
		// implement of signup
		lg_signup.setOnAction(e -> window.setScene(signUp));
		// end signup
		lg_forgotPass = new TextFlow(new Hyperlink("Forgot username/password"));
		// layout
		wall = new GridPane();
		wall.setPadding(new Insets(10, 10, 10, 10));
		wall.setVgap(10);
		wall.setHgap(10);
		GridPane.setConstraints(lg_header, 0, 0, 2, 1);
		GridPane.setConstraints(lg_user, 0, 1);
		GridPane.setConstraints(lg_userEntree, 1, 1);
		GridPane.setConstraints(lg_pass, 0, 2);
		GridPane.setConstraints(lg_passEntree, 1, 2);
		GridPane.setConstraints(lg_warning, 0, 3);
		GridPane.setConstraints(lg_signin, 2, 4);
		GridPane.setConstraints(lg_forgotPass, 0, 4);
		GridPane.setConstraints(lg_signup, 2, 5);
		wall.getChildren().addAll(lg_header, lg_user, lg_userEntree, lg_pass, lg_passEntree, lg_warning, lg_signin,
				lg_forgotPass, lg_signup);
		logIn = new Scene(wall, 400, 220);

		// end
		// Login------------------------------------------------------------------------------------------------

		// Signup Initial
		// work-area---------------------------------------------------------------------------------

		// labels
		// passive
		su_header = new Label("Signup - Customer Signup");
		su_header.setFont(Font.font("Veradana", FontWeight.BOLD, 18));
		su_user = new Label("Username:");
		su_pass = new Label("Password:");
		su_qpass = new Label("Reenter Password:");
		su_email = new Label("Email:");
		// active
		su_warning = new Label("*");
		su_warning.setVisible(false);
		// textfields
		su_userEntree = new TextField();
		su_userEntree.setPromptText("username");
		su_passEntree = new TextField();
		su_passEntree.setPromptText("password");
		su_qpassEntree = new TextField();
		su_qpassEntree.setPromptText("password");
		// listenning for second password entree

		su_emailEntree = new TextField();
		su_emailEntree.setPromptText("email");
		// buttons/links
		su_signup = new Button("Sign up");
		// implement of signup
		su_signup.setOnAction(e -> {
			if (signupBuf) {
				window.setScene(success);
			}
		});
		// end signup
		su_login = new Button("Log in");
		// implement of login
		su_login.setOnAction(e -> window.setScene(logIn));
		// end login
		// layout
		wall1 = new GridPane();
		wall1.setPadding(new Insets(10, 10, 10, 10));
		wall1.setVgap(10);
		wall1.setHgap(10);
		GridPane.setConstraints(su_header, 0, 0, 2, 1);
		GridPane.setConstraints(su_user, 0, 1);
		GridPane.setConstraints(su_userEntree, 1, 1);
		GridPane.setConstraints(su_pass, 0, 2);
		GridPane.setConstraints(su_passEntree, 1, 2);
		GridPane.setConstraints(su_qpass, 0, 3);
		GridPane.setConstraints(su_qpassEntree, 1, 3);
		GridPane.setConstraints(su_email, 0, 4);
		GridPane.setConstraints(su_emailEntree, 1, 4);
		GridPane.setConstraints(su_warning, 0, 5);
		GridPane.setConstraints(su_signup, 2, 6);
		GridPane.setConstraints(su_login, 2, 7);
		wall1.getChildren().addAll(su_header, su_user, su_userEntree, su_pass, su_passEntree, su_qpass, su_qpassEntree,
				su_email, su_emailEntree, su_warning, su_signup, su_login);
		signUp = new Scene(wall1, 400, 300);

		// end
		// Signup------------------------------------------------------------------------------------------------

		// Success Initial
		// work-area---------------------------------------------------------------------------------

		cc_successMessage = new Label("You have Successfully Signed Up :)");
		cc_back = new Button("Log in");
		// implement of back
		cc_back.setOnAction(e -> window.setScene(logIn));
		// end back
		// layout
		lane = new VBox();
		lane.setPadding(new Insets(10));
		lane.setSpacing(10);
		lane.setAlignment(Pos.CENTER);
		lane.getChildren().addAll(cc_successMessage, cc_back);
		success = new Scene(lane, 400, 300);

		// end
		// success-----------------------------------------------------------------------------------------------

		logIn.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		signUp.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		success.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		window.setScene(logIn);
		window.show();
	}

}
