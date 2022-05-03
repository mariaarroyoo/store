package store;

import java.util.ArrayList;
import java.util.Scanner;
import dataStructures.Node;
import java.io.*;

public class ProductList extends StockableProduct {
	protected double totalCost;
	protected double totalPrice;
	protected double totalBenefit;
	protected StockableProduct expensiveproduct; // he añadido estas dos variables para poder utilizarlas en el for loop
	protected StockableProduct cheapestproduct; // ya q lo q tengo q returnear son estas variables
	protected ArrayList<StockableProduct> list;
	protected Node<StockableProduct> first; // I have created these variables to use linked lists
	protected Node<StockableProduct> prev;
	int size;

	public ProductList() {
	}

	public ProductList(String name, String brand, String category, boolean isCountable, String measurementUnit,
			int productID, int numUnits, double costperUnit, double priceperUnit, double totalCost, double totalPrice,
			double totalBenefit) {
		super(name, brand, category, isCountable, measurementUnit, productID, numUnits, costperUnit, priceperUnit);
		this.totalCost = totalCost;
		this.totalPrice = totalPrice;
		this.totalBenefit = totalBenefit;
		ArrayList<StockableProduct> list = new ArrayList<StockableProduct>();
	}

	public double CalculateCost(int numUnits, double costperUnit) {
		this.totalCost = this.numUnits * this.costperUnit;
		return this.totalCost;
	}

	public double CalculatePrice(int numUnits, double priceperUnit) {
		this.totalPrice = this.numUnits * this.priceperUnit;
		return this.totalPrice;
	}

	public double CalculateBenefit(double priceperUnit, double costperUnit) {
		this.totalBenefit = this.priceperUnit - this.costperUnit;
		return this.totalBenefit;
	}

	public StockableProduct mostExpensiveProduct() {
		// hacer un array de priceperUnit en el q incluya numUnits
		StockableProduct expensiveproduct = list.get(0);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).priceperUnit > expensiveproduct.priceperUnit) {
				expensiveproduct = list.get(i);
			}
		}
		return expensiveproduct;
	}

	public StockableProduct cheapestProduct() {
		StockableProduct cheapestproduct = list.get(0);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).priceperUnit > cheapestproduct.priceperUnit) {
				cheapestproduct = list.get(i);
			}
		}
		return cheapestproduct;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public double getTotalBenefit() {
		return totalBenefit;
	}

	/**
	 * public ArrayList getList() { return list; }
	 */

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setTotalBenefit(double totalBenefit) {
		this.totalBenefit = totalBenefit;
	}

	/**
	 * public void setList(Arr
	 * 
	 * ayList list) { this.list = list; }
	 */

	public void set(String[] productListData) {
		try {
			setTotalCost(Double.parseDouble(productListData[0]));
			setTotalPrice(Double.parseDouble(productListData[1]));
			setTotalBenefit(Double.parseDouble(productListData[2]));
			// setList(ArrayList.parseArrayList(productListData[3]));
		} catch (NumberFormatException productList) {
			productList.printStackTrace();
			System.exit(1);
		}
	}

	public String toString() {
		return totalCost + "|" + totalPrice + "|" + totalBenefit + "|" + list + "\n"; // he puesto el list del array
																						// pero ns si funcionará
	}

	public void print() {
		System.out.println(toString());
	}

	public ProductList(String file) {
		readFromFile(file);
	}

	public static ProductList readFromStdio() {
		System.out.println("Setting new Productlist");
		ProductList result = new ProductList();
		try {
			Scanner userInput = new Scanner(System.in);
			System.out.print("Total cost:");
			result.setTotalCost(Double.parseDouble(userInput.next()));
			System.out.print("Total Price:");
			result.setTotalPrice(Double.parseDouble(userInput.next()));
			System.out.print("Total Benefit:");
			result.setTotalBenefit(Double.parseDouble(userInput.next()));
			userInput.close();
		} catch (NumberFormatException productList) {
			productList.printStackTrace();
			System.exit(1);
		}
		return result;
	}

	public static ProductList readFromFile(String file) {
		ProductList result = new ProductList();
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
			if (file != null) {
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

	public Node<StockableProduct> getFirst() {

		return first;
	}

	public void setFirst(Node<StockableProduct> first) {
		this.first = first;
	}

	public boolean isEmpty1() {
		return (first == null);
	}

	public Node<StockableProduct> getPrev() {
		return prev;
	}

	public void setPrev(Node<StockableProduct> prev) {
		this.prev = prev;
	}

	public boolean isEmpty2() {
		return (prev == null);
	}

	public int size() {
		return size;
	}

	public void insert(StockableProduct other) {

		/**
		 * adds the product received as parameter to the product list
		 * 
		 * and updates the
		 * 
		 * value of the attributes total cost, total price and total
		 * 
		 * benefit. NOTE: If
		 * 
		 * the product already exists instead of adding it as a new
		 * 
		 * product, it
		 * 
		 * increases the number of units of the existing product.
		 */
		Node<StockableProduct> n = new Node<StockableProduct>(other);
		n.setNext(first);
		first = n;
		size++;
		if (other.getProductID() == productID) {
			numUnits++;
		}
		totalCost = totalCost + other.getCostperUnit();
	}

	public StockableProduct remove(int productID, int numUnits) {

		/**
		 * removes the number of units of the indicated product from the
		 * 
		 * list and
		 * 
		 * updates the value of the attributes that store the total
		 * 
		 * cost, total price
		 * 
		 * and total benefit. If the product does not exist, return
		 * 
		 * null. If after
		 * 
		 * subtracting the number of units indicated as parameter the
		 * 
		 * product is left
		 * 
		 * with zero units, it is permanently removed from the list.
		 */
		StockableProduct info = null;
		if (first != null) {
			if (info.getProductID() == productID) {
				int i = 0;
				while (i < numUnits) {
					StockableProduct info1 = null;
					if (prev != null && prev.getNext() != null) {
						info1 = prev.getNext().getInfo();

						prev.setNext(prev.getNext().getNext());
						size--;
					}
					i++;
					return info;
				}
			}
			first = first.getNext();
			totalCost = totalCost - info.getCostperUnit();
			totalPrice = totalPrice - info.getPriceperUnit();
			totalBenefit = totalBenefit - (totalPrice - totalCost);
		}
		return info;
	}

	public void modify(int productID) {
		StockableProduct newProduct = new StockableProduct();
		newProduct.readFromStdio();
		productID = newProduct.getProductID();
	}

	public int indexOf(int productID) {
		int index = 0;
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).getProductID() == productID) {
				index = i;
			} else
				index = -1;
		}
		return index;
	}

	public StockableProduct search(int productID) {
		StockableProduct search = new StockableProduct();
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).getProductID() == productID) {
				search = list.get(i);
			} else
				search = null;
		}
		return search;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}