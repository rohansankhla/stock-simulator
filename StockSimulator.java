package labs.lab7;
import java.util.ArrayList;
import java.util.List;


/**
* Class for simulating trading a single stock at varying prices.
*/
public class StockSimulator {
//private Queue<Block> blocks;
private List<Block> blocks = new ArrayList<Block>();
/**
* Constructor.
*/

private int shares = 0;
private List<Block> allblocks = new ArrayList<Block>();

public StockSimulator() {

}
/**
* Handle a user buying a given quantity of stock at a given price.
*
* @param quantity how many to buy.
* @param price    the price to buy at.
*
* @throws IllegalArgumentException if the requested quantity/price cannot be
sold
* i.e., quantity <= 0 or price < 0
*/
public void buy(int quantity, int price) throws IllegalArgumentException {
	if (quantity <= 0 || price < 0) {
		throw new IllegalArgumentException();
	}
	blocks.add(new Block(quantity, price));
	allblocks.add(new Block(quantity, price));
	shares += quantity;
}
/**
* Handle a user selling a given quantity of stock at a given price.
*
* @param quantity how many to sell.
* @param price    the price to sell.
*
* @return the gain (can be positive or negative)
*
* @throws IllegalArgumentException if the requested quantity cannot be sold
* e.g., quantity exceeds quantity owned, quantity < 1, price < 0
*/
public int sell(int quantity, int price) throws IllegalArgumentException {
	if (quantity > shares || quantity < 1 || price < 0) {
		throw new IllegalArgumentException();
	}
	int profit = 0;
	int numsold = 0;
	while (numsold < quantity) {
		Block current = blocks.get(0);
		if (current.getQuantity() + numsold > quantity) {
			profit += (quantity-numsold)*(price-current.getPrice());
			current.sell(quantity-numsold);
			shares -= (quantity-numsold);
			break;
		}
		else {
			profit += (price-current.getPrice())*(current.getQuantity());
			numsold += current.getQuantity();
			blocks.remove(0);
			allblocks.remove(0);
			shares -= current.getQuantity();
		}
	}
	return profit;
}
/**
* This is a method for us to test your class
*
* @return a List of Blocks owned
*/
public List<Block> getBlocks() {
	return allblocks;
}
}
