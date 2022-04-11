package Assignment3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static processing.core.PApplet.println;

public class TestPhase5 {
	public static void main(String [] args) throws IOException {
		
		// Nothing we can test here!
		// Specify your own constructors, and test the toStrings
		// of the various types!
//		System.out.println(String.format("ID: %d, Weight: %4d kg",100000000,50));
//		System.out.println(String.format("ID: %d, Weight: %4d kg",100000000,150));
//		String s="o21234";
//		Integer.parseInt(s);
//		Cargo G=new Cargo(0.5);
//		ArrayList<Cargo> al=new ArrayList<Cargo>();
//		al.add(G);
//		al.get(0).weight=0.4;
//		println(G.weight);
		//test result: only object reference added to arraylist!
		String C1="CREATE-FLIGHT";
		String C11="C",C12="I";
		String C2="GET-FLIGHT";
		FileWriter newFile=new FileWriter("newdata.txt");
		newFile.write("RELALY");
		newFile.close();
	}

}
