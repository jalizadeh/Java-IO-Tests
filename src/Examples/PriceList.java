package Examples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class PriceList {
	
	public static void main(String[] args) {
		
		try {
			//readPrices();
			List<Item> is = readPricesStreamScanner();
			for(Item i : is) {
				System.out.println(i.getName() + ": " + i.getPrice());
				System.out.checkError();
			}
		} catch (IOException e) {
			System.err.println("ERROR: " + e.getMessage());
			
		}
		
	}
	
	void readPrices(String filename) throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("price.txt"));
		BufferedReader br = new BufferedReader(new FileReader(filename));
		
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
	
	
	 public static List<Item> readPricesItem(String filename) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
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
	
	
	static List<Item> readPricesStream() throws IOException {
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
	
	
	
	static List<Item> readPricesStreamRE() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("price.txt"));
		return br.lines()
				.map(line ->{
												//+space removers
					Pattern p = Pattern.compile("(?<=^|;)[ \t]*([^;]*)[ \t]*(?=;|$)");
					Matcher m = p.matcher(line);
					//I know the results, so won`t need to use while(m.find())
					m.find(); //this will find the name
					String name = m.group(1);
					m.find(); //this will find the price
					Double price = 0.0;
					try {
						price = Double.parseDouble(m.group(1));
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
					
					return new Item(name, price);
				})
				.collect(Collectors.toList())
				;
	}
	
	
	
	static List<Item> readPricesStreamScanner() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("price.txt"));
		return br.lines()
				.map(line ->{
					//Scanner is not very good with white spaces
					Scanner s = new Scanner(line);
					s.useDelimiter(";");
					
					String name = s.next();
					Double price = 0.0;
					try {
						price = s.nextDouble();
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
					
					return new Item(name, price);
				})
				.collect(Collectors.toList())
				;
	}
	
}
