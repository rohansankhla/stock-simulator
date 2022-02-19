package [INSERT];
import java.util.Scanner;
/**
* Runs a Stock Trading Simulation
*/
public class StockSimulationUI {
public static void main(String[] args) {
StockSimulator sim = new StockSimulator();
Scanner in = new Scanner(System.in);
boolean done = false;
System.out.println("Stock Simulator Menu");
System.out.println("-----------------------------------------------");
System.out.println(" > buy quantity price");
System.out.println(" > sell quantity price");
System.out.println(" > quit to quit simulation.");
System.out.println();
while (!done) {
try {
System.out.print(" > ");
String action = in.next();
if (action.equals("buy")) {
int quantity = in.nextInt();
int price = in.nextInt();
sim.buy(quantity, price);
} else if (action.equals("sell")) {
int quantity = in.nextInt();
int price = in.nextInt();
System.out.println("Gain: " + sim.sell(quantity,
price));
} else if (action.equals("quit")) {
done = true;
}
} catch (IllegalArgumentException e) {
System.out.println(e.getMessage());
}
}
}
}
