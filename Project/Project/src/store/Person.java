package store;

import java.util.Scanner;
import java.io.*;

public class Person implements Comparable {
	protected int id;
	protected String firstName;
	protected String lastName;
	protected String email;

	public Person() {
	}

	public Person(int id, String firstName, String lastName, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setFirstName(String firstName) throws NumberFormatException {
		if (firstName.length() > 11) {
			throw new NumberFormatException("The first name must have a maximum of 11 characters");
		} else {
			this.firstName = firstName;
		}
	}

	public void setLastName(String lastName) throws NumberFormatException {
		if (lastName.length() > 15) {
			throw new NumberFormatException("The last name must have a maximum of 15 characters");
		} else {
			this.lastName = lastName;
		}
	}

	public void setEmail(String email) throws NumberFormatException {
		if (email.endsWith("@gmail.com")) {
			this.email = email;
		}

		else {
			throw new NumberFormatException("Email must include @gmail.com");
		}

	}

	public void setId(int id) {
		this.id = id;
	}

	public void set(String[] personData) {
		try {
			setId(Integer.parseInt(personData[0]));
			setFirstName(personData[1]);
			setLastName(personData[2]);
			setEmail(personData[3]);
		} catch (NumberFormatException person) {
			person.printStackTrace();
			System.exit(1);
		}
	}

	public String toString() {
		return id + "|" + firstName + "|" + lastName + "|" + email + "\n";
	}

	public void print() {
		System.out.println(toString());
	}

	public Person(String file) {
		readFromFile(file);
	}

	public static Person readFromStdio() {
		System.out.println("Setting new Person");
		Person result = new Person();
		try {
			Scanner userInput = new Scanner(System.in);
			System.out.print("Id:");
			result.setId(Integer.parseInt(userInput.next()));
			System.out.print("First Name:");
			result.setFirstName(userInput.next());
			System.out.print("Last Name:");
			result.setLastName(userInput.next());
			System.out.print("email:");
			result.setEmail(userInput.next());
			userInput.close();
		} catch (NumberFormatException person) {
			person.printStackTrace();
			System.exit(1);
		}
		return result;
	}

	public static Person readFromFile(String file) {
		Person result = new Person();
		BufferedReader in = null;
		String line = null;
		if (file != null) {
			try {
				in = new BufferedReader(new FileReader(file));
				while ((line = in.readLine()) != null) {
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
			if (id == ((Person) o).getId()) {
				info = 0;
			} else if (id > ((Person) o).getId()) {
				info = -1;
			} else if (id < ((Person) o).getId()) {
				info = 1;
			}
		} catch (ClassCastException e) {
			System.out.print(" The parameter should be of type Person");
		}
		return info;
	}

	public void equals(int[] id) {
		String a = id.toString();
		if (a.equals(a))
			System.out.println("Same");
		else
			System.out.println("Not the same");
	}

}