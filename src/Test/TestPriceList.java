package Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import Examples.Item;
import Examples.PriceList;
import junit.framework.TestCase;

public class TestPriceList extends TestCase {
	
	public void testReadPricesFileNotFound() {
		
		//this name is very abnormal
		String filename = "NONExistingFileName.txt";
		
		//what if someone create it?
		//let`s delete it first
		File  nonexiting = new File(filename);
		if(nonexiting.exists()) {
			nonexiting.delete();
		}
		
		//now let`s test it
		try {
			PriceList.readPricesItem(filename);
			
			//exists? so it fails
			fail("The file is not existing!!!");
		}catch (FileNotFoundException e) {
			//OK. as we expected
			assertTrue(true);
			
		} catch (IOException e) {
			fail("Unexpected error happened: " + e.getMessage()	);
			
		}
		
	}
	
	
	
	
	
	public void testReadPrices() throws IOException {
		
		/*
		//I want to test the recived size
		//what if someone changes the lines, add or delete?
		//let`s make it dynamic
		List<Item> items = PriceList.readPricesItem("price.txt");
		assertEquals(4, items.size());
		*/
		
		
		File tmp = null ;
		
		try {
			tmp = File.createTempFile("data", ".txt");
			String content = "Bread;1\r\n" + 
					"Oil;2.3\r\n" + 
					"Meat;5.0\r\n" + 
					"Tomato;1.3";
			
			FileWriter w = new FileWriter(tmp);
			w.write(content);
			w.close();
			
			List<Item> items = PriceList.readPricesItem(tmp.getAbsolutePath());
			
			assertEquals(4, items.size());
			
		} finally {
			//delete at the end
			tmp.delete();
		}
	} 
	
}
