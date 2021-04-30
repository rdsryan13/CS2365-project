package application;

import java.io.File; // Import the File class
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

	public WriteFile() {
		try {
			final File outFile = new File("../project/data/itemList.dat");
			if (outFile.createNewFile()) {
				System.out.println("File Created...");
			} else {
				System.out.println("File already exist.");
			}
		} catch (final IOException e) {
			System.out.println("An error occured while trying to write file!");
			e.printStackTrace();
		}
	}

	void writeToFile(String str) {
		try {
			final FileWriter writer = new FileWriter("../project/data/itemList.dat", true);
			writer.write("\n");
			writer.write(str);
			writer.close();
			System.out.println("File successfully written to.");
		} catch (final IOException e) {
			System.out.println("An error occured while trying to write to file!");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		final WriteFile file = new WriteFile();
		file.writeToFile("04,Sugar Candy,04,30,2021,1.59,1525");
	}
}
