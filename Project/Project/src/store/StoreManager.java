package store;

import java.util.Scanner;

import dataStructures.BSTree;
import dataStructures.LBSTree;
import dataStructures.LinkedList;
import dataStructures.LinkedQueue;
import dataStructures.Node;
import dataStructures.Queue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StoreManager<E> extends ProductList {
	protected String Name;
	protected double stockCost;
	protected double stockBenefit;
	protected double stockPrice;
	protected ProductList stock;
	protected LinkedQueue<Order> ordersToProcess;
	protected LinkedList<Order> ordersProcessed;
	protected LBSTree<Person> storeEmployees;
	protected String[] storeDataInfo;
	protected LBSTree<Person> storeCustomers;
	protected LBSTree<Provider> storeProviders;

	public StoreManager() {
	}

	public StoreManager(String Name, double stockCost, double stockBenefit, String name, String brand, String category,
			boolean isCountable, String measurementUnit, int productID, int numUnits, double costperUnit,
			double priceperUnit, double totalCost, double totalPrice, double totalBenefit) {
		super(name, brand, category, isCountable, measurementUnit, productID, numUnits, costperUnit, priceperUnit,
				totalCost, totalPrice, totalBenefit); // falta arraylist
		this.Name = Name;
		this.stockCost = stockCost;
		this.stockBenefit = stockBenefit;
		this.stockPrice = stockPrice;
		ArrayList<ProductList> stock = new ArrayList<ProductList>();
	}

	public StoreManager(String name, String stock, String ordersToProcess, String ordersProcessed,
			String storeCustomers, String storeProviders, String storeEmployees) {
		this.name = name;
		setStock(stock);
		setOrdersToProcess(ordersToProcess);
		setOrdersProcessed(ordersProcessed);
		setStoreCustomers(storeCustomers);
		setStoreProviders(storeProviders);
		setStoreEmployees(storeEmployees);
		this.stockCost = readFromFile(stock).getTotalCost();
		this.stockPrice = readFromFile(stock).getTotalPrice();
		stockBenefit = stockPrice - stockCost;
	}

	public String getName() {
		return name;
	}

	public double getStockCost() {
		return stockCost;
	}

	public double getStcokBenefit() {
		return stockBenefit;
	}

	public ProductList getStock() {
		return stock;
	}

	public LinkedQueue<Order> getOrdersToProcess() {
		return ordersToProcess;
	}

	public LinkedList<Order> getOrdersProcessed() {
		return ordersProcessed;
	}

	public LBSTree<Person> getStoreEmplyees() {
		return storeEmployees;
	}

	public String[] getStoreDataInfo() {
		return storeDataInfo;
	}

	public LBSTree<Person> getstoreCustomers() {
		return storeCustomers;
	}

	public LBSTree<Provider> getstoreProviders() {
		return storeProviders;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public void setStockCost(double stockCost) {
		this.stockCost = stockCost;
	}

	public void setStockBenefit(double stockBenefit) {
		this.stockBenefit = stockBenefit;
	}

	public void setStock(ArrayList sotck) {
		this.stock = stock;
	}

	public void setOrdersToProcess(LinkedQueue<Order> ordersToProcess) {
		this.ordersToProcess = ordersToProcess;
	}

	public void setOrdersProcessed(LinkedList<Order> ordersProcessed) {
		this.ordersProcessed = ordersProcessed;
	}

	public void setStoreEmployees(LBSTree<Person> storeEmployees) {

		this.storeEmployees = storeEmployees;
	}

	public void setStoreDataInfo(String[] storeDataInfo) {
		this.storeDataInfo = storeDataInfo;
	}

	public void setstoreCustomers(LBSTree<Person> storeCustomers) {

		this.storeCustomers = storeCustomers;
	}

	public void setstoreProviders(LBSTree<Provider> storeProviders) {

		this.storeProviders = storeProviders;
	}

	public void set(String[] storeManagerData) {
		try {
			setName(storeManagerData[0]);
			setStockCost(Double.parseDouble(storeManagerData[1]));
			setStockBenefit(Double.parseDouble(storeManagerData[2]));
			// setStock(ArrayList.parseArrayList(storeManagerData[3]));
		} catch (NumberFormatException storeManager) {
			storeManager.printStackTrace();
			System.exit(1);
		}
	}

	public String toString() {
		return "Name:" + Name + "|" + "Stock cost:" + stockCost + "|" + "Stock benefit:" + stockBenefit + "|" + "\n";
	}

	public void insertStockMenu() {
		System.out.println("Insert new stock");
		insert("Stock");
	}

	public void removeStockMenu() {
		System.out.println("Remove stock");
		remove("Stock");
	}

	public void modifyStockMenu() {
		System.out.println("Modify stock");
		modify("Stock");
	}

	public void searchStockMenu() {
		System.out.println("Search stock");
		search("Stock");
	}

	public void printStockMenu() {
		System.out.println("Print stock");
		stock.print();
	}

	public void exitStockMenu() {
		System.out.println("Exit new stock");
	}

	public void insertOrdersProcessedMenu() {
		System.out.println("Insert new order processed");
		insert("Order Processed");
	}

	public void removeOrdersProcessedMenu() {
		System.out.println("Remove order processed");
		remove("Order Processed");
	}

	public void modifyOrdersProcessedMenu() {
		System.out.println("Modify order processed");
		modify("Order Processed");
	}

	public void searchOrdersProcessedMenu() {
		System.out.println("Search order processed");
		search("Order Processed");
	}

	public void printOrdersProcessedMenu() {
		System.out.println("Print order processed");
		ordersProcessed.print();
	}

	public void exitOrdersProcessedMenu() {
		System.out.println("Exit new orders");
	}

	public void insertOrdersToProcessMenu() {
		System.out.println("Insert new order to process");
		insert("Order To Process");
	}

	public void removeOrdersToProcessMenu() {
		System.out.println("Remove order to process");
		remove("Order To Process");
	}

	public void modifyOrdersToProcessMenu() {
		System.out.println("Modify order to process");
		modify("Order To Process");
	}

	public void searchOrdersToProcessMenu() {
		System.out.println("Search order to process");
		search("Order To Process");
	}

	public void printOrdersToProcessMenu() {
		System.out.println("Print new order to process");
		ordersToProcess.print();
	}

	public void exitOrdersToProcessMenu() {
		System.out.println("Exit new orders");
	}

	public void insertClientsMenu() {
		System.out.println("Insert new client");
		insert("Customer");
	}

	public void removeClientsMenu() {
		System.out.println("Remove client");
		remove("Customer");
	}

	public void modifyClientsMenu() {
		System.out.println("Modify client");
		modify("Customer");
	}

	public void searchClientsMenu() {
		System.out.println("Search client");
		search("Customer");
	}

	public void printClientsMenu() {
		System.out.println("Print new order to client");
		storeCustomers.print();
	}

	public void exitClientsMenu() {
		System.out.println("Exit new client");
	}

	public void insertProviderMenu() {
		System.out.println("Insert new provider");
		insert("Provider");
	}

	public void removeProviderMenu() {
		System.out.println("Remove provider");
		remove("Provider");
	}

	public void modifyProviderMenu() {
		System.out.println("Modify provider");
		modify("Customer");
	}

	public void searchProviderMenu() {
		System.out.println("Search provider");
		search("Provider");
	}

	public void printProviderMenu() {
		System.out.println("Print new order to provider");
		storeProviders.print();
	}

	public void exitProviderMenu() {
		System.out.println("Exit new provider");
	}

	public void insertEmployeeMenu() {
		System.out.println("Insert new employee");
		insert("Employee");
	}

	public void removeEmployeeMenu() {
		System.out.println("Remove employee");
		remove("Employee");
	}

	public void modifyEmployeeMenu() {
		System.out.println("Modify employee");
		modify("Employee");
	}

	public void searchEmployeeMenu() {
		System.out.println("Search employee");
		search("Emplyee");
	}

	public void printEmployeeMenu() {
		System.out.println("Print new order to employee");
		storeEmployees.print();
	}

	public void exitEmployeeMenu() {
		System.out.println("Exit new employee");
	}

	public static void main(String[] args) {
		StoreManager menu = new StoreManager();
		System.out.print(menu); // mirar lo del array list
		Scanner input = new Scanner(System.in);
		System.out.println("1 - Create store\n" + "2 - Manage stock\n" + "3 - Manage orders (to process)\n"
				+ "4 - Manage orders (processed)\n" + "5 - Manage clients\n" + "6 - Manage providers\n"
				+ "7 - Manage employees\n" + "8 - Print store info\n" + "9 - Testing\n" + "0 - Exit applications");
		System.out.print("Choose an option");
		int a;
		a = input.nextInt();

		switch (a) {
		case 2: {
			String[] managerstock = { "++1 - Insert stock", "++2 - Remove stock", "++3 - Modify stock",
					"++4 - Search stock", "++0 - Exit" };
			for (int i = 0; i < managerstock.length; i++) {
				System.out.println(managerstock[i]);
			}
			Scanner input2 = new Scanner(System.in);
			System.out.println("Choose an option");
			int b;
			b = input2.nextInt();

			if (b == 1) {
				insertStockMenu();
			}

			else if (b == 2) {
				removeStockMenu();
			}

			else if (b == 3) {
				modifyStockMenu();
			}

			else if (b == 4) {
				searchStockMenu();
			}

			else if (b == 0) {
				exitStockMenu();
			} else {
				throw new NumberFormatException("This option is not available.");
			}

			break;
		}

		case 3: {
			String[] managerorders = { "++1 - Insert orders", "++2 - Remove orders", "++3 - Modify orders",
					"++4 - Search orders", "++0 - Exit" };
			for (int i = 0; i < managerorders.length; i++) {
				System.out.println(managerorders[i]);
			}
			Scanner input2 = new Scanner(System.in);
			System.out.print("Choose an option");
			int b;
			b = input2.nextInt();

			if (b == 1) {
				insertOrdersMenu();
			}

			else if (b == 2) {
				removeOrdersMenu();
			}

			else if (b == 3) {
				modifyOrdersMenu();
			}

			else if (b == 4) {
				searchOrdersMenu();
			}

			else if (b == 0) {
				exitOrdersMenu();
			} else {
				throw new NumberFormatException("This option is not available.");
			}

			break;
		}

		case 4: {
			String[] managerorders = { "++1 - Insert orders", "++2 - Remove orders", "++3 - Modify orders",
					"++4 - Search orders", "++0 - Exit" };
			for (int i = 0; i < managerorders.length; i++) {
				System.out.println(managerorders[i]);
			}
			Scanner input2 = new Scanner(System.in);
			System.out.print("Choose an option");
			int b;
			b = input2.nextInt();

			if (b == 1) {
				insertOrders2Menu();
			}

			else if (b == 2) {
				removeOrders2Menu();
			}

			else if (b == 3) {
				modifyOrders2Menu();
			}

			else if (b == 4) {
				searchOrders2Menu();
			}

			else if (b == 0) {
				exitOrdersMenu();
			} else {
				throw new NumberFormatException("This option is not available.");
			}

			break;
		}

		case 5: {
			String[] managerclients = { "++1 - Insert clients", "++2 - Remove clients", "++3 - Modify clients",
					"++4 - Search clients", "++0 - Exit" };
			for (int i = 0; i < managerclients.length; i++) {
				System.out.println(managerclients[i]);
			}
			Scanner input2 = new Scanner(System.in);
			System.out.print("Choose an option");
			int b;
			b = input2.nextInt();

			if (b == 1) {
				insertClientsMenu();
			}

			else if (b == 2) {
				removeClientsMenu();
			}

			else if (b == 3) {
				modifyClientsMenu();
			}

			else if (b == 4) {
				searchClientsMenu();
			}

			else if (b == 0) {
				exitClientsMenu();
			} else {
				throw new NumberFormatException("This option is not available.");
			}

			break;
		}

		case 6: {
			String[] managerprovider = { "++1 - Insert provider", "++2 - Remove provider", "++3 - Modify provider",
					"++4 - Search provider", "++0 - Exit" };
			for (int i = 0; i < managerprovider.length; i++) {
				System.out.println(managerprovider[i]);
			}
			Scanner input2 = new Scanner(System.in);
			System.out.print("Choose an option");
			int b;
			b = input2.nextInt();

			if (b == 1) {
				insertProviderMenu();
			}

			else if (b == 2) {
				removeProviderMenu();
			}

			else if (b == 3) {
				modifyProviderMenu();
			}

			else if (b == 4) {
				searchProviderMenu();
			}

			else if (b == 0) {
				exitProviderMenu();
			} else {
				throw new NumberFormatException("This option is not available.");
			}

			break;
		}

		case 7: {
			String[] manageremployee = { "++1 - Insert employee", "++2 - Remove employee", "++3 - Modify employee",
					"++4 - Search employee", "++0 - Exit" };
			for (int i = 0; i < manageremployee.length; i++) {
				System.out.println(manageremployee[i]);
			}
			Scanner input2 = new Scanner(System.in);
			System.out.print("Choose an option");
			int b;
			b = input2.nextInt();
			if (b == 1) {
				insertEmployeeMenu();
			}

			else if (b == 2) {
				removeEmployeeMenu();
			}

			else if (b == 3) {
				modifyEmployeeMenu();
			}

			else if (b == 4) {
				searchEmployeeMenu();
			}

			else if (b == 0) {
				exitEmployeeMenu();
			}

			else {
				throw new NumberFormatException("This option is not available.");
			}
			break;
		}

		default: {
			throw new NumberFormatException("This option is not available.");
		}

		}
	}

	public void setStock(String file) {
		storeDataInfo[1] = file;
		readFromFile(file);
		StockableProduct f = new StockableProduct(file);
		stock.insert(f);
	}

	public void setOrdersToProcess(String folder) {
		storeDataInfo[2] = folder; // stores folder in the array
		readFromFile(folder); // reads files
		Order f = new Order(folder);
		ordersToProcess.enqueue(f);
	}

	public void setOrdersProcessed(String file) {
		storeDataInfo[3] = file;
		readFromFile(file);
		Order f = new Order(file);
		ordersProcessed.insert(f);
	}

	public void setStoreCustomers(String file) {
		storeDataInfo[4] = file;
		readFromFile(file);
		Person p = new Person(file);
		storeCustomers.insert(p.getId(), p);
	}

	public void setStoreProviders(String file) {
		storeDataInfo[5] = file;
		readFromFile(file);
		Provider p = new Provider(file);
		storeProviders.insert(p.getVat(), p); // ordered by vat number
	}

	public void setStoreEmployees(String file) {
		storeDataInfo[6] = file;
		readFromFile(file);
		Person p = new Person(file);
		storeEmployees.insert(p.getId(), p); // ordered by id
	}

	public void set1(String[] storeData) {
		setName(storeData[0]);
		setStock(storeData[1]);
		setOrdersToProcess(storeData[2]);
		setOrdersProcessed(storeData[3]);
		setStoreCustomers(storeData[4]);
		setStoreProviders(storeData[5]);
		setStoreEmployees(storeData[6]);

	}

	public void print() {
		System.out.println(toString1() + "\n" + stockCost + "\n" + stockBenefit);
	}

	public String toString1() {
		return (name + "|" + stock + "|" + ordersToProcess + "|" + ordersProcessed + "|" + storeCustomers + "|"
				+ storeProviders + "|" + storeEmployees);
	}

	public ArrayList<Person> readPersonsFromFile(String file) {
		ArrayList<Person> result = new ArrayList<Person>();
		BufferedReader in = null;
		String line;
		if (file != null) {
			try {
				in = new BufferedReader(new FileReader(file));
				while ((line = in.readLine()) != null) {
					Person p = new Person(line);
					result.add(p);
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

	public ArrayList<Provider> readProvidersFromFile(String file) {
		ArrayList<Provider> result = new ArrayList<Provider>();
		BufferedReader in = null;
		String line = null;
		if (file != null) {
			try {
				in = new BufferedReader(new FileReader(file));
				while ((line = in.readLine()) != null) {
					Provider p = new Provider(line);
					result.add(p);
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

	public static ArrayList<Order> readOrdersFromFolder(String folder) {
		ArrayList<Order> result = new ArrayList<Order>();
		File file = new File(folder);
		File[] fileList = null;
		if (file.isDirectory()) {
			fileList = file.listFiles();
			for (int i = 0; i < file.list().length; i++) {
				Order aux = Order.readFromFile(fileList[i].getName());
				result.add(aux);
			}
		} else {
			System.out.println("non valid dir");
		}
		return result;
	}

	public void insert(String context) {
		System.out.println("Inserting" + context);
		switch (context) {
		case "Stock":
			StockableProduct s = new StockableProduct();
			s.readFromStdio();
			stock.insert(s);
			break;

		case "Orders to Process":
			Order order = new Order();
			order.readFromStdio();
			ordersToProcess.enqueue(order);
			break;

		case "Orders Processed":
			Order orderprocessed = new Order();
			orderprocessed.readFromStdio();
			ordersProcessed.insert(orderprocessed);
			break;

		case "Customers":
			Person customer = new Person();
			customer.readFromStdio();
			storeCustomers.insert(customer, customer);
			break;

		case "Providers":
			Provider provider = new Provider();
			provider.readFromStdio();
			storeProviders.insert(provider, provider);
			break;

		case "Employees":
			Person employee = new Person();
			employee.readFromStdio();
			storeEmployees.insert(employee, employee);
			break;
		}
	}

	public Object search(String context) {
		System.out.println("Searching" + context);

		switch (context) {
		case "Stock": {
			System.out.print("What product do you want to search? Enter the product ID");
			StockableProduct sp = new StockableProduct();
			sp.readFromStdio();
			if (sp != null) {
				stock.search(sp.getProductID());
			}
		}
			break;

		case "Orders to Process": {
			System.out.print("What product do you want to search? Enter the product ID");
			Order order = new Order();
			order.readFromStdio();
			if (order != null) {
				((BSTree<Person>) ordersToProcess).search(order.getOrderID());
			}
		}
			break;

		case "Orders Processed": {
			System.out.print("What product do you want to search? Enter the product ID");
			Order orderprocessed = new Order();
			orderprocessed.readFromStdio();
			if (orderprocessed != null) {
				Order OrderID = new Order(orderprocessed.getOrderID());
				ordersProcessed.searchNode(OrderID);
			}
		}
			break;

		case "Customers": {
			System.out.print("What product do you want to search? Enter the product ID");
			Person customer = new Person();
			customer.readFromStdio();
			if (customer != null) {
				storeCustomers.search(customer.getId());
			}
		}
			break;

		case "Providers": {
			System.out.print("What product do you want to search? Enter the product ID");
			Provider provider = new Provider();
			provider.readFromStdio();
			if (provider != null) {
				storeProviders.search(provider.getName());
			}
		}
			break;

		case "Employees": {
			System.out.print("What product do you want to search? Enter the product ID");
			Person employee = new Person();
			employee.readFromStdio();
			if (employee != null) {
				storeEmployees.search(employee.getId());
			}
		}
			break;
		}
		return context;
	}

	public Object remove(String context) {
		Scanner input = new Scanner(System.in);
		System.out.println("Removing " + context);
		switch (context) {
		case "Stock": {
			StockableProduct info = new StockableProduct();
			info.readFromStdio();
			if (info != null) {
				if (numUnits > 0) {
					stock.remove(info.getProductID(), info.getNumUnits());
				}
			}
		}
			break;
		case "Orders to Process": {
			Order info = new Order();
			if (info != null) {
				ordersToProcess.dequeue().getOrderID();
			}
		}
			break;
		case "Orders Processed": {
			Order info = new Order();
			if (info != null) {
				ordersProcessed.extract().getOrderID();
			}
		}
			break;
		case "Customers": {
			System.err.println(context + ": removing Customers from Store is not allowed");
		}
			break;
		case "Providers": {
			System.err.println(context + ": removing Providers from Store is not allowed");
		}
			break;
		case "Employee": {
			System.err.println(context + ": removing Employees from Store is not allowed");
		}
			break;
		}
		return context;
	}

	public void modify(String context) {
		System.out.println("Modifying " + context);
		switch (context) {
		case "Stock":
			System.out.print("What product do you want to modify? Enter the product ID");
			Scanner input = new Scanner(System.in);
			int productID = input.nextInt();
			stock.modify(productID);
			break;

		case "Orders to Process":
			System.out.print("What order do you want to modify? Enter the order ID ");
			Scanner input2 = new Scanner(System.in);
			String orderID = input2.next();
			Order Neworder = new Order(ordersToProcess.toString()); // converts to string and then to order
			if (Neworder.getOrderID() == orderID) {
				modify(orderID);
			} // modifies the input2 and changes it for a new order that will be asked inside
				// modify method
			break;

		case "Orders Processed":
			System.out.print("What order do you want to modify? Enter the order ID ");
			Scanner input3 = new Scanner(System.in);
			String orderID2 = input3.next();
			Order neworder = new Order(orderID2);
			if (ordersProcessed.searchNode(neworder) != null) {
				modify(orderID2);
			}
			break;

		case "Customers":
			System.err.println(context + ": modifying customers from Store is not allowed");
			break;

		case "Providers":
			System.err.println(context + ": modifying providers from Store is not allowed");
			break;

		case "Employees":
			System.err.println(context + ": modifying employees from Store is not allowed");
			break;
		}
	}

	public void processOrders() throws Exception {
		BufferedReader input = null;
		String command = input.readLine();
		if (command != null) {

			String ORDERSTOPROCESS = ordersToProcess.toString();
			StockableProduct orderstoprocess = new StockableProduct(ORDERSTOPROCESS);
			Person o = new Person(ORDERSTOPROCESS);
			Provider p = new Provider(ORDERSTOPROCESS);
			if ((orderstoprocess.getProductID() == stock.getProductID())
					&& (((Order) orderstoprocess).getNumUnits() == stock.getNumUnits())
					&& (storeProviders.search(p.getName()) != null) && (storeEmployees.search(o.getId()) != null)) {
				if (storeCustomers.search(o.getId()) == null) {
					Person customer = new Person();
					customer.readFromStdio();
					storeCustomers.insert(customer, customer);
				}

				this.totalCost = ((ProductList) orderstoprocess).getTotalCost() + this.totalCost;
				this.totalBenefit = ((ProductList) orderstoprocess).getTotalBenefit() + this.totalBenefit;
				this.numUnits = stock.getNumUnits() - orderstoprocess.getNumUnits();

				String ORDERSPROCESSED = ordersProcessed.toString();
				ORDERSPROCESSED = ordersProcessed.toString() + ordersToProcess.toString();
			}

			else {
				throw new Exception("A condition was not met ");
			}
		}
	}

}