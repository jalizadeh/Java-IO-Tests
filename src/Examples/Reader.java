package Examples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

public class Reader {

	/**
	 * EOF: End Of File
	 */
	private static final int EOF = -1;

	public static void main(String[] args) throws IOException {


		FileReader r = new FileReader("input.txt");
		
		int element = r.read();
		//data is read as int
		//element : 	0x00 	0x00 	0x00 	0x40
		//								^----------^
		
		//then it has to be converted
		char ch = (char) element;
		//ch:	0x00	0x40
		
		//at the end of the file it becomes -1
		//element: 	0xFF	0xFF	0xFF	0xFF
		
		while(element != EOF) {
			System.out.print(ch);
			element  = r.read();
			ch = (char) element;
		}
		
		r.close();
		
		
		System.err.println("\n----------------\n");
		
		
		r = new FileReader("input.txt");
		
		//2KB buffer
		char[] buffer = new char[2048];
		
		int nChar = 0;
		
		while(true) {
			nChar = r.read(buffer);
			if(nChar == EOF)
				break;
			
			String s = new String(buffer, 0, nChar);
			System.out.print(s);
		}
		
		r.close();
		

		
		System.err.println("\n----------------\n");
		
		
		
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		
		String line;
		while((line = br.readLine()) != null) {
			System.out.println(line);
		}
	}

}
