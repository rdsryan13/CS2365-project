package application;

import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class market_window extends Application {

	// primaries
	Item[] items;
	// window variables
	Stage window;
	// scenes
	Scene homeMarket, newMarket, featuredMarket, salesMarket, leavingMarket, defaultList, cartPlace, accountPlace,
			seetingsPlace, reportPlace, readPlace, successLogOut;
	// layouts
	BorderPane board, b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bb0, bb1, bb2, bb3, bb4, bb5, bb6;
	// textfields
	TextField search;
	// other
	Scanner read;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		window = primaryStage;
		window.setTitle("Market");

		// layout
		board = new BorderPane();
		board.setTop(topMenu());
		b0 = new BorderPane();
		b0.setTop(topMenu());
		b1 = new BorderPane();
		b1.setTop(topMenu());
		b2 = new BorderPane();
		b2.setTop(topMenu());
		b3 = new BorderPane();
		b3.setTop(topMenu());
		b4 = new BorderPane();
		b4.setTop(topMenu());
		b5 = new BorderPane();
		b5.setTop(topMenu());
		b6 = new BorderPane();
		b6.setTop(topMenu());
		b7 = new BorderPane();
		b7.setTop(topMenu());
		b8 = new BorderPane();
		b8.setTop(topMenu());
		b9 = new BorderPane();
		b9.setTop(topMenu());
		bb0 = new BorderPane();
		bb0.setTop(topMenu());

		// scenes
		homeMarket = new Scene(board, 1960, 1280);
		newMarket = new Scene(b0, 1960, 1280);
		featuredMarket = new Scene(b1, 1960, 1280);
		salesMarket = new Scene(b2, 1960, 1280);
		leavingMarket = new Scene(b3, 1960, 1280);
		defaultList = new Scene(b4, 1960, 1280);
		cartPlace = new Scene(b5, 1960, 1280);
		accountPlace = new Scene(b6, 1960, 1280);
		seetingsPlace = new Scene(b7, 1960, 1280);
		reportPlace = new Scene(b8, 1960, 1280);
		readPlace = new Scene(b9, 1960, 1280);
		successLogOut = new Scene(bb0, 1960, 1280);

		homeMarket.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		window.setScene(homeMarket);
		window.show();
	}

	MenuBar topMenu() {
		// menubars
		MenuBar topMenuBar;
		// menus
		Menu homeMenu;
		Menu wishMenu;
		Menu cartMenu;
		Menu profileMenu;
		Menu helpMenu;

		// menus

		// home menu
		homeMenu = new Menu("_Home");
		// items for homeMenu
		final MenuItem newStuff = new MenuItem("New...");
		newStuff.setOnAction(e -> window.setScene(newMarket));
		final MenuItem everydayStuff = new MenuItem("Everyday...");
		everydayStuff.setOnAction(e -> window.setScene(homeMarket));
		final MenuItem premiumStuff = new MenuItem("Premium...");
		premiumStuff.setOnAction(e -> window.setScene(featuredMarket));
		final MenuItem saleStuff = new MenuItem("On Sale...");
		saleStuff.setOnAction(e -> window.setScene(salesMarket));
		final MenuItem leavingStuff = new MenuItem("Leaving...");
		leavingStuff.setOnAction(e -> window.setScene(leavingMarket));

		homeMenu.getItems().addAll(newStuff, everydayStuff, premiumStuff, saleStuff, leavingStuff);

		// wish menu
		wishMenu = new Menu("_Wish List");
		// items for wishMenu
		final MenuItem defaultStuff = new MenuItem("Default List...");
		defaultStuff.setOnAction(e -> window.setScene(defaultList));

		wishMenu.getItems().add(defaultStuff);

		// cart menu
		cartMenu = new Menu("My _Cart");
		cartMenu.setOnAction(e -> window.setScene(cartPlace));

		// profile menu
		profileMenu = new Menu("_Profile");
		// items for profileMenu
		final MenuItem accountStuff = new MenuItem("My Account...");
		accountStuff.setOnAction(e -> window.setScene(accountPlace));
		final MenuItem settingsStuff = new MenuItem("Settings...");
		settingsStuff.setOnAction(e -> window.setScene(seetingsPlace));
		final MenuItem logOutStuff = new MenuItem("Log out");
		logOutStuff.setOnAction(e -> window.setScene(successLogOut));

		profileMenu.getItems().addAll(accountStuff, settingsStuff, logOutStuff);

		// help menu
		helpMenu = new Menu("_Help");
		// items for helpMenu
		final MenuItem reportStuff = new MenuItem("Report Error");
		reportStuff.setOnAction(e -> window.setScene(reportPlace));
		final MenuItem readStuff = new MenuItem("Read Help");
		readStuff.setOnAction(e -> window.setScene(readPlace));

		helpMenu.getItems().addAll(reportStuff, readStuff);

		// menubars
		topMenuBar = new MenuBar();
		topMenuBar.getMenus().addAll(homeMenu, wishMenu, cartMenu, profileMenu);

		return topMenuBar;
	}

	Label header1(String header) {
		final Label h1 = new Label(header);
		return h1;
	}

	class Item {

		private String name;
		private final int itemNumber;
		private final Date inDate;
		private double price;
		private int amountAvailable;
		Label iName;
		Label iPrice;
		Label iAmountAvailable;
		Label iItemNumber;
		Button purchase;

		Item(int itemNumber, String name, Date inDate, double price, int amountAvailable) {
			this.itemNumber = itemNumber;
			this.name = name;
			this.inDate = inDate;
			this.price = price;
			this.amountAvailable = amountAvailable;

			iName.setText(name);
			iPrice.setText(Double.toString(price));
			iAmountAvailable.setText(Integer.toString(amountAvailable));
			iItemNumber.setText(Integer.toString(itemNumber));
			purchase.setText("add " + name + " to cart");
		}

		boolean isAvailable() {
			if (amountAvailable > 0) {
				return true;
			}
			return false;
		}

		void setAmountAvailable(int amount) {
			amountAvailable = amount;
		}

		void addAmount(int amount) {
			amountAvailable += amount;
		}

		void subAmount(int amount) {
			amountAvailable -= amount;
		}

		int getAmountAvailable() {
			return amountAvailable;
		}

		String getDate() {
			return inDate.getDate();
		}

		void setPrice(double price) {
			this.price = price;
		}

		double getPrice() {
			return price;
		}

		int getItemNumber() {
			return itemNumber;
		}

		void setItemName(String name) {
			this.name = name;
		}

		String getItemName() {
			return name;
		}

	}

	class Date {
		int day, month, year;

		Date(int day, int month, int year) {
			this.day = day;
			this.month = month;
			this.year = year;
		}

		String getDate() {
			return Integer.toString(day) + "/" + Integer.toString(month) + "/" + Integer.toString(year);
		}

		void setDate(int day) {
			this.day = day;
		}

		void setDate(int day, int month) {
			this.day = day;
			this.month = month;
		}

		void setDate(int day, int month, int year) {
			this.day = day;
			this.month = month;
			this.year = year;
		}
	}

}
