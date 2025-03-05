package BFPDEP;
import java.util.*;
public class MainClass {
    public static String filePath="Database/sample.csv";
	public static void main(String[] args) {
		int j;
		String[] data=FileRead.readFile(filePath);	
		Integer[] ic=IC.individualCount();
		for(j=0;j<ic.length;j++) {
			System.out.print(ic[j]+" ");
		}
	
	}
}
