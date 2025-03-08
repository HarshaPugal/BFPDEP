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
//		System.out.println(individualCount);
		Map<String,ArrayList<String>> result=Segmentation.partition(individualCount, data);
		ArrayList<String>updated=result.get("updated");
		ArrayList<String>actual=result.get("actual");
		ArrayList<String>discard=result.get("discard");
		System.out.println("updated="+updated);
		ArrayList<Integer> uindividualCount=IC.individualCount(uFilePath);
//		System.out.println(uindividualCount);
		ArrayList<ArrayList<Integer>> actualBvr=BVR.bitVector(uniqueList, actual);
		ArrayList<ArrayList<Integer>> discardBvr=BVR.bitVector(uniqueList, discard);
		System.out.println("Actual BVR");
		for(int i=0;i<actualBvr.size();i++) {
		System.out.println(uniqueList.get(i)+"="+actualBvr.get(i));
		}
		System.out.println("Discard BVR");
		for(int i=0;i<discardBvr.size();i++) {
		System.out.println(uniqueList.get(i)+"="+discardBvr.get(i));
		}
	}
}

