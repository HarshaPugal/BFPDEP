package BFPDEP;
import java.util.*;
public class MainClass {
    public static String filePath="Database/sample.csv";
    public static String uFilePath="Database/updated.csv";
	public static void main(String[] args) {
		ArrayList<String> data=FileRead.readFile(filePath);	
		ArrayList<Integer> uniqueList=UniqueItems.uniqueItem(data);
		System.out.println("unique="+uniqueList);
		System.out.println("Original="+data);
		ArrayList<Integer> individualCount=IC.individualCount(filePath);
		System.out.println(individualCount);
		ArrayList<String> updated=Segmentation.partition(individualCount, data);
		System.out.println("updated="+updated);
		ArrayList<Integer> uindividualCount=IC.individualCount(uFilePath);
		System.out.println(uindividualCount);
	}
}

