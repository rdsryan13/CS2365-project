package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class Stager extends Application {

	static Stage window;

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		window = arg0;

		Stager.getStage().setScene(null);
	}

	public static Stage getStage() {
		return window;
	}

}
