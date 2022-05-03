package store;

import java.util.Scanner;
import java.io.*;

public class Provider implements Comparable {
	protected int vat;
	protected String name;
	protected String taxAddress;
	protected Person contactPerson;

	public Provider() {
	}

	public Provider(int vat, String name, String taxAddress, Person contactPerson) {
		this.vat = vat;
		this.name = name;
		this.taxAddress = taxAddress;
		this.contactPerson = contactPerson;
	}

	public int getVat() {
		return vat;
	}

	public String getName() {
		return name;
	}

	public String getTaxAddress() {
		return taxAddress;
	}

	public Person getContactPerson() {
		return contactPerson;
	}

	public void setVat(int vat) {
		this.vat = vat;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTaxAddress(String taxAddress) {
		this.taxAddress = taxAddress;
	}

	public void setContactPerson(Person contactPerson) {
		this.contactPerson = contactPerson;
	}

	public void set(String[] providerData) {
		try {
			setVat(Integer.parseInt(providerData[0]));
			setName(providerData[1]);
			setTaxAddress(providerData[2]);
			Person p = new Person(providerData[3]);
			contactPerson = p;
		} catch (NumberFormatException provider) {
			provider.printStackTrace();
			System.exit(1);
		}
	}

	public String toString() {
		return vat + "|" + name + "|" + taxAddress + "|" + contactPerson + "\n";
	}

	public void print() {
		System.out.println(toString());
	}

	public Provider(String file) {
		readFromFile(file);
	}

	public static Provider readFromStdio() {
		System.out.println("Setting new Provider");
		Provider result = new Provider();
		try {
			Scanner userInput = new Scanner(System.in);
			System.out.print("Vat:");
			result.setVat(Integer.parseInt(userInput.next()));
			System.out.print("Name:");
			result.setName(userInput.next());
			System.out.print("Tax Address:");
			result.setTaxAddress(userInput.next());
			System.out.print("Contact Person:");
			result.setContactPerson(new Person (userInput.next()));
			userInput.close();
		} catch (NumberFormatException provider) {
			provider.printStackTrace();
			System.exit(1);
		}
		return result;
	}

	public static Provider readFromFile(String file) {
		Provider result = new Provider();
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
			if (vat == ((Provider) o).getVat()) {
				info = 0;
			} else if (vat > ((Provider) o).getVat()) {
				info = -1;
			}
			else if (vat < ((Provider) o).getVat()) {
				info = 1;
			}
		} catch (ClassCastException e) {
			System.out.print(" The parameter should be of type Provider");
		}
		return info;

	}

	public boolean equals(Provider p) {
		if (compareTo(p) == 0) {
			return true;
		} else
			return false;

	}
}