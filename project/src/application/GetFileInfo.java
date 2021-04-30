package application;

import application.market_window.Item;

public class GetFileInfo {
	private final market_window sin;
	private final Item[] marketItems;
	private final GetFile file;
	public int numItems;

	GetFileInfo() {
		sin = new market_window();
		marketItems = new Item[99];
		file = new GetFile();
	}

	public void setAll() {
		numItems = file.getTotalProds();
		for (int i = 0; i < numItems; i++) {
			marketItems[i] = sin.new Item();
			marketItems[i].setItemName(file.getName()[i]);
			marketItems[i].setItemNumber(file.getNumber()[i]);
			marketItems[i].setAmountAvailable(file.getAmount()[i]);
			marketItems[i].setPrice(file.getPrice()[i]);
			marketItems[i].setDate(file.getDay()[i], file.getMonth()[i], file.getYear()[i]);
		}
	}

	public Item[] getAll() {
		return marketItems;
	}
}
