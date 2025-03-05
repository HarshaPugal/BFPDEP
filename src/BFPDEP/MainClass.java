package BFPDEP;
import java.util.*;
public class MainClass {
    public static String filePath="Database/sample.csv";
	public static void main(String[] args) {
		int j;
		String[] data=FileRead.readFile(filePath);
//		for(j=0;j<data.length;j++) {
//			System.out.println(data[j]);
//		}
	IC.individualCount();
	
	}
}
