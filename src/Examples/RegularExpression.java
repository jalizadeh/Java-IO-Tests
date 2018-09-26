package Examples;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
	public static void main(String[] args) {
		
		Pattern intPattern = Pattern.compile("[+-]?[1-9][0-9]*|0");
		Matcher m = intPattern.matcher("0");
		
		if(m.matches()) {
			System.out.println("Yes matched");
		} else {
			System.err.println("No matched");
		}
		
		
		System.out.println("\n\n");
		
		
		//symbol "." must be written with "\\"
		//one backslash, means a special character, like "\n"
		Pattern floatPattern = Pattern.compile("([+-]?[1-9][0-9]*|0)\\.[0-9]+");
		System.out.println("floatPattern Regex: " + floatPattern.toString());
		
		//**this pattern will never match, parentheses must be put correctly
		//Pattern floatPattern = Pattern.compile("[+-]?[1-9][0-9]*|0\\.[0-9]+");
		
		Matcher mf = floatPattern.matcher("3.1415");
		
		if(mf.matches()) {
			System.out.println("Yes matched");
		} else {
			System.err.println("No matched");
		}
		
		
		
		System.out.println("\n\n");
		
		
		
		//with method "group()" it is possible to separate the matched parts
		//but at first define the groups by parentheses
		//group(0) is the whole matched string
		//RULE: each opening parentheses is equal to a new group
													// V--1--VV-----2-------V   V--3---V
		Pattern groupedFloatPattern = Pattern.compile("([+-]?)([1-9][0-9]*|0)\\.([0-9]+)");

		
													  //        V--------------2-----------V
													  // V--1--V v-----3-------v   v--4---v
		//Pattern groupedFloatPattern = Pattern.compile("([+-]?)(([1-9][0-9]*|0)\\.([0-9]+))");
		mf = groupedFloatPattern.matcher("+3.1415");
				
		if(mf.matches()) {
			String whole = mf.group(0); // = m.group()
			String sign = mf.group(1);
			String intPart = mf.group(2);
			String decPart = mf.group(3);
			System.out.println("Whole matched string: " + whole);
				System.out.println("\tsign: " + sign);
				System.out.println("\tint: " + intPart);
				System.out.println("\tdec: " + decPart);
		} else {
			System.err.println("No matched");
		}
		
		
		
		System.out.println("\n\n");
		
		
		
		mf = groupedFloatPattern.matcher("hello 3.1415 world");
		
		if(mf.find()) {
			String found = mf.group(); // = m.group(0)
			System.out.println("hello 3.1415 world");
			System.out.println("Found string: " + found);
		} else {
			System.err.println("No matched found");
		}
		
		
		
		System.out.println("\n\n");
		
		
		//find() starts from the last point
		String csv = "John,Smith,1234";
		Pattern csvPattern = Pattern.compile("[^,]+");
		Matcher mcsv = csvPattern.matcher(csv);
		
		while(mcsv.find()) {
			System.out.println("Element: " + mcsv.group());
		}
		
		
		System.out.println("\n\n");
		
		
		//What if first name is quoted
		String qcsv = "\"John,Albert\",Smith,1234";
		csvPattern = Pattern.compile("(\".+\")|([^,]+)");
		mcsv = csvPattern.matcher(qcsv);
		
		while(mcsv.find()) {
			
			System.out.println("Element: " + mcsv.group());
		}
		
		
	}
}
