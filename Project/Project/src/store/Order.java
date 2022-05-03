package store;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Order extends ProductList {
	protected String orderID;
	protected Person client;
	protected Person employee;

	public Order() {
	}

	public Order(String name, String brand, String category, boolean isCountable, String measurementUnit, int productID,
			int numUnits, double costperUnit, double priceperUnit, double totalCost, double totalPrice,
			double totalBenefit, String orderID, Person client, Person employee, ArrayList<StockableProduct> list) {
		super(name, brand, category, isCountable, measurementUnit, productID, numUnits, costperUnit, priceperUnit,
				totalCost, totalPrice, totalBenefit); // nos falta el list
		this.orderID = orderID;
		this.client = client;
		this.employee = employee;
	}

	public String getOrderID() {
		return orderID;
	}

	public Person getoClient() {
		return client;
	}

	public Person getEmployee() {
		return employee;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public void setClient(Person client) {
		this.client = client;
	}

	public void setEmployee(Person employee) {
		this.employee = employee;
	}

	public void set(String[] orderData) {
		try {
			setOrderID(orderData[0]);
			Person p = new Person(orderData[1]);
			client = p;
			Person r = new Person(orderData[2]);
			client = r;
		} catch (NumberFormatException order) {
			order.printStackTrace();
			System.exit(1);
		}
	}

	public String toString() {
		return orderID + "|" + client + "|" + employee + "\n";
	}

	public void print() {
		System.out.println(toString());
	}

	public Order(String file) {
		readFromFile(file);
	}

	public static Order readFromStdio() {
		System.out.println("Setting new Order");
		Order result = new Order();
		try {
			Scanner userInput = new Scanner(System.in);
			System.out.print("Order ID:");
			result.setOrderID(userInput.next());
			System.out.print("Client:");
			result.setClient(new Person (userInput.next()));
			System.out.print("Employee:");
			result.setEmployee(new Person (userInput.next()));
			userInput.close();
		} catch (NumberFormatException order) {
			order.printStackTrace();
			System.exit(1);
		}
		return result;
	}

	public static Order readFromFile(String file) {
		Order result = new Order();
		BufferedReader in = null;
		String line = null;
		if (file != null) {
			try {
				in = new BufferedReader(new FileReader(file));
				if ((line = in.readLine()) != null) {
					String[] data = line.split("\\|");
					result.set(data);
					in.close();
					return result;
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
				System.exit(1);
			}
		}
		return result;
	}

	public void writeToFile(String file) {
		BufferedWriter out = null;
		try {
			while (file != null) {
				out = new BufferedWriter(new FileWriter(file, true));
				out.write(toString()); 
				out.flush();
				out.close();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace(); // to debug
			System.exit(1);
		}
	} 

	public void modify(String orderID) {	
		Order neworder = new Order(); 
		neworder.readFromStdio();
		 orderID = neworder.getOrderID();
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}