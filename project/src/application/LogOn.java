package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//reads from customerInfo and sends to login_window

public class LogOn {

	private final String[] username;
	private final String[] email;
	private final String[] password;
	private final String[] firstName;
	private final String[] lastName;
	private final int[] day;
	private final int[] month;
	private final int[] year;

	public int totUsers;
	private final boolean verified = false;

	public String clientUsername = "";
	public String clientEmail = "";
	private String clientPassword = "";
	private String clientFirstName = "";
	private String clientLastName = "";
	private int mday = 0;
	private int mmonth = 0;
	private int myear = 0;

	LogOn() {

		username = new String[99];
		email = new String[99];
		password = new String[99];
		firstName = new String[99];
		lastName = new String[99];
		day = new int[99];
		month = new int[99];
		year = new int[99];

		try {
			final File inFile = new File("../project/data/customerInfo.dat");
			final Scanner reader = new Scanner(inFile);
			String str;
			int i = 0;
			while (reader.hasNextLine()) {
				str = reader.nextLine();
				final String[] token = str.split(",");
				firstName[i] = token[0];
				lastName[i] = token[1];
				username[i] = token[2];
				email[i] = token[3];
				password[i] = token[4];
				day[i] = Integer.parseInt(token[5]);
				month[i] = Integer.parseInt(token[6]);
				year[i] = Integer.parseInt(token[7]);
				i += 1;
				// System.out.println(str);
			}
			totUsers = i;
			reader.close();
		} catch (final FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public boolean verify(String email, String password) {
		for (int i = 0; i < totUsers; i++) {
			if (password.equals(this.password[i]) && email.equalsIgnoreCase(this.email[i])) {
				this.clientUsername = this.username[i];
				this.clientEmail = this.email[i];
				this.clientPassword = this.password[i];
				this.clientFirstName = this.firstName[i];
				this.clientLastName = this.lastName[i];
				this.mday = this.day[i];
				this.mmonth = this.month[i];
				this.myear = this.year[i];
				return true;
			}
		}

		return false;
	}

	protected boolean internalVerify(String password) {
		if (password.equals(this.clientPassword)) {
			return true;
		}
		return false;
	}

	protected String getFirstName() {
		if (verified) {
			return clientFirstName;
		}
		return null;
	}

	protected String getLastName() {
		if (verified) {
			return clientLastName;
		}
		return null;
	}

	protected Date getBirthDate() {
		final Date inDate = new Date(mday, mmonth, myear);
		if (verified) {
			return inDate;
		}
		return null;
	}

	protected void printAllInfo() {
		for (int i = 0; i < totUsers; i++) {
			System.out.println("First Name: " + firstName[i]);
			System.out.println("Last Name: " + lastName[i]);
			System.out.println("Date of birth: " + month[i] + "/" + day[i] + "/" + year[i]);
			System.out.println("Username: " + username[i]);
			System.out.println("Email: " + email[i]);
			System.out.println("Password: " + password[i] + "\n");

		}
	}

	// public static void main(String[] args) {

	// final LogOn log = new LogOn();
	// final String email = "acguy@forment.edu", password = "harRyPoter20";
	// System.out.println(log.verify(email, password));
	// log.printAllInfo();

	// final Scanner input = new Scanner(System.in);
	// System.out.println("Enter id: ");
	// final int id = input.nextInt();
	// System.out.println("Enter password: ");
	// final String password = input.nextLine();
	// if (id != 0 && password != "Null") {
	// System.out.println("Welcome!");
	// }
	// }
}