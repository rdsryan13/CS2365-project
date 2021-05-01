package application;

public class Date {
	int day, month, year;

	public Date(int day, int month, int year) {
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
