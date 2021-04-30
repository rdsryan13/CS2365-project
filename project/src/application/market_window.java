package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

//implements market window
//collects data from GetFileInfo class for item declaration

public class market_window extends Application {

	// primaries
	Item[] items;
	int totItems;
	// window variables
	Stage window;
	// scenes
	Scene homeMarket, newMarket, featuredMarket, salesMarket, leavingMarket, defaultList, cartPlace, accountPlace,
			seetingsPlace, reportPlace, readPlace, successLogOut;
	// layouts
	BorderPane board, b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bb0;
	VBox v1, v2, v3, v4, v5, v6;
	// textfields
	TextField search;
	// other
	GetFileInfo itemInfo;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		window = primaryStage;
		window.setTitle("Market");
		getStuff();
		for (int i = 0; i < totItems; i++) {
			items[i].setAttributes();
		}

		// homeMarket stuff
		// vbox's
		v1 = new VBox();
		v1.getChildren().addAll(header1("Everday Goods"), header2("Welcome to Shopify"));
		v1.setAlignment(Pos.TOP_CENTER);

		v2 = new VBox();
		v2.getChildren().addAll(v1,
				itemsColumn(
						itemRow(itemColumn(items[0]), itemColumn(items[1]), itemColumn(items[2]), itemColumn(items[3])),
						itemRow(itemColumn(items[4]), itemColumn(items[5]), itemColumn(items[6]))));
		v2.setAlignment(Pos.TOP_CENTER);
		// hbox's

		// newMarket stuff
		v3 = new VBox();
		v3.getChildren().addAll(header1("Our Newest Goods"), header2("Shop the Latest Stuff"));
		v3.setAlignment(Pos.TOP_CENTER);

		v4 = new VBox();
		v4.getChildren().addAll(v3, itemsColumn(
				itemRow(itemColumn(items[7]), itemColumn(items[8]), itemColumn(items[9]), itemColumn(items[10])),
				itemRow(itemColumn(items[11]), itemColumn(items[12]))));

		// cart Place
		v5 = new VBox();
		v6 = new VBox();

		// layout
		board = new BorderPane();
		BorderPane.setMargin(v2, new Insets(10, 10, 10, 10));
		board.setTop(topMenu());
		board.setCenter(v2);
		board.setLeft(null);
		board.setRight(null);
		board.setBottom(null);

		b0 = new BorderPane();
		BorderPane.setMargin(v4, new Insets(10, 10, 10, 10));
		b0.setTop(topMenu());
		b0.setCenter(v4);
		b0.setLeft(null);
		b0.setRight(null);
		b0.setBottom(null);

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
		b5.setCenter(v5);

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

		// transfer to cart
		items[0].purchase.setOnAction(e -> {
			v5.getChildren().add(itemColumn(items[0]));
			items[0].purchase.setText("Remove from Cart");
		});

		// scenes
		homeMarket = new Scene(board, 1920, 1080);
		newMarket = new Scene(b0, 1920, 1080);
		featuredMarket = new Scene(b1, 1920, 1080);
		salesMarket = new Scene(b2, 1920, 1080);
		leavingMarket = new Scene(b3, 1920, 1080);
		defaultList = new Scene(b4, 1920, 1080);
		cartPlace = new Scene(b5, 1920, 1080);
		accountPlace = new Scene(b6, 1920, 1080);
		seetingsPlace = new Scene(b7, 1920, 1080);
		reportPlace = new Scene(b8, 1920, 1080);
		readPlace = new Scene(b9, 1920, 1080);
		successLogOut = new Scene(bb0, 1920, 1080);

		// homeMarket.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		window.setScene(homeMarket);
		window.show();
	}

	void getStuff() {
		itemInfo = new GetFileInfo();
		itemInfo.setAll();
		items = itemInfo.getAll();
		totItems = itemInfo.numItems;
	}

	MenuBar topMenu() {
		// menubars
		final MenuBar topMenuBar;
		// menus
		Menu homeMenu;
		final Menu wishMenu;
		final Menu cartMenu;
		final Menu profileMenu;
		final Menu helpMenu;

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

		homeMenu.getItems().addAll(everydayStuff, newStuff, premiumStuff, saleStuff, leavingStuff);

		// wish menu
		wishMenu = new Menu("_Wish List");
		// items for wishMenu
		final MenuItem defaultStuff = new MenuItem("Default List...");
		defaultStuff.setOnAction(e -> window.setScene(defaultList));

		wishMenu.getItems().add(defaultStuff);

		// cart menu
		cartMenu = new Menu("My _Cart");
		// items for cartMenu
		final MenuItem myCart = new MenuItem("My _Cart...");
		myCart.setOnAction(e -> window.setScene(cartPlace));

		cartMenu.getItems().add(myCart);

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

	HBox itemRow(VBox v1, VBox v2, VBox v3, VBox v4) { // item row
		final HBox h = new HBox();
		h.getChildren().addAll(v1, v2, v3, v4);
		h.setAlignment(Pos.CENTER);
		return h;
	}

	HBox itemRow(VBox v1, VBox v2, VBox v3) { // item row
		final HBox h = new HBox();
		h.getChildren().addAll(v1, v2, v3);
		h.setAlignment(Pos.CENTER);
		return h;
	}

	HBox itemRow(VBox v1, VBox v2) { // item row
		final HBox h = new HBox();
		h.getChildren().addAll(v1, v2);
		h.setAlignment(Pos.CENTER);
		return h;
	}

	VBox itemColumn(Item i) {
		final VBox v = new VBox();
		final Label itemNumber = new Label("Item Number:");
		final Label itemPrice = new Label("Price:");
		final Label itemLeft = new Label("Amount of Item Left:");
		final HBox h1 = new HBox(itemNumber, i.iItemNumber), h2 = new HBox(itemPrice, i.iPrice),
				h3 = new HBox(itemLeft, i.iAmountAvailable);
		h1.setSpacing(5);
		h2.setSpacing(5);
		h3.setSpacing(5);
		h1.setAlignment(Pos.CENTER);
		h2.setAlignment(Pos.CENTER);
		h3.setAlignment(Pos.CENTER);

		v.getChildren().addAll(h1, i.iName, h2, h3, i.purchase);
		v.setAlignment(Pos.CENTER);
		v.setPadding(new Insets(10));
		return v;
	}

	VBox itemsColumn(HBox h1, HBox h2, HBox h3) {
		final VBox v = new VBox();
		v.getChildren().addAll(h1, h2, h3);
		v.setAlignment(Pos.CENTER);
		return v;
	}

	VBox itemsColumn(HBox h1, HBox h2) {
		final VBox v = new VBox();
		v.getChildren().addAll(h1, h2);
		v.setAlignment(Pos.CENTER);
		return v;
	}

	VBox itemsColumn(HBox h1) {
		final VBox v = new VBox();
		v.getChildren().addAll(h1);
		v.setAlignment(Pos.CENTER);
		return v;
	}

	VBox itemsColumn(VBox v1) {
		final VBox v = new VBox();
		v.getChildren().addAll(v1);
		v.setAlignment(Pos.CENTER);
		return v;
	}

	Label header1(String header) {
		final Label h = new Label(header);
		h.setFont(Font.font("Veradana", FontWeight.BOLD, 40));
		return h;
	}

	Label header2(String header) {
		final Label h = new Label(header);
		h.setFont(Font.font("Veradana", FontWeight.BOLD, 22));
		return h;
	}

	Label header3(String header) {
		final Label h = new Label(header);
		h.setFont(Font.font("Veradana", FontWeight.BOLD, 14));
		return h;
	}

	public class Item {

		private String name;
		private int itemNumber;
		private Date inDate;
		private double price;
		private int amountAvailable;
		public Label iName;
		public Label iPrice;
		public Label iAmountAvailable;
		public Label iItemNumber;
		public Button purchase;

		Item(int itemNumber, String name, Date inDate, double price, int amountAvailable) {
			this.itemNumber = itemNumber;
			this.name = name;
			this.inDate = inDate;
			this.price = price;
			this.amountAvailable = amountAvailable;

			iName = new Label();
			iPrice = new Label();
			iAmountAvailable = new Label();
			iItemNumber = new Label();
			purchase = new Button();

			iName.setText(name);
			iPrice.setText(Double.toString(price));
			iAmountAvailable.setText(Integer.toString(amountAvailable));
			iItemNumber.setText(Integer.toString(itemNumber));
			purchase.setText("add " + name + " to cart");
		}

		Item() {
			this.itemNumber = 0;
			this.name = "";
			this.inDate = new Date();
			this.price = 0;
			this.amountAvailable = 0;

			iName = new Label();
			iPrice = new Label();
			iAmountAvailable = new Label();
			iItemNumber = new Label();
			purchase = new Button();
		}

		void setAttributes() {
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

		void setItemNumber(int itemNumber) {
			this.itemNumber = itemNumber;
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

		void setDate(int day, int month, int year) {
			inDate.setDate(day, month, year);
		}

		void setDate(Date inDate) {
			this.inDate = inDate;
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

		Date() {
			day = 0;
			month = 0;
			year = 0;
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
