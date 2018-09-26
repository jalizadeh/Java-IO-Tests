package Examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SandardIO {
	public static void main (String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		System.out.println("Buffered Reader: " + line);
		
		//or with a scanner
		Scanner s = new Scanner(System.in);
		line = s.nextLine();
		System.out.println("Scanner nextLine: " + line);
		
		int i = s.nextInt();
		System.out.println("Scanner nextInt: "+ i);
		
	}
}
