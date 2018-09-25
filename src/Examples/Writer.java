package Examples;

import java.io.FileWriter;
import java.io.IOException;

public class Writer {

	public static void main(String[] args) throws IOException {
		
		FileWriter w = new FileWriter("output.txt");
		w.write("Hello world. 2018/9/25");
		
		w.flush();
		
		/*
		 * autoclose
		try(FileWriter w = new FileWriter("output.txt")){
			w.write("Hello world. 2018/9/25");
		}
		*/
	
	}

}
