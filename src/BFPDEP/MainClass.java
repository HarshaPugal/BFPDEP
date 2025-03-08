package BFPDEP;
import java.util.*;
public class MainClass {
    public static String filePath="Database/mushroom.csv";
	public static void main(String[] args) {
		String[] data=FileRead.readFile(filePath);	
		Integer[] individualCount=IC.individualCount(filePath);
		System.out.println(Arrays.toString(data));
		System.out.println(Arrays.toString(individualCount));
	}
}
