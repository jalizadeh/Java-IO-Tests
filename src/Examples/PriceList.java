package Examples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


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
	
}
