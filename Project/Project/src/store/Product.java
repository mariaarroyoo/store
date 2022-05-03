package store;

import java.util.Scanner;
import java.io.*;

public class Product {
	protected String name;
	protected String brand;
	protected String category;
	protected boolean isCountable;
	protected String measurementUnit;
	// definir error para letras diferentes para category

	public Product() {
	}

	public Product(String name, String brand, String category, boolean isCountable, String measurementUnit) {
		this.name = name;
		this.brand = brand;
		this.category = category;
		this.isCountable = isCountable;
		this.measurementUnit = measurementUnit;
	}

	public Product(String file) {
		readFromFile(file);
	}

	public String getName() {
		return name;
	}

	public String getBrand() {
		return brand;
	}

	public String getCategory() {
		return category;
	}

	public boolean getIsCountable() {
		return isCountable;
	}

	public String getMeasureentUnit() {
		return measurementUnit;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setCategory(String category) throws NumberFormatException {
		if (category != "f" || category != "s" || category != "e" || category != "m") {
			throw new NumberFormatException("This is not a valid category.");
		} else {
			this.category = category;
		}
	}

	public void setIsCountable(boolean isCountable) {
			this.isCountable = isCountable;
		
	}

	public void setMeasurementUnit(String measurementUnit) {
		if (measurementUnit != "kg" || measurementUnit != "liters") {
			throw new NumberFormatException("This is not a valid measuremne unit");
		} else {
			this.measurementUnit = measurementUnit;
		}
	}

	public void set(String[] productData) {
		try {
			setName(productData[0]);
			setBrand(productData[1]);
			setCategory(productData[2]);
			setIsCountable(Boolean.parseBoolean(productData[3]));
			setMeasurementUnit(productData[4]);

		} catch (NumberFormatException product) {
			product.printStackTrace();
			System.exit(1);
		}
	}

	public String toString() {
		return name + "|" + brand + "|" + category + "|" + measurementUnit + "\n";
	}

	public void print() {
		System.out.println(toString());
	}

	public static Product readFromStdio() {
		System.out.println("Setting new Product");
		Product result = new Product();
		try {
			Scanner userInput = new Scanner(System.in);
			System.out.print("Name:");
			result.setName(userInput.next());
			System.out.print("Brand:");
			result.setBrand(userInput.next());
			System.out.print("Category: ");
			result.setCategory(userInput.next());
			System.out.print("Countable:");
			result.setIsCountable(Boolean.parseBoolean(userInput.next())); // boolean
			System.out.print("Measurement Unit:");
			result.setMeasurementUnit(userInput.next());
			userInput.close();
		} catch (NumberFormatException product) {
			product.printStackTrace();
			System.exit(1);
		}
		return result;
	}

	public static Product readFromFile(String file) {
		Product result = new Product();
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
			ioe.printStackTrace();
			System.exit(1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}