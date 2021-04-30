package application;
import java.util.Scanner;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;

public class market_window extends Application {
	
	//primaries
	Item [] items;
	//window variables
	Stage window;
	Scene market;
	//labels
	Label header1;
	Label header2;
	Label header3;
	//other
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
		
		
		
		market.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		window.setScene(market);
		window.show();
	}
	
	class Item {
		
		private String name;
		private int itemNumber;
		private Date inDate;
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
			if(amountAvailable > 0)
				return true;
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
			return inDate.retDate();
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
		
		String retDate() {
			return Integer.toString(day) + "/" + Integer.toString(month) + "/" + Integer.toString(year);
		}
		
		void updateDate(int day) {
			this.day = day;
		}
		
		void updateDate(int day, int month) {
			this.day = day;			
			this.month = month;
		}
		
		void updateDate(int day, int month, int year) {
			this.day = day;
			this.month = month;
			this.year = year;
		}
	}

}
