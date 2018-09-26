package Examples;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class URLex {

	public static void main(String[] args) throws IOException {
		URL home = new URL("http://www.jalizadeh.com/"); 
		URLConnection con =	home.openConnection(); 
		String ctype =con.getContentType(); 
		if(ctype.equals("text/html")){ 
		  InputStreamReader r = new	InputStreamReader(con.getInputStream()); 
		  OutputStreamWriter w = new OutputStreamWriter(System.out); 
		  char[] buffer = new char[4096]; 
		  while(true){ 
			  int n = r.read(buffer); 
			  if(n==-1) break; 
			  w.write(buffer,0,n); 
			  System.err.println(w.toString().length() +":"+ n);
		  } 
		  
		  r.close();
		  w.close(); 
		} 
	}
}
