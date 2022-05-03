package store;

import java.util.Scanner;
import java.io.*;

public class StockableProduct<Provider> extends Product implements Comparable {
	protected Provider provider;
	protected int productID;
	protected int numUnits;
	protected double costperUnit;
	protected double priceperUnit;

	public StockableProduct() {
	}

	public StockableProduct(String name, String brand, String category, boolean isCountable, String measurementUnit,
			int productID, int numUnits, double costperUnit, double priceperUnit) {
		super(name, brand, category, isCountable, measurementUnit);
		this.productID = productID;
		this.numUnits = numUnits;
		this.costperUnit = costperUnit;
		this.priceperUnit = priceperUnit;

	}

	public int getProductID() {
		return productID;
	}

	public int getNumUnits() {
		return numUnits;
	}

	public double getCostperUnit() {
		return costperUnit;
	}

	public double getPriceperUnit() {
		return priceperUnit;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public void setNumUnits(int numUnits) {
		this.numUnits = numUnits;
	}

	public void setCostperUnit(double costperUnit) {
		this.costperUnit = costperUnit;
	}

	public void setPriceperUnit(double priceperUnit) {
		this.priceperUnit = priceperUnit;
	}

	public void set(String[] stockableProductData) {
		try {
			setProductID(Integer.parseInt(stockableProductData[0]));
			setNumUnits(Integer.parseInt(stockableProductData[1]));
			setCostperUnit(Double.parseDouble(stockableProductData[2]));
			setPriceperUnit(Double.parseDouble(stockableProductData[3]));
		} catch (NumberFormatException stockableProduct) {
			stockableProduct.printStackTrace();
			System.exit(1);
		}
	}

	public String toString() {
		return productID + "|" + numUnits + "|" + costperUnit + "|" + priceperUnit + "\n"  ;
	}

	public void print() {
		System.out.println(toString());
	}

	public StockableProduct(String file) {
		readFromFile(file);
	}

	public static StockableProduct readFromStdio() {
		System.out.println("Setting new Person");
		StockableProduct result = new StockableProduct();
		try {
			Scanner userInput = new Scanner(System.in);
			System.out.print("productID:");
			result.setProductID(Integer.parseInt(userInput.next()));
			System.out.print("Number of units:");
			result.setNumUnits(Integer.parseInt(userInput.next()));
			System.out.print("Cost per unit:");
			result.setCostperUnit(Double.parseDouble(userInput.next()));
			System.out.print("Price per Unit:");
			result.setPriceperUnit(Double.parseDouble(userInput.next()));
			userInput.close();
		} catch (NumberFormatException stockableProduct) {
			stockableProduct.printStackTrace();
			System.exit(1);
		}
		return result;
	}

	public static StockableProduct readFromFile(String file) {
		StockableProduct result = new StockableProduct();
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int compareTo(Object o) {
		int info = 0;
		try {
			double profitperproduct = this.priceperUnit - this.costperUnit;
			double profit2perproduct = ((StockableProduct) o).getPriceperUnit()
					- ((StockableProduct) o).getCostperUnit();

			if (profitperproduct == profit2perproduct) {
				info = 0;
			} else if (profitperproduct > profit2perproduct) {
				info = -1;
			}
			else if (profitperproduct < profit2perproduct) {
				info = 1;
			}
		} catch (ClassCastException e) {
			System.out.print(" The parameter should be of type Stockable Product");
		}
		return info;
	}

	public boolean equals(StockableProduct p) {
		if (compareTo(p) == 0) {
			return true;
		} else
			return false;

	}

}