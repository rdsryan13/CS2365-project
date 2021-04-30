package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GetFile {
	int[] number;
	String[] name;
	int[] day;
	int[] month;
	int[] year;
	double[] price;
	int[] amount;
	int totalProds;

	public GetFile() {
		number = new int[99];
		name = new String[99];
		day = new int[99];
		month = new int[99];
		year = new int[99];
		price = new double[99];
		amount = new int[99];

		try {
			final File inFile = new File("../project/data/itemList.dat");
			final Scanner reader = new Scanner(inFile);
			String str;
			int i = 0;
			while (reader.hasNextLine()) {
				str = reader.nextLine();
				final String[] token = str.split(",");
				number[i] = Integer.parseInt(token[0]);
				name[i] = token[1];
				day[i] = Integer.parseInt(token[2]);
				month[i] = Integer.parseInt(token[3]);
				year[i] = Integer.parseInt(token[4]);
				price[i] = Double.parseDouble(token[5]);
				amount[i] = Integer.parseInt(token[6]);
				i += 1;
				// System.out.println(str);
			}
			totalProds = i;
			reader.close();

		} catch (final FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	int[] getNumber() {
		return number;
	}

	String[] getName() {
		return name;
	}

	int[] getDay() {
		return day;
	}

	int[] getMonth() {
		return month;
	}

	int[] getYear() {
		return year;
	}

	double[] getPrice() {
		return price;
	}

	int[] getAmount() {
		return amount;
	}

	int getTotalProds() {
		return totalProds;
	}

	void printAll() {
		for (int i = 0; i < totalProds; i++) {
			System.out.println("Item number: " + number[i]);
			System.out.println("Item name: " + name[i]);
			System.out.println("Item date of entree: " + month[i] + "/" + day[i] + "/" + year[i]);
			System.out.println("Item Price: " + price[i]);
			System.out.println("Number of this item available: " + amount[i] + "\n");
		}
	}

	public static void main(String[] args) {
		final GetFile get = new GetFile();

		get.printAll();
	}
}
