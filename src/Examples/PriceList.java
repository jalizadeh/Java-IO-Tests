package Examples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class PriceList {
	
	public static void main(String[] args) {
		
		try {
			readPrices();
		} catch (IOException e) {
			System.err.println("ERROR: " + e.getMessage());
		}
		
	}
	
	static void readPrices() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("price.txt"));
		
		String line;
		Double total = 0.0;
		
		while((line = br.readLine()) != null) {
			String[] elements = line.split(";");
			String name = elements[0];
			
			//what if the input data is not valid?
			try {
				Double price = Double.parseDouble(elements[1]);
				total += price;
				System.out.println(name + ":\t" + price);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		System.err.println("\nTotal:\t" + total);
		br.close();
	} 
	
	
	static List<Item> readPricesItem() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("price.txt"));
		LinkedList<Item> res = new LinkedList<>();
		
		String line;
		Double total = 0.0;
		
		while((line = br.readLine()) != null) {
			String[] elements = line.split(";");

			//OR 
			//using the factory method 
			//String name = elements[0];
			
			//what if the input data is not valid?
			try {
				//Double price = Double.parseDouble(elements[1]);
				
				//Item i = new Item(name, price);
				//res.add(i);
				
				res.add(Item.newItem(elements));
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		System.err.println("\nTotal:\t" + total);
		br.close();
		return res;
	} 
	
	
	static List<Item> readPricesStsream() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("prices.txt"));
		return br.lines()
				.map(line -> line.split(";"))
				/*
				 * OR 
				 * using a more compact form
				.forEach( element -> {
					String name = element[0];
					Double price = Double.parseDouble(element[1]);
					System.out.println(name + ":\t" + price);
				});
				*/
				.map(Item::newItem)
				.collect(Collectors.toList())
				;
			
	}
	
}
