package labs.lab7;
/**
* A quantity and price of a block of stocks.
*/
public class Block {
private int price1;
private int quantity1;
/**
* Constructor.
*
* @param quantity the quantity of shares in this block.
* @param price    the price of this block.
*/
public Block(int quantity, int price) {
	quantity1 = quantity;
	price1 = price;
}
public int getQuantity() {
	return quantity1;
}
public int getPrice() {
	return price1;
}
/**
* Sells shares in this block
*
* @param shares   the number of shares to sell
*/
public void sell(int shares) {
	quantity1 -= shares;
}

}
